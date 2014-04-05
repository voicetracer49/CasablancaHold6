/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataSource;

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
                + " Where((b.CheckIn <= to_date('04-SEP-99','DD-MON-YY') and to_date('10-SEP-99','DD-MON-YY') <= b.Checkout ) \n"
                + " or (b.CheckIn <= to_date('04-SEP-99','DD-MON-YY') and to_date('04-SEP-99','DD-MON-YY') <= b.Checkout ) \n"
                + " or (b.CheckIn >= to_date('10-SEP-99','DD-MON-YY') and to_date('10-SEP-99','DD-MON-YY') >= b.Checkout ) \n"
                + " or (b.CheckIn >= to_date('04-SEP-99','DD-MON-YY') and to_date('10-SEP-99','DD-MON-YY') >= b.Checkout ))) \n"
                + " order by G6_Rooms.ROOMNO; "
                + "values (?,?,?,?,?)";
        PreparedStatement statement = null;

        try {
            //== get unique ono
            statement = con.prepareStatement(SQLString1);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                o.setOno(rs.getInt(1));
            }

            //== insert tuple
            statement = con.prepareStatement(SQLString2);
            statement.setInt(1, o.getOno());
            statement.setInt(2, o.getCustomerNo());
            statement.setInt(3, o.getEmployeeNo());
            statement.setString(4, o.getReceived());
            statement.setString(5, o.getShipped());
            rowsInserted = statement.executeUpdate();
            con.commit();
        } catch (SQLException e) {
            try {
                con.rollback();
                System.out.println("Fail in OrderMapper - saveNewOrder");
                System.out.println(e.getMessage());
            } catch (SQLException ex) {
                Logger.getLogger(OrderMapper.class.getName()).log(Level.SEVERE, null, ex);
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
