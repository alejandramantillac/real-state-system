package model;

/**
 *
 * @author Alejandra
 */
public class Apartment {
    
    private String idNumber;
    private int totalRooms;
    private int totalBaths;
    private boolean balcony;
    private double rentValue;
    private boolean isRegister;
    private boolean availability;
    private boolean isRented;
    private String place;

    public Apartment(String idNumber, int totalRooms, int totalBaths, boolean balcony, double rentValue, String place) {
        this.idNumber = idNumber;
        this.totalRooms = totalRooms;
        this.totalBaths = totalBaths;
        this.balcony = balcony;
        this.rentValue = rentValue;
        this.isRegister = false;
        this.availability = true;
        this.isRented = false;
        this.place = place;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public int getTotalRooms() {
        return totalRooms;
    }

    public void setTotalRooms(int totalRooms) {
        this.totalRooms = totalRooms;
    }

    public int getTotalBaths() {
        return totalBaths;
    }

    public void setTotalBaths(int totalBaths) {
        this.totalBaths = totalBaths;
    }

    public boolean isBalcony() {
        return balcony;
    }

    public void setBalcony(boolean balcony) {
        this.balcony = balcony;
    }

    public double getRentValue() {
        return rentValue;
    }

    public void setRentValue(double rentValue) {
        this.rentValue = rentValue;
    }

    public boolean isIsRegister() {
        return isRegister;
    }

    public void setIsRegister(boolean isRegister) {
        this.isRegister = isRegister;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public boolean isIsRented() {
        return isRented;
    }

    public void setIsRented(boolean isRented) {
        this.isRented = isRented;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
    
    

    @Override
    public String toString() {
        return "Apartment{" + "idNumber=" + idNumber + ", totalRooms=" + totalRooms + ", totalBaths=" + totalBaths + ", balcony=" + balcony + ", rentValue=" + rentValue + '}';
    }
    
    
}
