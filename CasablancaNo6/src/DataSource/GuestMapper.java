
package DataSource;
import Domain.Guests;
import Domain.Relation;
import Domain.ListOfGuests;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Ruben Juul
 */
public class GuestMapper
{//== load a Guest and the associated Guest details
//private final Connection con;
private final Connection con;
    private int GuestId;
  
    public GuestMapper(Connection con) {
        this.con = con;            
    }
    
///////////////////////////////////////////////////////////////////////////////////////////////////////
    public ListOfGuests getListOfGuests(ListOfGuests gList, Connection con){
        
//        ListOfGuests gList = null;
        String SQLString1 = // get order
                "select * "
                + "from G6_Guests ";
//                + "where GuestId = ?";
    
        PreparedStatement statement = null;
      
        try {      //== insert tuple
            ResultSet rs;
            rs = statement.executeQuery();
                while (rs.next())
                {
                int guestId = rs.getInt(1);    
                String fName = rs.getString(2);
                String lName = rs.getString(3);
                String address = rs.getString(4);
                int phoneNo = rs.getInt(5);
                String email = rs.getString(6);
                String country = rs.getString(7);
                int passportNo = rs.getInt(8);
                String travelAgency = rs.getString(9);
                String pinCode = rs.getString(10);
                int activityBookingId = rs.getInt(11);
              
                        gList.setListOfGuests(guestId, fName, lName, address, phoneNo, email, country, passportNo, travelAgency, pinCode, activityBookingId);     
//                    System.out.println(rono +" " +roty);  
                }
            System.out.println("3");

            
        } catch (Exception e) {
            System.out.println("Fail in  Mapper - getGuestList");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in Mapper -  getGuestList");
                System.out.println(e.getMessage());
            }
        }
        return gList;
    }

    //== Insert new order (tuple)
    public boolean saveNewGuest(Guests g, Connection con)
    {
        
        int rowsInserted = 0;
        String SQLString1 =
                "select G6_GUE_SEQ.NEXTVAL from DUAL";
        String SQLString2 =
                "insert into G6_Guests values (?,?,?,?,?,?,?,?,?,?,? )";
      
//        String SQLString3 =
//                "insert into G6_GuestsReservation values (?,?)";  //guest/reservation relation ?       
        PreparedStatement statement = null;
        try
        {
            //== get unique ono
            statement = con.prepareStatement(SQLString1);
            ResultSet rs = statement.executeQuery();
            if (rs.next())
            {
                g.setGuestId(rs.getInt(1));
            }
            //== insert tuple
            statement = con.prepareStatement(SQLString2);
            statement.setInt(1, g.getGuestId());
            statement.setString(2, g.getfName());   //høj cobling -< tilgår Guest direkte ¤_¤??
            statement.setString(3, g.getfName());
            statement.setString(4, g.getAddress());
            statement.setInt(5, g.getPhoneNo());
            statement.setString(6, g.getEmail());
            statement.setString(7, g.getCountry());
            statement.setInt(8, g.getPassportNo());
            statement.setString(9, g.getTravelAgency());
            statement.setString(10, g.getPinCode());
            statement.setInt(11, g.getActivityBookingId());
            // class Guests -> sætter via controller SQLString2 Statement   
            rowsInserted = statement.executeUpdate();  
            
            
//            statement = con.prepareStatement(SQLString3);
////            Reservation re; 
//            
//            statement.setInt(1, g.getGuestId());
//            statement.setInt(2, re.getReservationID());
//            rowsInserted = statement.executeUpdate();
            System.out.println(rowsInserted + " row Inserted in G6_Guest ");
//            
           
            
        } catch (Exception e)
        {
            System.out.println("Fail in GuestMapper - saveNewGuest");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail in GuestMapper - saveNewGuest");
                System.out.println(e.getMessage());
            }
        }
        return rowsInserted == 1;
    }
    
//    public Relation saveRelation(int guestId, int ReservationId, Connection con){
//        
//        Relation rel = null;
//        String SQLString1 = // get order
//                "select * "
//                + "from G6_Guests ";
////                + "where GuestId = ?";
//    
//        PreparedStatement statement = null;
//
//        try {
//            //=== get Guest
//            statement = con.prepareStatement(SQLString1);
////            statement.setInt(1, GuestId);     // primary key value  // kunne evt. laves om til :: Where lName starts with ?
//            ResultSet rs = statement.executeQuery();
//            if (rs.next()) {//=== get Guests details
//                   
//            }
//        } catch (Exception e) {
//            System.out.println("Fail in  GuestMapper - save Relation");
//            System.out.println(e.getMessage());
//        } finally // must close statement
//        {
//            try {
//                statement.close();
//            } catch (SQLException e) {
//                System.out.println("Fail in Mapper -   save Relation");
//                System.out.println(e.getMessage());
//            }
//        }
//        return rel;
//    }
    
    
    
    
}

