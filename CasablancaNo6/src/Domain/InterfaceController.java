package Domain;

import java.util.ArrayList;

/**
 *
 * @author Ruben Juul
 */
public interface InterfaceController {
    
    public Reservation createNewReservation(int guestIdToRelation, int roomID, String checkIn, String checkOut, boolean Confirmed);
    
    public Guests createNewGuest(String fName, String lName, String address, int phoneNo, String email, String country, int passportNo, String travelAgency, String pinCode, int activityBookingId);
    
    public AvailableRooms getAvailableRooms(String checkIn, String checkOut);

    public ListOfGuests getListOfGuests();
   
    // --Start-- Nye metoder til TestDriven Programming //
    
    public boolean setNewDates(String checkIn, String checkOut);
            
    public boolean setNewRoom(int reservationID, int roomId);
            
    public boolean setConfirm(int reservationID,boolean confirmed);
    
    public ArrayList<Object> getGuestsReservations(int guestId); 
    
    // --slut-- Nye metoder til TestDriven Programming /
//    private String newDates;
//    private boolean newRoom;
//    private boolean confirmation;        
//    private Relation allGuestsReservations
}