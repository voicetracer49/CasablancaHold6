

package Domain;

/**
 @author Anders Kjær, Marcus, Ruben
 */
public class Guests {
    int guestId;
    String fName;
    String lName;
    String address;
    int phoneNo;
    String email;
    String country;
    int passportNo;
    String travelAgency;
    String pinCode;
    int activityBookingId;// String/warshar2 så guest helt selv kan vælge code bogstaver/tal ?
    // herunder konstruktor
      // via.. højreklik/insert code
   //insert setter setter/getters, hvis Nødvendigt via ...  

    public Guests(int guestId, String fName, String lName, String address, int phoneNo, String email, String country, int passportNo, String travelAgency, String pinCode, int activityBookingId) {
        this.guestId = guestId;
        this.fName = fName;
        this.lName = lName;
        this.address = address;
        this.phoneNo = phoneNo;
        this.email = email;
        this.country = country;
        this.passportNo = passportNo;
        this.travelAgency = travelAgency;
        this.pinCode = pinCode;
        this.activityBookingId = activityBookingId;
    }

}

