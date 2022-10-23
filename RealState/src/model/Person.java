package model;

/**
 *
 * @author Alejandra
 */
public abstract class Person {
    private String idType;
    private String idNumber;
    private String fullname;
    private String phoneNumber;
    private String phoneType;

    public Person(String idType, String idNumber, String fullname, String phoneNumber, String phoneType) {
        this.idType = idType;
        this.idNumber = idNumber;
        this.fullname = fullname;
        this.phoneNumber = phoneNumber;
        this.phoneType = phoneType;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    @Override
    public String toString() {
        return "Person{" + "idType=" + idType + ", idNumber=" + idNumber + ", fullname=" + fullname + ", phoneNumber=" + phoneNumber + ", phoneType=" + phoneType + '}';
    }
    
    
}

