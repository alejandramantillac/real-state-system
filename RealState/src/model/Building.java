package model;

import java.util.ArrayList;

/**
 *
 * @author Alejandra
 */
public class Building {
    
    private String nameId;
    private int totalApartments;
    private String address;
    
    private Apartment apartment;
    
    private ArrayList<Apartment> theApartments = new ArrayList<>();

    public Building(String nameId, int totalApartments, String address) {
        this.nameId = nameId;
        this.totalApartments = totalApartments;
        this.address = address;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }
    
    

    public String getNameId() {
        return nameId;
    }

    public void setNameId(String nameId) {
        this.nameId = nameId;
    }

    public int getTotalApartments() {
        return totalApartments;
    }

    public void setTotalApartments(int totalApartments) {
        this.totalApartments = totalApartments;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Apartment> getTheApartments() {
        return theApartments;
    }

    public void setTheApartments(ArrayList<Apartment> theApartments) {
        this.theApartments = theApartments;
    }
    
    /**
     * addApartment
     * @param pos
     * @param aIdNumber
     * @param aTotalRooms
     * @param aTotalBaths
     * @param aBalcony
     * @param aRentValue
     * @param aPlace
     * @return msg
     */
    public String addApartment(int pos, String aIdNumber, int aTotalRooms, int aTotalBaths, boolean aBalcony, double aRentValue, String aPlace) {
        String msg = "";
        theApartments.add(new Apartment(aIdNumber, aTotalRooms, aTotalBaths, aBalcony, aRentValue, aPlace));
        
        boolean isFull = theApartments.get(pos).isIsRegister();

        if(isFull != false) {
            msg = "You registered all the apartments of this building.";
        } else {
            msg = "Apartment added.";
            theApartments.get(pos).setIsRegister(true);           
        }
        
        return msg;
    }
    
    /**
     * checkApartmentNumberAvailability
     * @param aIdNumber
     * @return isAvailable
     */
    public boolean checkApartmentNumberAvailability(String aIdNumber) {
        boolean isAvailable = true;
        
        for(Apartment apt: theApartments) {
            if(apt.getIdNumber().equals(aIdNumber)) {
               isAvailable = false;
            }
        }        
        
        return isAvailable;        
    }
    
    /**
     * showAvailableApartmentsToSet
     * @return msg_apartments
     */
    public String showAvailableApartmentsToSet() {
        String msg_apartments = "";
        
        for(int i = 0; i < theApartments.size(); i++) {
            if(theApartments.get(i).isAvailability() == true) {
                msg_apartments += theApartments.get(i).getIdNumber() + ". ";
            }
        }      
        
        return msg_apartments;
    }
    
    /**
     * showAvailableApartmentsToRent
     * @return msg_apartments
     */
    public String showAvailableApartmentsToRent() {
        String msg_apartments = "";
        
        for(int i = 0; i < theApartments.size(); i++) {
            if(theApartments.get(i).isIsRented() == false) {
                msg_apartments += theApartments.get(i).getIdNumber() + ". ";
            }
        }      
        
        return msg_apartments;
    }
    
    /**
     * getApartmentPosToSet
     * @param aIdNumber
     * @return pos
     */
    public int getApartmentPosToSet(String aIdNumber) {
        int pos = -1;
        
        for(int i = 0; i < theApartments.size(); i++) {
            if(theApartments.get(i).getIdNumber().equals(aIdNumber)) {
                pos = i;
            }
        }      
        
        return pos;
    }
    
    /**
     * setApartmentAvailabilityWithPosition
     * @param pos
     */
    public void setApartmentAvailabilityWithPosition(int pos) {
        theApartments.get(pos).setAvailability(false);
    }
    
    /**
     * setApartmentRentedWithPosition
     * @param pos
     */    
    public void setApartmentRentedWithPosition(int pos) {
        theApartments.get(pos).setIsRented(true);
    }
    
    /**
     * countAvailableApartmentsToSet
     * @param bName
     * @return count
     */
    public int countAvailableApartmentsToSet(String bName) {
        int count = 0;
        
        
        for(Apartment apt: theApartments) {
            if(apt.getPlace().equals(bName) && apt.isAvailability() == true) {
               count++;
            }
        }          
        
        return count;
    }
    
    /**
     * countAvailableApartmentsToRent
     * @param bName
     * @return count
     */
    public int countAvailableApartmentsToRent(String bName) {
        int count = 0;

        
        for(Apartment apt: theApartments) {
            if(apt.getPlace().equals(bName) && apt.isIsRented() == false) {
               count++;
            }
        }          
        
        
        return count;
    }
    
    /**
     * calculateMonthlyValueRentedApartments
     * @param bName
     * @return totalMoney
     */
    public double calculateMonthlyValueRentedApartments(String bName) {
        double totalMoney = 0;

        
        for(Apartment apt: theApartments) {
            if(apt.getPlace().equals(bName) && apt.isIsRented() == true) {
               totalMoney += apt.getRentValue();
            }
        }          

        return totalMoney;
    }
    
    /**
     * checkApartmentAvailability
     * @param aIdNumber
     * @return isAvailable
     */
    public boolean checkApartmentAvailability(String aIdNumber) {
        boolean isAvailable = false;
        
        for(Apartment apt: theApartments) {
            if(apt.getIdNumber().equals(aIdNumber) && apt.isIsRented() == false) {
               isAvailable = true;
            }
        }        
        
        return isAvailable;        
    }
    
    /**
     * sumValueOfRentsOwner
     * @param pos
     * @param current
     * @return sumRents
     */
    public double sumValueOfRentsOwner(int pos, double current) {
        double currentValue = theApartments.get(pos).getRentValue();
        
        double sumRents = current + currentValue;
        
        return sumRents;
   
    }
    
    @Override
    public String toString() {
        return "Building{" + "nameId=" + nameId + ", totalApartments=" + totalApartments + ", address=" + address + '}';
    }
    
    
}
