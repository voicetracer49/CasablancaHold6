

package Domain;

/**
 @author Anders Kjær, Marcus, Ruben
 */
public class Guests {
    
    String fName;
    String lName;
    String address;
    String country;
    int phoneNo;
    String email;
    int passportNo;
    int reservationId;
    String pinCode; // String/warshar2 så guest helt selv kan vælge code bogstaver/tal ?
    
    // herunder konstruktor
    public Guests(String fName, String lName, String address, String country, int phoneNumber, String email, int passportNo, int reservationId, String pinCode) {
        this.fName = fName;
        this.lName = lName;
        this.address = address;
        this.country = country;
        this.phoneNo = phoneNumber;
        this.email = email;
        this.passportNo = passportNo;
        this.reservationId = reservationId;
        this.pinCode = pinCode;
      // via.. højreklik/insert code
    }
   //insert setter setter/getters, hvis Nødvendigt via ...  
}

