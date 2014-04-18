package DataSource;

import Domain.AvailableRooms;
import Domain.Guests;
import Domain.ListOfGuests;
import Domain.Reservation;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Anders Kjær, Ruben Juul, Marcus Ulsø
 */
// Encapsulates the Data Source Layer
// Encapsulates connection handling 
// Implemented as a Singleton to provide global access from
// Domain classes and to ensure the use of max one connection

public class DBFacade {

    private ReservationMapper rm;
    private Connection con;
    private getRoomsMapper arm;
    private GuestMapper gm;

    //== Singleton start
    private static DBFacade instance;

    public DBFacade() {
        rm = new ReservationMapper(con); // http://dadicy.wordpress.com/2007/10/29/what-do-you-mean-by-static-in-java/
        con = new DBConnector().getConnection();  // the connection will be released upon program 
        arm = new getRoomsMapper(con);
        gm = new GuestMapper(con);  // termination by the garbage collector		  
    }

    public static DBFacade getInstance() {
        if (instance == null) //er instance = null , så laver den en ny instance af DBFacade
        {
            instance = new DBFacade();
        }
        return instance;  // den kan altså ikke lave flere instanser af DBFacade end der allerede er
    }
	  //== Singleton end!

    ///////////////////////////////////////////////Reservations ///////////////////////////7
    public Reservation getReservation(int reservationID) {
        return rm.getReservation(reservationID, con);	   // rm. er ReservationMapper, con. er new connection 
    }

    public boolean saveNewReservation(Reservation o) {
        return rm.saveNewReservation(o, con); // rm. er ReservationMapper 
    }
          ///////////////////////////////////////////////slut reservation ///////////////	  

    public AvailableRooms getAvailableRooms(AvailableRooms ar) {
        return arm.getAvailableRooms(ar);
    }

          /////////////////////////////////////////////////Guests/////////
    public ListOfGuests getListOfGuests(ListOfGuests gList) {
        return gm.getListOfGuests(gList, con);
    }

    public boolean saveNewGuest(Guests g) {
        return gm.saveNewGuest(g, con); // gm. er GuestMapper 
    }
          /////////////////////////////////////////Guests slut/// 

    ///////////////////////////////////////de 4 nye(test)Metoder///
    public boolean setConfirm(int reservationID, boolean confirmed) { // Boolean confirmed true/false = svarende til f.eks 0 eller 1 

        return rm.setConfirm(reservationID, confirmed, con);
    }
    
    public boolean setNewRoom(int reservationID,int roomId)
    {
        return rm.setNewRoom(reservationID, roomId, con);
    }
    
    public ArrayList <Object>  getGuestsReservations(int guestId)
    {
        return rm.getGuestsReservations(guestId, con);
    }
    
     public boolean setNewDates(String checkIn, String checkOut){
        
        return rm.setNewDates(checkIn, checkOut, con);
    }
}
