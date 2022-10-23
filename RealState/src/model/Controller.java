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
     * createBuilding
     * @param bName
     * @param bTotalApartments
     * @param bAddress
     * @return msg
     */
    public String createBuilding(String bName, int bTotalApartments, String bAddress) {
        theBuildings.add(new Building(bName, bTotalApartments, bAddress));
        
        String msg = "Building added.";
        
        return msg;
    }
    

    /**
     * checkBuldingNameAvailability
     * @param bName
     * @return isAvailable
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
     * getBuildingPosition
     * @param bName
     * @return pos
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
     * getTotalApartmentsOfABuilding
     * @param pos
     * @return numApartments
     */
    public int getTotalApartmentsOfABuilding(int pos) {
        int numApartments = theBuildings.get(pos).getTotalApartments();
        
        return numApartments;
    }
    
    /**
     * getApartmentNumberAvailability
     * @param aIdNumber
     * @return isAvailable
     */
    public boolean getApartmentNumberAvailability(String aIdNumber) {
        boolean isAvailable = building.checkApartmentNumberAvailability(aIdNumber);
        
        return isAvailable;
    }
    
    /**
     * registerApartment
     * @param pos
     * @param aIdNumber
     * @param aTotalRooms
     * @param aTotalBaths
     * @param aBalcony
     * @param aRentValue
     * @param aPlace
     * @return msg
     */
    public String registerApartment(int pos, String aIdNumber, int aTotalRooms, int aTotalBaths, boolean aBalcony, double aRentValue, String aPlace) {
        String msg = "";

        Apartment newApartment = new Apartment(aIdNumber, aTotalRooms, aTotalBaths, aBalcony, aRentValue, aPlace);

        msg = building.addApartment(pos, aIdNumber, aTotalRooms, aTotalBaths, aBalcony, aRentValue, aPlace);     


        return msg; 

    }    
    
    /**
     * showResponsesOption
     * @return YesNo
     */
    public String showResponsesOption() {
        
        String YesNo = 
            "1. Yes\n" +
            "2. No";
        
        return YesNo;
    }
    
    /**
     * validateOptionRange
     * @param minRange
     * @param maxRange
     * @param optionChosen
     * @return isOnRange
     */
    public boolean validateOptionRange(int minRange, int maxRange, int optionChosen) {
        boolean isOnRange = false;
        
        if(optionChosen >= minRange && optionChosen <= maxRange) {
            isOnRange = true;
        }
        
        return isOnRange;
    }
    
    /**
     * setApartmentBalcony
     * @param optBalcony
     * @return hasBalcony
     */
    public boolean setApartmentBalcony(int optBalcony) {
        boolean hasBalcony = false;
        
        if (optBalcony == 1) {
            hasBalcony = true;
        }
        
        return hasBalcony;
    }
    
    /**
     * registerOwner
     * @param oAccountNumber
     * @param oBankName
     * @param pIdType
     * @param pIdNumber
     * @param pFullname
     * @param pPhoneNumber
     * @param pPhoneType
     * @return msg
     */
    public String registerOwner(String oAccountNumber, String oBankName, String pIdType, String pIdNumber, String pFullname, String pPhoneNumber, String pPhoneType) {
        theOwners.add(new Owner(oAccountNumber, oBankName, pIdType, pIdNumber, pFullname, pPhoneNumber, pPhoneType));
        
        String msg = "Owner added.";
        
        return msg;
    }
    
    /**
     * registerTenant
     * @param pIdType
     * @param pIdNumber
     * @param pFullname
     * @param pPhoneNumber
     * @param pPhoneType
     * @return msg
     */
    public String registerTenant(String pIdType, String pIdNumber, String pFullname, String pPhoneNumber, String pPhoneType) {
        theTenants.add(new Tenant(pIdType, pIdNumber, pFullname, pPhoneNumber, pPhoneType));
        
        String msg = "Tenant added.";
        
        return msg;
    }
    
    /**
     * showOptionIdType
     * @return optionsId
     */
    public String showOptionIdType() {
        String optionsId = 
            "1. Citizenship card \n" +
            "2. Foreigner ID \n" +
            "3. Identity card";
        
        return optionsId;
    }
    
    /**
     * setOptionIdType
     * @param optId
     * @return pIdType
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
     * checkIdAvailability
     * @param typePerson
     * @param pIdNumber
     * @return isAvailable
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
     * searchPersonById
     * @param typePerson
     * @param pIdNumber
     * @return pos
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
     * checkPersonExistence
     * @param typePerson
     * @param pIdNumber
     * @return hasExistence
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
     * showOptionPhoneType
     * @return optionsPhone
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
     * setOptionPhoneType
     * @param optPhone
     * @return pPhoneType
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
     * checkIntegerValidation
     * @param bTotalApartments
     * @return isValid
     */
    public boolean checkIntegerValidation(int bTotalApartments) {
        boolean isValid = true;
        
        if(bTotalApartments == -1) {
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
     * getAvailableApartmentsToSet
     * @return msg_apartments
     */
    public String getAvailableApartmentsToSet() {
        String msg_apartments = building.showAvailableApartmentsToSet();
        
        return msg_apartments;
    }

    /**
     * getAvailableApartmentsToRent
     * @return msg_apartments
     */    
    public String getAvailableApartmentsToRent() {
        String msg_apartments = building.showAvailableApartmentsToRent();
        
        return msg_apartments;
    }
    
    /**
     * getPositionApartmentToSet
     * @param aIdNumber
     * @return pos
     */
    public int getPositionApartmentToSet(String aIdNumber) {
        int pos = building.getApartmentPosToSet(aIdNumber);
        
        return pos;
    }
    
    /**
     * setRentsPaymentToOwner
     * @param pos
     */
    public void setRentsPaymentToOwner(int pos) {
        double current = theOwners.get(pos).getTotalRents();
        
        double totalMoney = building.sumValueOfRentsOwner(pos, current);
        
        theOwners.get(pos).setTotalRents(totalMoney);
        
    }
    
    /**
     * setApartmentAvailability
     * @param pos
     */    
    public void setApartmentAvailability(int pos) {
        building.setApartmentAvailabilityWithPosition(pos);

    }
    
    /**
     * setApartmentRented
     * @param pos
     */      
    public void setApartmentRented(int pos) {
        building.setApartmentRentedWithPosition(pos);
    }
 
    /**
     * setOwnerApartment
     * @param aIdNumber
     * @param pIdNumber
     */
    public void setOwnerApartment(String aIdNumber, String pIdNumber) {
        for(int i = 0; i < theOwners.size(); i++) {
            if(theOwners.get(i).getIdNumber().equals(pIdNumber)) {
               theOwners.get(i).getOwnApartments().add(aIdNumber);
            }
        }           
    }
    
    /**
     * getOwnerMonthlyRentPayment
     * @param pos
     * @return totalMoney
     */
    public double getOwnerMonthlyRentPayment(int pos) {
        double totalMoney = theOwners.get(pos).getTotalRents() - (theOwners.get(pos).getTotalRents()*0.1);
                
        return totalMoney;
    }
    
    /**
     * getCountAvailableApartmentsToSet
     * @param bName
     * @return count
     */
    public int getCountAvailableApartmentsToSet(String bName) {
        int count = building.countAvailableApartmentsToSet(bName);
        
        return count;
    }
    
    /**
     * getCountAvailableApartmentsToRent
     * @param bName
     * @return count
     */
    public int getCountAvailableApartmentsToRent(String bName) {
        int count = building.countAvailableApartmentsToRent(bName);
        
        return count;
    }
    
    /**
     * setTenantRents
     * @param pIdNumber
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
     * getTotalRentsOfTenant
     * @param pos
     * @return totalRents
     */
    public int getTotalRentsOfTenant(int pos) {
        int totalRents = theTenants.get(pos).getNumApt();
        
        return totalRents;
    }
    
    /**
     * getMonthlyValueRentedApartments
     * @param bName
     * @return totalMoney
     */
    public double getMonthlyValueRentedApartments(String bName) {
        double totalMoney = building.calculateMonthlyValueRentedApartments(bName);
        
        return totalMoney;
    }
    
    /**
     * getApartmentAvailability
     * @param aIdNumber
     * @return isAvailable
     */
    public boolean getApartmentAvailability(String aIdNumber) {
        boolean isAvailable = building.checkApartmentAvailability(aIdNumber);
        
        return isAvailable;
    }
}
