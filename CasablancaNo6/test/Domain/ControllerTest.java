/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Domain;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Ejer
 */
public class ControllerTest {  // hvad er abstract
    
    public ControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createNewReservation method, of class Controller.
     */
    @Test
    public void CreateNewReservation() {
        System.out.println("createNewReservation here:");
        int guestIdToRelation = 10056;
        int roomID = 102;
        String checkIn = "14-05-02";
        String checkOut = "14-05-04";
        boolean Confirmed = true;  // Tester her confirm !! true = 1 , i Tabel!
        Controller instance = new Controller();
        Reservation expResult = null;
        Reservation result = instance.createNewReservation(guestIdToRelation, roomID, checkIn, checkOut, Confirmed);
        System.out.println("result: "+result+" = testCreateNewGuest()"); // PRINT OUT TJECK!
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of createNewGuest method, of class Controller.
     */
    @Test
    public void CreateNewGuest() {
        System.out.println("createNewGuest");
       
        String fName = "tjeck";
        String lName = "conTest";
        String address = "sangevej";
        int phoneNo = 22775544;
        String email = "eman@noa.com";
        String country = "letland";
        int passportNo = 1234567890;
        String travelAgency = "Tåstrup airport";
        String pinCode = "TESTING";
        int activityBookingId = 100;
        Controller instance = new Controller();
        String expResult = "";
        Guests result = instance.createNewGuest( fName, lName, address, phoneNo, email, country, passportNo, travelAgency, pinCode, activityBookingId);
        System.out.println("result: "+result+" = testCreateNewGuest()"); // PRINT OUT TJECK!
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getAvailableRooms method, of class Controller.
     */
    @Test
    public void GetAvailableRooms() {
        System.out.println("getAvailableRooms");
        String checkIn = "14-05-05";
        String checkOut = "14-05-07";
        Controller instance = new Controller();
//        AvailableRooms expResult = null;
//        AvailableRooms result = instance.getAvailableRooms(checkIn, checkOut);
        String expResult;  
        expResult = " ";
        AvailableRooms result = instance.getAvailableRooms(checkIn, checkOut);
//        assertEquals(expResult, result);
        System.out.println(result+" = testGetAvailableRooms()"); // PRINT OUT TJECK!
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of createActivity method, of class Controller.
     */
    @Test
    public void CreateActivity() {
        System.out.println("createActivity");
        Controller instance = new Controller();
        ActivityReservation expResult = null;
        ActivityReservation result = instance.createActivity();
        assertEquals(expResult, result);
        System.out.println("result: "+result+" = testCreateActivity()"); // PRINT OUT TJECK!
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getListOfGuests method, of class Controller.
     */
    @Test
    public void GetListOfGuests() {
        System.out.println("getListOfGuests");
        Controller instance = new Controller();
        String expResult = "";
        ListOfGuests result = instance.getListOfGuests();
        System.out.println("result: "+result+" = testCreateActivity()"); // PRINT OUT TJECK!
//        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setNewDates method, of class Controller.
     */
    @Test
    public void SetNewDates() {
        System.out.println("setNewDates");
        String checkIn = "14-06-05";
        String checkOut = "14-06-10";
        Controller instance = new Controller();
        boolean expResult = true;
        boolean result = instance.setNewDates(checkIn, checkOut);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setNewRoom method, of class Controller.
     */
    @Test
    public void SetNewRoom() {
        System.out.println("setNewRoom");
        int reservationID =0;
        int roomId = 0;
        Controller instance = new Controller();
        boolean expResult = true;
        boolean result = instance.setNewRoom(reservationID, roomId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setConfirm method, of class Controller.
     */
    @Test
    public void SetConfirm() {
        System.out.println("setConfirm");
        int reservationID = 0;
        boolean confirmed = false;
        Controller instance = new Controller();
        boolean expResult = true;
        boolean result = instance.setConfirm(reservationID, confirmed);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of GetguestsReservations method, of class Controller.
     */
    @Test
    public void getGuestsReservations() {
        System.out.println("GetguestsReservations");
        int guestId = 0;
        Controller instance = new Controller();
        ArrayList<Object>  expResult = null;
        ArrayList<Object> result = instance.getGuestsReservations(guestId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    
}
