package model;

import java.util.ArrayList;

/**
 *
 * @author Alejandra
 */
public class Controller {
    
    private ArrayList<Building> theBuildings = new ArrayList<>();
    private ArrayList<Owner> theOwners = new ArrayList<>();
    private ArrayList<Tenant> theTenants = new ArrayList<>();
    
    
    private Building building;

    public Controller() {
        building = new Building("Default", 2, "Street 12");

    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    /**
     * createBuilding add a new building to the real state.
     * @param bName represents the name of the building.
     * @param bTotalApartments represents the total apartments of the building.
     * @param bAddress represents the building's adress.
     * @return msg
     */
    public String createBuilding(String bName, int bTotalApartments, String bAddress) {
        theBuildings.add(new Building(bName, bTotalApartments, bAddress));
        
        String msg = "Building added.";
        
        return msg;
    }
    

    /**
     * checkBuldingNameAvailability check if a building name doesn't exists on the system.
     * @param bName represents the name of the building.
     * @return isAvailable represents the building's name availability.
     */
    public boolean checkBuldingNameAvailability(String bName) {
        boolean isAvailable = true;
        
        for(Building abuilding: theBuildings) {
            if(abuilding.getNameId().equals(bName)) {
               isAvailable = false;
            }
        }        
        
        return isAvailable;
    }
    
    /**
     * getBuildingPosition get the position of a specific building.
     * @param bName represents the name of the building.
     * @return pos represents the position of the building.
     */
    public int getBuildingPosition(String bName) {
        int pos = -1;
        
        for(int i = 0; i < theBuildings.size(); i++) {
            if(theBuildings.get(i).getNameId().equals(bName)) {
               pos = i;
            }
        }           
        
        return pos;
    }
    
    /**
     * getTotalApartmentsOfABuilding get the total number of apartments of an specific building.
     * @param pos represents the position of a specific building.
     * @return numApartments represents the total number of apartments of a building.
     */
    public int getTotalApartmentsOfABuilding(int pos) {
        int numApartments = theBuildings.get(pos).getTotalApartments();
        
        return numApartments;
    }
    
    /**
     * getApartmentNumberAvailability check if an apartment id number is available.
     * @param aIdNumber represents the id number of an apartment.
     * @return isAvailable represents the response of an apartment id number availability.
     */
    public boolean getApartmentNumberAvailability(String aIdNumber) {
        boolean isAvailable = building.checkApartmentNumberAvailability(aIdNumber);
        
        return isAvailable;
    }
    
    /**
     * registerApartment sends the info of a new apartment to register on the building class.
     * @param pos represents a building's position.
     * @param aIdNumber represents the id number of the apartment.
     * @param aTotalRooms represents the total rooms of the apartment.
     * @param aTotalBaths represents the total baths of the apartment.
     * @param aBalcony represents the balcony option of the apartment.
     * @param aRentValue represents the monthly rent value of the apartment.
     * @param aPlace the name of the building to which the apartment belongs.
     * @return msg represents the response.
     */
    public String registerApartment(int pos, String aIdNumber, int aTotalRooms, int aTotalBaths, boolean aBalcony, double aRentValue, String aPlace) {
        String msg = "";

        Apartment newApartment = new Apartment(aIdNumber, aTotalRooms, aTotalBaths, aBalcony, aRentValue, aPlace);

        msg = building.addApartment(pos, aIdNumber, aTotalRooms, aTotalBaths, aBalcony, aRentValue, aPlace);     


        return msg; 

    }    
    
    /**
     * showResponsesOption show a list of options(yes and no).
     * @return YesNo represents the options.
     */
    public String showResponsesOption() {
        
        String YesNo = 
            "1. Yes\n" +
            "2. No";
        
        return YesNo;
    }
    
    /**
     * validateOptionRange validate if an option entered is between a given range.
     * @param minRange represents the minimum value of the range.
     * @param maxRange represents the maximun value of the range.
     * @param optionChosen represents the option chosen.
     * @return isOnRange represents the response.
     */
    public boolean validateOptionRange(int minRange, int maxRange, int optionChosen) {
        boolean isOnRange = false;
        
        if(optionChosen >= minRange && optionChosen <= maxRange) {
            isOnRange = true;
        }
        
        return isOnRange;
    }
    
    /**
     * setApartmentBalcony set the balcony availability.
     * @param optBalcony represents the balcony option.
     * @return hasBalcony represents the response.
     */
    public boolean setApartmentBalcony(int optBalcony) {
        boolean hasBalcony = false;
        
        if (optBalcony == 1) {
            hasBalcony = true;
        }
        
        return hasBalcony;
    }
    
    /**
     * registerOwner add a new owner to the real state.
     * @param oAccountNumber represents the owner's account number.
     * @param oBankName represents the owner's account number.
     * @param pIdType represents the owner's id type.
     * @param pIdNumber represents the owner's id number.
     * @param pFullname represents the owner's fullname.
     * @param pPhoneNumber represents the owner's phone number.
     * @param pPhoneType represents the owner's phone type.
     * @return msg represents the owner addition message.
     */
    public String registerOwner(String oAccountNumber, String oBankName, String pIdType, String pIdNumber, String pFullname, String pPhoneNumber, String pPhoneType) {
        theOwners.add(new Owner(oAccountNumber, oBankName, pIdType, pIdNumber, pFullname, pPhoneNumber, pPhoneType));
        
        String msg = "Owner added.";
        
        return msg;
    }
    
    /**
     * registerTenant add a new tenant to the real state.
     * @param pIdType represents the tenant's id type.
     * @param pIdNumber represents the tenant's id number.
     * @param pFullname represents the tenant's fullname.
     * @param pPhoneNumber represents the tenant's phone number.
     * @param pPhoneType represents the tenant's phone type.
     * @return msg represents the tenant addition message.
     */
    public String registerTenant(String pIdType, String pIdNumber, String pFullname, String pPhoneNumber, String pPhoneType) {
        theTenants.add(new Tenant(pIdType, pIdNumber, pFullname, pPhoneNumber, pPhoneType));
        
        String msg = "Tenant added.";
        
        return msg;
    }
    
    /**
     * showOptionIdType show a list of id type options.
     * @return optionsId represents the options list.
     */
    public String showOptionIdType() {
        String optionsId = 
            "1. Citizenship card \n" +
            "2. Foreigner ID \n" +
            "3. Identity card";
        
        return optionsId;
    }
    
    /**
     * setOptionIdType assign the id type to the person.
     * @param optId represents the option given by the user.
     * @return pIdType represents the id type of the person.
     */
    public String setOptionIdType(int optId) {
        String pIdType = "CITIZENSHIP";
        
        switch(optId) {
            case 1:
                pIdType = typeId.CITIZENSHIP.toString();
                break;
            case 2:
                pIdType = typeId.FOREIGNER.toString();
                break;            
            case 3: 
                pIdType = typeId.IDENTITY.toString();
                break;
        }
        
        return pIdType;
    }

    /**
     * checkIdAvailability check if an id if available.
     * @param typePerson represents the type of person (tenant or owner).
     * @param pIdNumber represents the person id number.
     * @return isAvailable represents the response.
     */
    public boolean checkIdAvailability(int typePerson, String pIdNumber) {
        boolean isAvailable = true;
        
        switch(typePerson) {
            case 1:
                for(Owner own: theOwners) {
                    if(own.getIdNumber().equals(pIdNumber)) {
                        isAvailable = false;
                    }
                }      
                break;
                
            case 2:
                for(Tenant ten: theTenants) {
                    if(ten.getIdNumber().equals(pIdNumber)) {
                        isAvailable = false;
                    }
                }  
                break;
        }

        return isAvailable;
    }
 

    /**
     * searchPersonById search a person on the arraylist.
     * @param typePerson represents the type of person (tenant or owner).
     * @param pIdNumber represents the person id number.
     * @return pos represents the position of the person.
     */
    public int searchPersonById(int typePerson, String pIdNumber) {
        int pos = -1;

        switch(typePerson) {
            case 1:
                for(int i = 0; i < theOwners.size(); i++) {
                    if(theOwners.get(i).getIdNumber().equals(pIdNumber)) {
                        pos = i;
                    }
                }      
                break;
                
            case 2:
                for(int i = 0; i < theTenants.size(); i++) {
                    if(theTenants.get(i).getIdNumber().equals(pIdNumber)) {
                        pos = i;
                    }
                }    
                break;
        }

        return pos;
    }    
    
    /**
     * checkPersonExistence check if a person is on the arraylist.
     * @param typePerson represents the type of person.
     * @param pIdNumber represents the person's id number.
     * @return hasExistence represents the response.
     */
    public boolean checkPersonExistence(int typePerson, String pIdNumber) {
        boolean hasExistence = false;
        
        switch(typePerson) {
            case 1:
                for(Owner own: theOwners) {
                    if(own.getIdNumber().equals(pIdNumber)) {
                        hasExistence = true;
                    }
                }      
                break;
                
            case 2:
                for(Tenant ten: theTenants) {
                    if(ten.getIdNumber().equals(pIdNumber)) {
                        hasExistence = true;
                    }
                }  
                break;
        }

        return hasExistence;
    }
 
    /**
     * showOptionPhoneType show a list of phone type options.
     * @return optionsPhone represents the options list.
     */
    public String showOptionPhoneType() {
        String optionsPhone = 
            "1. Home \n" +
            "2. Office \n" +
            "3. Movil \n" +
            "4. Family \n" +
            "5. Other";
        
        return optionsPhone;
    }
    
    /**
     * setOptionPhoneType assign a phone type to the person.
     * @param optPhone represents the option chosen.
     * @return pPhoneType represents the persons' phone type.
     */
    public String setOptionPhoneType(int optPhone) {
        String pPhoneType = "OTHER";
        
        switch(optPhone) {
            case 1:
                pPhoneType = typePhone.FAMILY.toString();
                break;
            case 2:
                pPhoneType = typePhone.HOME.toString();
                break;            
            case 3: 
                pPhoneType = typePhone.MOVIL.toString();
                break;
            case 4:
                pPhoneType = typePhone.OFFICE.toString();
                break;
            case 5:
                pPhoneType = typePhone.OTHER.toString();
                break;
            default:
                pPhoneType = typePhone.OTHER.toString();
                break;
                
        }
        
        return pPhoneType;
    }
    
    /**
     * checkIntegerValidation validate an integer.
     * @param anyVariable represents the result of the validation on the main.
     * @return isValid represents the response.
     */
    public boolean checkIntegerValidation(int anyVariable) {
        boolean isValid = true;
        
        if(anyVariable == -1) {
            isValid = false;
        }
        
        return isValid;
    }
    
    /**
     * showBuilding 
     * @return msg_buildings
     */
    public String showBuilding() {
        String msg_buildings = "";
        
        for(Building abuilding: theBuildings) {
            msg_buildings += abuilding.getNameId() + ". ";
        }        
        
        return msg_buildings;
    }
    
    /**
     * getAvailableApartmentsToSet show the available apartments to set.
     * @return msg_apartments represents the list.
     */
    public String getAvailableApartmentsToSet() {
        String msg_apartments = building.showAvailableApartmentsToSet();
        
        return msg_apartments;
    }

    /**
     * getAvailableApartmentsToRent show the available apartments to rent.
     * @return msg_apartments represents the list.
     */    
    public String getAvailableApartmentsToRent() {
        String msg_apartments = building.showAvailableApartmentsToRent();
        
        return msg_apartments;
    }
    
    /**
     * getPositionApartmentToSet get the position of the apartment to set.
     * @param aIdNumber represents the apartment's id number.
     * @return pos represents the position.
     */
    public int getPositionApartmentToSet(String aIdNumber) {
        int pos = building.getApartmentPosToSet(aIdNumber);
        
        return pos;
    }
    
    /**
     * setRentsPaymentToOwner sum the rent concepts of all the apartments of an owner.
     * @param pos represents the owner position.
     */
    public void setRentsPaymentToOwner(int pos) {
        double current = theOwners.get(pos).getTotalRents();
        
        double totalMoney = building.sumValueOfRentsOwner(pos, current);
        
        theOwners.get(pos).setTotalRents(totalMoney);
        
    }
    
    /**
     * setApartmentAvailability set the apartment availability.
     * @param pos represents the apartment position.
     */    
    public void setApartmentAvailability(int pos) {
        building.setApartmentAvailabilityWithPosition(pos);

    }
    
    /**
     * setApartmentRented set the apartment rented availability.
     * @param pos represents the apartment position.
     */      
    public void setApartmentRented(int pos) {
        building.setApartmentRentedWithPosition(pos);
    }
 
    /**
     * setOwnerApartment
     * @param aIdNumber represents the apartment id number.
     * @param pIdNumber represents the person id number.
     */
    public void setOwnerApartment(String aIdNumber, String pIdNumber) {
        for(int i = 0; i < theOwners.size(); i++) {
            if(theOwners.get(i).getIdNumber().equals(pIdNumber)) {
               theOwners.get(i).getOwnApartments().add(aIdNumber);
            }
        }           
    }
    
    /**
     * getOwnerMonthlyRentPayment calculate the monthly concepts of total rents by an owner.
     * @param pos represent the owner position.
     * @return totalMoney represents the total monthly value of rents.
     */
    public double getOwnerMonthlyRentPayment(int pos) {
        double totalMoney = theOwners.get(pos).getTotalRents() - (theOwners.get(pos).getTotalRents()*0.1);
                
        return totalMoney;
    }
    
    /**
     * getCountAvailableApartmentsToSet count all the available apartment to set.
     * @param bName represents the name of the building.
     * @return count represents the total apartments.
     */
    public int getCountAvailableApartmentsToSet(String bName) {
        int count = building.countAvailableApartmentsToSet(bName);
        
        return count;
    }
    
    /**
     * getCountAvailableApartmentsToRent count all the available apartment to rent.
     * @param bName represents the name of the building.
     * @return count represents the total apartments.
     */
    public int getCountAvailableApartmentsToRent(String bName) {
        int count = building.countAvailableApartmentsToRent(bName);
        
        return count;
    }
    
    /**
     * setTenantRents set all the tenant rents.
     * @param pIdNumber represents the tenant id number.
     */
    public void setTenantRents(String pIdNumber) {
        int current = 0;
        
        for(int i = 0; i < theTenants.size(); i++) {
            if(theTenants.get(i).getIdNumber().equals(pIdNumber)) {
                current = theTenants.get(i).getNumApt();
                theTenants.get(i).setNumApt(current+1);
            }
        }    

    }
    
    /**
     * getTotalRentsOfTenant get total rentend apartments by a tenant.
     * @param pos represents the tenant position.
     * @return totalRents represents the quantity of rents.
     */
    public int getTotalRentsOfTenant(int pos) {
        int totalRents = theTenants.get(pos).getNumApt();
        
        return totalRents;
    }
    
    /**
     * getMonthlyValueRentedApartments get the total amount of all the rented apartments.
     * @param bName represents the name of the building.
     * @return totalMoney represents the amount.
     */
    public double getMonthlyValueRentedApartments(String bName) {
        double totalMoney = building.calculateMonthlyValueRentedApartments(bName);
        
        return totalMoney;
    }
    
    /**
     * getApartmentAvailability check if an apartment is available.
     * @param aIdNumber represents the apartment id number.
     * @return isAvailable represents the response.
     */
    public boolean getApartmentAvailability(String aIdNumber) {
        boolean isAvailable = building.checkApartmentAvailability(aIdNumber);
        
        return isAvailable;
    }
}
