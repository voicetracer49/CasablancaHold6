package Domain;

import java.util.ArrayList;
import oracle.sql.DATE;
/**
 * @author Anders Kjær, Ruben Juul
 */
public class Reservation 
{

/// DataType fungerer ikke  /// ATRIBUTTER tblRecervation /////////////
            private int reservationID; // NUMBER// PRIMARY KEY (reservationID)                                                   
            private int roomNumberID;
            private int roomTypeID; // NUMBER                   // FOREIGN KEY (roomTypeID) References tblRoomType
            private DATE reservationFrom; // DATE               // A FK that should be mapped to a reference ??????????//RJ_NOTE//private ArrayList<OrderDetail> orderDetails; 
            private DATE reservationTo; // DATE                  
            private char reservationConfirmed; // Char(1)
            private DATE reservationCreated; // DATE,
            private DATE reservationModifyed; // DATE,
            private char reservationDeleted; // char(1),
            private ArrayList<ReservationDetail> resDetails;

        public Reservation(int resId, int romNum ,int romtyp, DATE resfro, DATE resTo, char resCon, DATE resCre, DATE resMod, char resDel) 
        {
            reservationID = resId;
            roomNumberID = romNum;
            roomTypeID = romtyp;
            reservationFrom = resfro;
            reservationTo = resTo;
            reservationConfirmed = resCon;
            reservationCreated = resCre;
            reservationModifyed = resMod;
            reservationDeleted = resDel;
            resDetails = new ArrayList<ReservationDetail>();
        }

    //== accessors
    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public void setRoomNumberID(){
        this.roomNumberID = roomNumberID;
        
    }
    public void setRoomType(int romtyp) {
        this.roomTypeID = romtyp;
    }
    

    public void setReservationFrom(DATE  resfro) {
        this.reservationFrom = resfro;
    }

    public void setReservationTo(DATE  resTo) {
        this.reservationTo = resTo;
    }

    public void setReservationConfirmed(char resCon) {
        this.reservationConfirmed = resCon;
    }

    public void setReservationCreated (DATE resCre) {
         this.reservationCreated = resCre;
    }

    public void setReservationModifyed(DATE resMod) {
        this.reservationModifyed = resMod;
    }

    public void setReservationDeleted(char resDel) {
        this.reservationDeleted = resDel;
    }
    
//   _______________________________set list ReservationDetail

    public void addDetail(ReservationDetail rdLIst) {
        resDetails.add(rdLIst);
    }  

    public String toString() {
        return reservationID + " " + roomTypeID + " " + reservationFrom + " " + reservationTo + " " + reservationConfirmed + " " + reservationCreated + " " + reservationModifyed + " " + reservationDeleted;
    }
    
    String detailsToString() {
        String res = "";
        for (int i = 0; i < resDetails.size(); i++) {
            res += resDetails.get(i).toString() + "\n";
        }
        return res;
    }
}
