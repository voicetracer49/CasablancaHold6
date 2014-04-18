
package DataSource;

import Domain.Reservation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import Domain.Relation;
import java.util.ArrayList;

public class ReservationMapper
{
//=== Maps between objects and tables
//=== Encapsulates SQL-statements

private int reservationID;
private final Connection con;

    public ReservationMapper(Connection con) {
        this.con = con;
    }


    //== Insert new order (tuple)
    public Reservation getReservation(int reservationID, Connection con)
    {
        Reservation r = null;
       String SQLString1 = // get order
                "select * "
                + "from G6_Reservation "
                + "where reservationId = ?";
    
        PreparedStatement statement = null;

       try{
       statement = con.prepareStatement(SQLString1);
            statement.setInt(1, reservationID);     // primary key value  // kunne evt. laves om til :: Where lName starts with ?
            ResultSet rs = statement.executeQuery();
            if (rs.next())
                {//=== get Reservation details
                r = new Reservation(reservationID,
                        rs.getInt(1),               //1  int reservationId
                        rs.getInt(2),               //2  int roomID;
                        rs.getString(3),              //3 DATE checkIn
                        rs.getString(4),             //4 DATE checkOut
                        rs.getBoolean(5));           //5 boolean confirmed
                        }
       }catch(Exception e){
            System.out.println("Fail");
            System.out.println(e.getMessage());
       }finally
            {
                    try{
                    statement.close();
                    }catch (SQLException e) {
                System.out.println("Fail");
                System.out.println(e.getMessage());
            }
        }
        return r;
                    
       }
        //== Insert new order (tuple)
    public boolean saveNewReservation(Reservation r, Connection con)
    {
        
        int rowsInserted = 0;
//       String SQLString0 ="    "; // lock funktion!
        
        String SQLString1 =
                "select G6_RES_SEQ.NEXTVAL from DUAL";
        
        String SQLString2 =
                "insert into G6_Reservation values (?,?,?,?,?)";
        
        String SQLString3 =
                "insert into G6_GuestsReservation values (?,?)" //  Asociations tabel At linke Guest med reservation!
               ;
        PreparedStatement statement = null;

        try
        {
            //== get unique ReservationId: r.getReservationID()
            statement = con.prepareStatement(SQLString1);
            ResultSet rs = statement.executeQuery();
            if (rs.next())
            {
                r.setReservationID(rs.getInt(1));
            }
           
            //== insert tuple into G6_Reservation
            statement = con.prepareStatement(SQLString2);
            statement.setInt(1, r.getReservationID());
            statement.setInt(2, r.getRoomID());
            statement.setString(3, r.getCheckIn());
            statement.setString(4, r.getCheckOut());
            statement.setBoolean(5, r.isConfirmed());
            rowsInserted = statement.executeUpdate();
            
            //== insert tuple insert into G6_GuestReservation
            statement = con.prepareStatement(SQLString3);
            statement.setInt(1, r.getGuestIdToReservation()); // her hentes specielt Guest ID fra Jlist i gui og medsendes Objectet r
            statement.setInt(2, r.getReservationID());
            rowsInserted = statement.executeUpdate();
         
        } catch (Exception e)
        {
            System.out.println("Fail");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail");
                System.out.println(e.getMessage());
            }
        }
        
        System.out.println("G6_RES_SEQ Inserted into G6_Reservation + " + rowsInserted + " Row into G6_GuestReservation :-) ");
        return rowsInserted == 1;   // evt. tilbage til Gui, som egentlig "sikker" confirm af reservation!
        
    }
   ////////////////CONFIRM RESERVATION AFTERWARDS THE RESERVATION HAS BEEN MADE
    public boolean setConfirm(int reservationID, boolean confirmed, Connection con )
    { // Boolean confirmed true/false = svarende til f.eks 0 eller 1 
        int confirmUpdated = 0;
        
        String SQLString1 =
                "insert into update values ? confirmed  where reservationId = ? in G6_Reservation ";
       
        PreparedStatement statement = null;
        
        try{
        statement = con.prepareStatement(SQLString1);
            statement.setBoolean(1,confirmed);
            statement.setInt(2, reservationID);
        
        confirmUpdated = statement.executeUpdate();
         
        } catch (Exception e)
        {
            System.out.println("NOT SUPORTED YET !!!!");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail");
                System.out.println(e.getMessage());
            }
        }
        return confirmUpdated ==1;
    } 

    public boolean setNewRoom(int reservationID, int roomId, Connection con) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<Object> getGuestsReservations(int guestId, Connection con) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean setNewDates(String checkIn, String checkOut, Connection con){
        int datesUpdated = 0;
        
        
        
        return datesUpdated ==1;
    }
}

   