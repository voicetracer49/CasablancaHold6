

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

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(int passportNo) {
        this.passportNo = passportNo;
    }

    public String getTravelAgency() {
        return travelAgency;
    }

    public void setTravelAgency(String travelAgency) {
        this.travelAgency = travelAgency;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public int getActivityBookingId() {
        return activityBookingId;
    }

    public void setActivityBookingId(int activityBookingId) {
        this.activityBookingId = activityBookingId;
    }

}

