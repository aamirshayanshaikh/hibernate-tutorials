package entityonetoone;

public class Passport {
    private int passportId;
    private int passportNo;
    private Citizen citizen;

    public int getPassportId() {
        return passportId;
    }

    public void setPassportId(int passportId) {
        this.passportId = passportId;
    }


    public int getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(int pincode) {
        this.passportNo = pincode;
    }

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }
}
