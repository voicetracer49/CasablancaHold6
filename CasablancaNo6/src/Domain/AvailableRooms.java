/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Domain;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Anders Kjær
 */
public class AvailableRooms {
    Date checkIn;
    Date checkOut;
    ArrayList<Rooms> aRooms = null;

    public AvailableRooms(Date checkIn, Date checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }
}
