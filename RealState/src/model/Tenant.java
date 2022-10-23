package model;

/**
 *
 * @author Alejandra
 */
public class Tenant extends Person {
    private int numApt;

    public Tenant(String idType, String idNumber, String fullname, String phoneNumber, String phoneType) {
        super(idType, idNumber, fullname, phoneNumber, phoneType);
        this.numApt = numApt;
    }

    public int getNumApt() {
        return numApt;
    }

    public void setNumApt(int numApt) {
        this.numApt = numApt;
    }

    @Override
    public String toString() {
        return "Tenant{" + "numApt=" + numApt + '}';
    }
    
    
    
    
}
