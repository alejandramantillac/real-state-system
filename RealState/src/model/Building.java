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
     * addApartment add a new apartment to the building.
     * @param pos represents the position.
     * @param aIdNumber represents the apartment id number.
     * @param aTotalRooms represents the apartment total rooms.
     * @param aTotalBaths represents the apartment total baths.
     * @param aBalcony represents the apartment balcony option.
     * @param aRentValue represents the apartment rent value.
     * @param aPlace represents the name of the building to which the apartment belongs.
     * @return msg represents the response.
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
     * checkApartmentNumberAvailability check if an apartment id number is available.
     * @param aIdNumber represents the id number of an apartment.
     * @return isAvailable represents the response of an apartment id number availability.
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
     * showAvailableApartmentsToSet show the available apartments to set.
     * @return msg_apartments represents the list.
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
     * showAvailableApartmentsToRent show the available apartments to rent.
     * @return msg_apartments represents the list.
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
     * getApartmentPosToSet get the position of the apartment to set.
     * @param aIdNumber represents the apartment's id number.
     * @return pos represents the position.
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
     * setApartmentAvailabilityWithPosition set the apartment availability.
     * @param pos represents the apartment position.
     */
    public void setApartmentAvailabilityWithPosition(int pos) {
        theApartments.get(pos).setAvailability(false);
    }
    
    /**
     * setApartmentRentedWithPosition set the apartment rented availability.
     * @param pos represents the apartment position.
     */    
    public void setApartmentRentedWithPosition(int pos) {
        theApartments.get(pos).setIsRented(true);
    }
    
    /**
     * countAvailableApartmentsToSet count all the available apartment to set.
     * @param bName represents the name of the building.
     * @return count represents the total apartments.
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
     * countAvailableApartmentsToRent count all the available apartment to rent.
     * @param bName represents the name of the building.
     * @return count count represents the total apartments.
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
     * calculateMonthlyValueRentedApartments get the total amount of all the rented apartments.
     * @param bName represents the name of the building.
     * @return totalMoney represents the amount.
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
     * checkApartmentAvailability check if an apartment is available.
     * @param aIdNumber represents the apartment id number.
     * @return isAvailable represents the response.
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
     * sumValueOfRentsOwner sum the rent concepts of all the apartments of an owner.
     * @param pos represents the owner position.
     * @param current represents the owner current total rents.
     * @return sumRents represents the total value of rents.
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
