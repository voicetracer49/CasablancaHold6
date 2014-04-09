package Domain;
/*
 * @author https://github.com/voicetracer49/CphBussiness-2semOpgave.git
 * Anders, Marcus, Ruben - Before you Start ->
 * http://www.git-tower.com/learn/version-control-best-practices.html
 */

import DataSource.DBFacade;
import java.sql.Date;
import oracle.sql.DATE;

public class Controller {

    public AvailableRooms currentAvailableRooms;
    private ActivityReservation newActivity;
    private Guests newGuest;
    private Reservation currentReservation;   // order in focus
    private DBFacade dbf;  //ref.Variabel til instans af DBFacade
    DBFacade facade = new DBFacade();
    public int rono;
    public String roty;

    public Controller() {

        currentReservation = null;
        dbf = DBFacade.getInstance();  // afhængig af navngivning i DBFacade? 
        
    }

    public Reservation createNewReservation(int reservationID, int roomID, String checkIn, String checkOut, boolean Confirmed) // skal sættes fra reservationDetailClassen ! 
    // int reservationId hentes og den medsendes i NewReservation her ovenfor??   __ Længden på tabellernes atributter bør forkortes!  Date datatype ukendt !
    {
        //== create order object with ReservationID=0
        currentReservation = new Reservation(0, roomID, checkIn, checkOut, Confirmed);
        //== save and get DB-generated unique reservationID
        boolean status = dbf.saveNewReservation(currentReservation);
        if (!status) //fail!
        {
            currentReservation = null;
        }

        return currentReservation;
    }



    public AvailableRooms getAvailableRooms(String checkIn, String checkOut) {
        currentAvailableRooms = new AvailableRooms(checkIn, checkOut);
        AvailableRooms status;
        status = facade.getAvailableRooms(currentAvailableRooms);  
        
        return currentAvailableRooms;  
// object med 3 atributter 2 Date + en arrayliste = int roomNo, String roomType
    }

    public Reservation getReservation(int reservationID) {
        currentReservation = dbf.getReservation(reservationID);
        return currentReservation;
    }

    // --------create new guest
    public Guests createNewGuest(String fName, String lname, String address, String country, int phoneNo, String eMail, int passportNo, int reservationId, String pinCode) {

        return newGuest;// hvad vi returnerer afhænger af om returntype er BOOLEAN, STRING eller guest til Gui

    }  //  guest kan vel oprettes ligesom reservation her i Controller ? ///////  ???  ///////

//       currentGuest = null;
//        dbf = DBFacade.getInstance();  // afhængig af navngivning i DBFacade?   
//    
//    public Reservation createNewGuest(int reservationID,int roomID , DATE dateArrival, DATE checkOut , boolean Confirmed) // skal sættes fra reservationDetailClassen ! 
//     // int reservationId hentes og den medsendes i NewReservation her ovenfor??   __ Længden på tabellernes atributter bør forkortes!  Date datatype ukendt !
//    {
//        //== create order object with ReservationID=0
//        currentGuest = new Guest(0, roomID , dateArrival, checkOut ,Confirmed);  
//                //== save and get DB-generated unique reservationID
//    boolean status = dbf.saveNewGuest(currentGuest);
//        if (!status) //fail!
//        {
//            currentGuest = null;
//        }
//
//        return currentGuest;
//    }
    public ActivityReservation createActivity() {
        return newActivity;
    }

}
