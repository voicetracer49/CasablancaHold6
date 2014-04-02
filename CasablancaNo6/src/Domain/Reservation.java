package Domain;

import oracle.sql.DATE; // souce organise import = sikre at du kun har dem du skal bruge!

/**
 * @author Anders Kjær, Ruben Juul
 */
public class Reservation {

    // ATRIBUTTER tblRecervation 
    private int reservationID; // NUMBER// PRIMARY KEY (reservationID)                                                   
    private int roomID; // FOREIGN KEY (roomTypeID) References tblRoomType
    private DATE dateArrival; // DATE//
    private DATE checkOut; // DATE                  
    private boolean Confirmed; // Char(1) 

    public Reservation(int reservationID, int roomID, DATE dateArrival, DATE checkOut, boolean Confirmed) {
        this.reservationID = reservationID;
        this.roomID = roomID;
        this.dateArrival = dateArrival;
        this.checkOut = checkOut;
        this.Confirmed = Confirmed;

    }
    // husk: inde i classen, opret med Højreklik "insert Code"        

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

    public DATE getDateArrival() {
        return dateArrival;
    }

    public void setDateArrival(DATE dateArrival) {
        this.dateArrival = dateArrival;
    }

    public DATE getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(DATE checkOut) {
        this.checkOut = checkOut;
    }

    public boolean isConfirmed() {
        return Confirmed;
    }

    public void setConfirmed(boolean Confirmed) {
        this.Confirmed = Confirmed;
    }

    // husk bagefter indefor classen, men efter den netop på samme vis oprettede construktor , oprettes Setter&getter
    @Override
    public String toString() {
        return "Reservation{" + "reservationID=" + reservationID + ", roomID=" + roomID + ", dateArrival=" + dateArrival + ", checkOut=" + checkOut + ", Confirmed=" + Confirmed + '}';
    }
   // på samme vis toString via Insert code 
}
