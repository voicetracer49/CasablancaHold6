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
    java.sql.Date checkIn;
    java.sql.Date checkOut;
    ArrayList<Object> aRooms = new ArrayList();

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
    
    public void setARooms(int roomNO, String roomType){
        aRooms.add(roomNO);
        aRooms.add(roomType);
    }
    public  Object getaRooms() {
       return aRooms;
    }
    
}

