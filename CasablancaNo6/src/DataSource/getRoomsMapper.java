/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataSource;
import oracle.sql.DATE;
import Domain.AvailableRooms;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anders Kjær
 */
public class getRoomsMapper {
    private final Connection con;
    
    public getRoomsMapper(Connection con) {
        this.con = con;
    }

    public boolean getRoomsMapper(AvailableRooms ar) {
        int rowsInserted = 0;        
        String SQLString1
                = "Select RoomID, ROOMNO, ROOMTYPE From G6_Rooms \n"
                + "where RoomID not in \n"
                + "(Select RoomID From G6_RESERVATION b \n"
                + " Where((b.CheckIn <= to_date('?','DD-MON-YY') and to_date('?','DD-MON-YY') <= b.Checkout )"
                + " or (b.CheckIn <= to_date('?','DD-MON-YY') and to_date('?','DD-MON-YY') <= b.Checkout )"
                + " or (b.CheckIn >= to_date('?','DD-MON-YY') and to_date('?','DD-MON-YY') >= b.Checkout )"
                + " or (b.CheckIn >= to_date('?','DD-MON-YY') and to_date('?','DD-MON-YY') >= b.Checkout )))"
                + " order by G6_Rooms.ROOMNO; ";
        PreparedStatement statement = null;

        try {      //== insert tuple
            statement = con.prepareStatement(SQLString1);
            statement.setDate(1, ar.getCheckIn());
            statement.setDate(2, ar.getCheckIn());
            statement.setDate(3, ar.getCheckIn());
            statement.setDate(4, ar.getCheckIn());
            statement.setDate(5, ar.getCheckOut());
            statement.setDate(6, ar.getCheckOut());
            statement.setDate(7, ar.getCheckIn());
            statement.setDate(8, ar.getCheckOut());
            rowsInserted = statement.executeUpdate();
            con.commit();
        } catch (SQLException e) {
            try {
                con.rollback();
                System.out.println("Fail in OrderMapper - saveNewOrder");
                System.out.println(e.getMessage());
            } catch (SQLException ex) {
                Logger.getLogger(ReservationMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally // must close statement
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in OrderMapper - saveNewOrder");
                System.out.println(e.getMessage());
            }
        }
        return rowsInserted == 1;
    }

}
