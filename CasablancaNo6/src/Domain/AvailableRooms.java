/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Domain;

import java.util.ArrayList;

/**
 *
 * @author Anders Kjær
 */
public class AvailableRooms {
    String checkIn;
    String checkOut;
//    java.sql.Date checkIn;
//    java.sql.Date checkOut;
    ArrayList<Object> aRooms = new ArrayList();

    public AvailableRooms(String checkIn, String checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }
    

//    public Date getCheckIn() {
//        return checkIn;
//    }
//
//    public Date getCheckOut() {
//        return checkOut;
//    }
    
    public void setARooms(int roomNO, String roomType){
        aRooms.add(roomNO);
        aRooms.add(roomType);
    }
    public  Object getaRooms() {
       return aRooms;
    }
    
}

