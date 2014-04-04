
package Domain;

import oracle.sql.DATE; // souce organise import = sikre at du kun har dem du skal bruge!

/**
 * @author Anders Kjær, Ruben Juul
 */
public class Reservation {

    // ATRIBUTTER tblRecervation 
    private int reservationID; // NUMBER// PRIMARY KEY (reservationID)                                                   
    private int roomID; // FOREIGN KEY (roomTypeID) References tblRoomType
    private DATE checkIn; // DATE//
    private DATE checkOut; // DATE                  
    private boolean confirmed; // Char(1) 

    public Reservation(int reservationID, int roomID, DATE checkIn, DATE checkOut, boolean confirmed) {
        this.reservationID = reservationID;
        this.roomID = roomID;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.confirmed = confirmed;
    }

    
}