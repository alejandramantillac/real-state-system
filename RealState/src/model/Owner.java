package model;

import java.util.ArrayList;

/**
 *
 * @author Alejandra
 */
public class Owner extends Person {
    
    private String accountNumber;
    private String bankName;
    private ArrayList<String> ownApartments = new ArrayList<String>();
    private double totalRents;

    public Owner(String accountNumber, String bankName, String idType, String idNumber, String fullname, String phoneNumber, String phoneType) {
        super(idType, idNumber, fullname, phoneNumber, phoneType);
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.totalRents = 0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }    

    public ArrayList<String> getOwnApartments() {
        return ownApartments;
    }

    public void setOwnApartments(ArrayList<String> ownApartments) {
        this.ownApartments = ownApartments;
    }

    public double getTotalRents() {
        return totalRents;
    }

    public void setTotalRents(double totalRents) {
        this.totalRents = totalRents;
    }

    @Override
    public String toString() {
        return "Owner{" + "accountNumber=" + accountNumber + ", bankName=" + bankName + '}';
    }
    
    
    
}
