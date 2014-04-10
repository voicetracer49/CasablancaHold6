/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Domain;

import java.util.ArrayList;

/**
 *
 * @author Ejer
 */
public class ListOfGuests {
          ArrayList<Object> listOfGuests = new ArrayList();

    public ListOfGuests() { //Konstruktor
    }
    public void setListOfGuests(int guestId, String fName, String lName, String address, int phoneNo, String email, String country, int passportNo, String travelAgency, String pinCode, int activityBookingId){
        this.listOfGuests.add(guestId);
        this.listOfGuests.add(fName);
        this.listOfGuests.add(lName);
        this.listOfGuests.add(guestId);
        this.listOfGuests.add(fName);
        this.listOfGuests.add(lName);
        this.listOfGuests.add(guestId);
        this.listOfGuests.add(fName);
        this.listOfGuests.add(lName);
        this.listOfGuests.add(guestId);
        this.listOfGuests.add(fName);
        this.listOfGuests.add(lName);
        
        
    }
    // til listknap i GUI 
    public Object readFromArrayList(int i){
        
        return this.listOfGuests.get(i);
    }
    public int getSizeOfArrayList(){
        
        return this.listOfGuests.size();
    }
}
