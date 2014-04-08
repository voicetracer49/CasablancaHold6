
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

//    //== Insert new order (tuple)
//    public boolean saveNewGuest(Guests res, Connection con)
//    {
//        int rowsInserted = 0;
//        String SQLString1 =
//                "select reservationseq.nextval from dual";
//        String SQLString2 =
//                "insert into G6_Guests values (?,?,?,?,?,?,?,?,?,?,? )";
//        String SQLString3 =
//                "insert into G6_GuestsReservation values (?,?)";
//        
//        PreparedStatement statement = null;
//
//        try
//        {
//            //== get unique ono
//            statement = con.prepareStatement(SQLString1);
//            ResultSet rs = statement.executeQuery();
//            if (rs.next())
//            {
//                res.setOno(rs.getInt(1));
//            }
//
//            //== insert tuple
//            statement = con.prepareStatement(SQLString2);
//            statement.setInt(1, res.getOno());
//            statement.setInt(2, res.getCustomerNo());
//            statement.setInt(3, res.getEmployeeNo());
//            statement.setString(4, res.getReceived());
//            statement.setString(5, res.getShipped());
//            rowsInserted = statement.executeUpdate();
//        } catch (Exception e)
//        {
//            System.out.println("Fail in OrderMapper - saveNewReservation");
//            System.out.println(e.getMessage());
//        } finally // must close statement
//        {
//            try
//            {
//                statement.close();
//            } catch (SQLException e)
//            {
//                System.out.println("Fail in OrderMapper - saveNewreservation");
//                System.out.println(e.getMessage());
//            }
//        }
//        return rowsInserted == 1;
//    }
}
