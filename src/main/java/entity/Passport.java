package entity;


public class Passport {
    private Integer id;
    private String passportno;
    private Citizen citizen;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassportno() {
        return passportno;
    }

    public void setPassportno(String passportNo) {
        this.passportno = passportNo;
    }

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }
}
