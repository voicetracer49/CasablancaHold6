/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Domain;

/**
 *
 * @author Ejer
 */
public class Relation {
    private int guestId;
    private int ReservationId;

    public Relation() {
        
    }

    public int getReservationId() {
        return ReservationId;
    }

    public void setReservationId(int ReservationId) {
        this.ReservationId = ReservationId;
    }

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }
}
