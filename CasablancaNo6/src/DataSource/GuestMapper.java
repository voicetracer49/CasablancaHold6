
package DataSource;
import Domain.Guests;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
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

    public Guests getGuests(int guestId, Connection con){
        
        Guests g = null;
        String SQLString1 = // get order
                "select * "
                + "from G6_Guests "
                + "where GuestId = ?";
    
        PreparedStatement statement = null;

        try {
            //=== get Guest
            statement = con.prepareStatement(SQLString1);
            statement.setInt(1, GuestId);     // primary key value  // kunne evt. laves om til :: Where lName starts with ?
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {//=== get Guests details
                g = new Guests(guestId,  //1  int guestId
                        rs.getString(2), //2  String fName;
                        rs.getString(3), //3  String lName;
                        rs.getString(4), //4  String address;
                        rs.getInt(5),    //5  int phoneNo;
                        rs.getString(6), //6  String email;
                        rs.getString(7), //7  String country;
                        rs.getInt(8),    //8  int passportNo;
                        rs.getString(9), //9  String travelAgency;
                        rs.getString(10), //10 String pinCode;
                        rs.getInt(11));  //11 int activityBookingId; 
                       /*
                       g = GuestId + de 10 resterende atributter i Tabellen G6_Guest !
                        */    
            }
        } catch (Exception e) {
            System.out.println("Fail in OrderMapper - getOrder");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in OrderMapper - getOrder");
                System.out.println(e.getMessage());
            }
        }
        return g;
    }

    //== Insert new order (tuple)
    public boolean saveNewGuest(Guests g, Connection con)
    {
        int rowsInserted = 0;
        String SQLString1 =
                "select reservationseq.nextval from dual";
        String SQLString2 =
                "insert into G6_Guests values (?,?,?,?,?,?,?,?,?,?,? )";
//        String SQLString3 =
//                "insert into G6_GuestsReservation values (?,?)";  // afhængig af transaktions rekkefølge! oprette guest/reservation Først ?       
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
            
        } catch (Exception e)
        {
            System.out.println("Fail in OrderMapper - saveNewReservation RJ");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail in OrderMapper - saveNewGuest RJ");
                System.out.println(e.getMessage());
            }
        }
        return rowsInserted == 1;
    }
}
