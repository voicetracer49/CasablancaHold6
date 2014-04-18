package Domain;
/*
 * @author https://github.com/voicetracer49/CphBussiness-2semOpgave.git
 * Anders, Marcus, Ruben - Before you Start ->
 * http://www.git-tower.com/learn/version-control-best-practices.html
 */

import DataSource.DBFacade;
import java.util.ArrayList;

public class Controller implements InterfaceController {
   
    private Relation re = new Relation();
    public AvailableRooms currentAvailableRooms;
    private ActivityReservation newActivity;
    private Guests currentGuest;
    private Reservation currentReservation;   // order in focus
    private DBFacade dbf;  //ref.Variabel til instans af DBFacade
    DBFacade facade = new DBFacade();
    //--XP--start//
   
//    private NewRoom newRoom;
//    private boolean confirmation;        
    private Relation allGuestsReservations;
    //--XP--slut//
            
    public Controller() {
        currentGuest = null; // // afhængig af navngivning i DBFacade?
        currentReservation = null;
        dbf = DBFacade.getInstance();  // afhængig af navngivning i DBFacade?     
    }
    
    //--------create new Reservation!
    public Reservation createNewReservation(int guestIdToRelation, int roomID, String checkIn, String checkOut, boolean Confirmed) // skal sættes fra reservationDetailClassen ! 
    // int reservationId hentes og den medsendes i NewReservation her ovenfor?? 
    {
        //== create order object with ReservationID=0
        currentReservation = new Reservation(0, guestIdToRelation, roomID, checkIn, checkOut, Confirmed);
        //== save and get DB-generated unique reservationID
        boolean status = dbf.saveNewReservation(currentReservation);
        if (!status) //fail!
        {
            currentReservation = null;
        }

        return currentReservation;
    }
    
    // --------create new guest!
    public Guests createNewGuest(String fName, String lName, String address, int phoneNo, String email, String country, int passportNo, String travelAgency, String pinCode, int activityBookingId) {       // Guesthentes og den medsendes i creatNewGuest her ovenfor??

        //== create Guests object with ReservationID=0
        currentGuest = new Guests(0, fName, lName, address, phoneNo, email, country, passportNo, travelAgency, pinCode, activityBookingId);
                //== save and get DB-generated unique reservationID
            boolean status = dbf.saveNewGuest(currentGuest); // facade el. dbf .. ¤_¤??
        if (!status) //fail!
        {
            currentGuest = null;
        }

        return currentGuest;// hvad vi returnerer afhænger af om returntype er BOOLEAN, STRING eller guest til Gui  
    }
    

    
    public AvailableRooms getAvailableRooms(String checkIn, String checkOut) {
        currentAvailableRooms = new AvailableRooms(checkIn, checkOut);
        AvailableRooms status;
        status = facade.getAvailableRooms(currentAvailableRooms);

        return currentAvailableRooms;
// object med 3 atributter 2 Date + en arrayliste = int roomNo, String roomType
    }

    public ActivityReservation createActivity() {
        return newActivity;
    }

    public ListOfGuests getListOfGuests(){
        ListOfGuests currentGuestList = new ListOfGuests();
        facade.getListOfGuests(currentGuestList);
        return currentGuestList;
    }
    
    // --Start-- Nye metoder til TestDriven Programming //
    
    public boolean setNewDates(String checkIn, String checkOut){
        
        return dbf.setNewDates(checkIn, checkOut);
    }
            
    public boolean setNewRoom(int reservationID, int roomId){
        
        return dbf.setNewRoom(reservationID, roomId);
    }
            
    public boolean setConfirm(int reservationID, boolean confirmed){ // Boolean confirmed true/false = svarende til f.eks 0 eller 1 
        
        return dbf.setConfirm(reservationID, confirmed);
    }
    
    public ArrayList<Object> getGuestsReservations(int guestId){   // guestId for at finde Gestens reservationer i guestReservation
    
        return dbf.getGuestsReservations(guestId);  
    }

    // --Slut-- Nye metoder til TestDriven Programming //



}



