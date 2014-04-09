
package Domain;

/**
 * @author Anders Kjær, Ruben Juul
 */
public class Reservation {

    // ATRIBUTTER tblRecervation 
    private int reservationID; // NUMBER// PRIMARY KEY (reservationID)                                                   
    private int roomID; // FOREIGN KEY (roomTypeID) References tblRoomType
    private String checkIn; // DATE//
    private String checkOut; // DATE                  
    private boolean confirmed; // Char(1) 

    public Reservation(int reservationID, int roomID, String checkIn, String checkOut, boolean confirmed) {
        this.reservationID = reservationID;
        this.roomID = roomID;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.confirmed = confirmed;
    }

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    
}