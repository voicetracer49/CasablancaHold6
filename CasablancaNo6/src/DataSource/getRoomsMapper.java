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
    private int roid;
    private int rono;
    private String roty;
    
    public getRoomsMapper(Connection con) {
        this.con = con;
            
    }

   
    public AvailableRooms getAvailableRooms(AvailableRooms ar) {
        System.out.println(ar.getCheckIn());
        System.out.println(ar.getCheckOut());     
        String SQLString1
                = "Select ROOMID, ROOMNO, ROOMTYPE From G6_Rooms "
                + " where RoomID not in "
                + "(Select RoomID From G6_RESERVATION b "
                + " Where((b.CheckIn <= to_date(?,'YYYY-MM-DD') and to_date(?,'YYYY-MM-DD') <= b.Checkout )"
                + " or (b.CheckIn <= to_date(?,'YYYY-MM-DD') and to_date(?,'YYYY-MM-DD') <= b.Checkout )"
                + " or (b.CheckIn >= to_date(?,'YYYY-MM-DD') and to_date(?,'YYYY-MM-DD') >= b.Checkout )"
                + " or (b.CheckIn >= to_date(?,'YYYY-MM-DD') and to_date(?,'YYYY-MM-DD') >= b.Checkout )))"
                + " order by ROOMNO ";
        PreparedStatement statement = null;

        try {      //== insert tuple
            
            statement = con.prepareStatement(SQLString1);
            statement.setString(1, ar.getCheckIn());
            statement.setString(2, ar.getCheckOut());
            statement.setString(3, ar.getCheckIn());
            statement.setString(4, ar.getCheckIn());
            statement.setString(5, ar.getCheckOut());
            statement.setString(6, ar.getCheckOut());
            statement.setString(7, ar.getCheckIn());
            statement.setString(8, ar.getCheckOut());
            ResultSet rs;
            rs = statement.executeQuery();
                while (rs.next())
                {
                roid =rs.getInt(1);    
                rono =rs.getInt(2);
                roty =rs.getString(3);
               ar.setARooms(roid, rono, roty);     
//                    System.out.println(rono +" " +roty);  
                }
            System.out.println("3");

            
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
                System.out.println("Fail in  xxx getRoomsMapper - getAvailableRooms");
                System.out.println(e.getMessage());
            }
            
        }
        return ar; // ?  
    
    }
}
