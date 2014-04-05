/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataSource;
import Domain.AvailableRooms;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author Anders Kjær
 */
public class getRoomsMapper {
    private final Connection con;
    
    public getRoomsMapper(Connection con) {
        this.con = con;
    }

    public AvailableRooms getAvailableRooms(AvailableRooms ar) {
        System.out.println(ar.getCheckIn());
               
        String SQLString1
                = "Select RoomID, ROOMNO, ROOMTYPE From G6_Rooms "
                + "where RoomID not in "
                + "(Select RoomID From G6_RESERVATION b "
                + " Where((b.CheckIn <= to_date(?,'YYYY-MM-DD') and to_date(?,'YYYY-MM-DD') <= b.Checkout )"
                + " or (b.CheckIn <= to_date(?,'YYYY-MM-DD') and to_date(?,'YYYY-MM-DD') <= b.Checkout )"
                + " or (b.CheckIn >= to_date(?,'YYYY-MM-DD') and to_date(?,'YYYY-MM-DD') >= b.Checkout )"
                + " or (b.CheckIn >= to_date(?,'YYYY-MM-DD') and to_date(?,'YYYY-MM-DD') >= b.Checkout )))"
                + " order by ROOMNO ";
        PreparedStatement statement = null;

        try {      //== insert tuple
            
            statement = con.prepareStatement(SQLString1);
            statement.setDate(1, ar.getCheckIn());
            statement.setDate(2, ar.getCheckOut());
            statement.setDate(3, ar.getCheckIn());
            statement.setDate(4, ar.getCheckIn());
            statement.setDate(5, ar.getCheckOut());
            statement.setDate(6, ar.getCheckOut());
            statement.setDate(7, ar.getCheckIn());
            statement.setDate(8, ar.getCheckOut());
            System.out.println("1");
            ResultSet rs = statement.executeQuery();
            System.out.println("2");
            while(rs.next()){
                
                
            }

            
        } catch (SQLException e) {
            
                System.out.println("Fail in getRoomsMapper - getAvailableRooms");
                System.out.println(e.getMessage());
            
        } finally // must close statement
        {
            try {
                if(statement != null){
                    statement.close();
                }
                
            } catch (SQLException e) {
                System.out.println("Fail in getRoomsMapper - getAvailableRooms");
                System.out.println(e.getMessage());
            }
        }
        return ar;
    }
}
