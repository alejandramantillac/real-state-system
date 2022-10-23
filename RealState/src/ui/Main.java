package ui;

import java.util.Scanner;
import java.util.InputMismatchException;
import model.*;

/**
 *
 * @author Alejandra
 */
public class Main {
    private Scanner scan;
    
    private Controller controller;
    
    public Main() {
        scan = new Scanner(System.in);
        controller = new Controller();
    }

    public Scanner getScan() {
        return scan;
    }

    public Controller getController() {
        return controller;
    }
    
    public static void main(String[] args){
        Main main = new Main(); 

        int option = -1; 

            do{
                option = main.getOptionShowMenu(); 
                main.executeOption(option);

            } while(option != 0);

        main.getScan().close();
    }
 
    /**
    * getOptionShowMenu prints the menu and receives the option given by the user.
    * @return option save the option chosen.
    */
    public int getOptionShowMenu(){

        int option = 0; 
        System.out.println("<<<<< Real State System  >>>>>");
        System.out.println(
        "1. Register a building \n" +
        "2. Register an apartment on a building \n" +
        "3. Register an owner \n" +
        "4. Register a tenant \n" +
        "5. Associate apartment to owner \n" +
        "6. Rent apartment to tenant \n" +        
        "7. Consult the number of apartments availables on a specific building \n" +
        "8. Consult the total monthly rent value of the rented apartments on a specific building \n" +        
        "9. Consult apartment availability \n" +
        "10. Consult total apartments renteds by a tenant \n" +
        "11. Consult total rent value received by an owner \n" +
        "0. Exit. ");
        option = validateIntegerOption(); 

        return option; 
    }

    /**
     * executeOption executes the program's functionalities according to the user's choice.
     * @param option saves the user's choice.
     */    
    public void executeOption(int option){
        String bName, bAddress, msg, aIdNumber, pIdType, pIdNumber, pFullname, pPhoneNumber, pPhoneType, oAccountNumber, oBankName;
        int bTotalApartments, pos, numApartments, counter, aTotalRooms, aTotalBaths, optBalcony, optId, optPhone, availableApt, totalRents;
        boolean isAvailable, isValid, aBalcony, isOnRange, hasExistence;
        double aRentValue, totalMoney;
                

        switch(option){
            case 1: 
                System.out.println("Type the name of the building: ");
                bName = scan.next();
                
                isAvailable = controller.checkBuldingNameAvailability(bName);
                
                if(isAvailable) {
                    System.out.println("Type the total number of apartments: ");
                    bTotalApartments = validateIntegerOption();
                    isValid = controller.checkIntegerValidation(bTotalApartments);
                    
                    if(isValid) {
                        System.out.println("Type the address: ");
                        bAddress = scan.next();

                        msg = controller.createBuilding(bName, bTotalApartments, bAddress);
                        System.out.println(msg);                      
                    }
                                      
                } else {
                    System.out.println("Error. A building with that name already exists.");
                }               
                
                break; 

            case 2: 	
                System.out.println("Type the name of the building: ");
                bName = scan.next();
                pos = controller.getBuildingPosition(bName);
                
                if(pos != -1) {
                    counter = controller.getTotalApartmentsOfABuilding(pos);
                    
                    for (int i = 0; i < counter; i++) {
                        System.out.println("Apartment #" + (i+1));
                        System.out.println("Type the id number apartment: ");
                        aIdNumber = scan.next();
                        isAvailable = controller.getApartmentNumberAvailability(aIdNumber);
                        
                        if(isAvailable) {
                            System.out.println("Type the number of total rooms: ");
                            aTotalRooms = scan.nextInt();

                            System.out.println("Type the number of total baths: ");
                            aTotalBaths = scan.nextInt();

                            System.out.println("Does the apartment have a balcony?");
                            System.out.println(controller.showResponsesOption());
                            optBalcony = scan.nextInt();

                            isOnRange = controller.validateOptionRange(1, 2, optBalcony);

                            if (isOnRange) {
                                aBalcony = controller.setApartmentBalcony(optBalcony);

                                System.out.println("Type the monthly rent value: ");
                                aRentValue = scan.nextDouble();


                                msg = controller.registerApartment(pos, aIdNumber, aTotalRooms, aTotalBaths, aBalcony, aRentValue, bName);
                                System.out.println(msg);
                            }                                                 
                        } else {
                            System.out.println("This apartment number id already exists.");
                        }
                    }
                        
                } else {
                    System.out.println("Error. Doesn't exist a building with that name.");
                }
                
                break; 

            case 3: 
                System.out.println("Choose the id type: ");
                System.out.println(controller.showOptionIdType());
                optId = scan.nextInt();
                
                isOnRange = controller.validateOptionRange(1, 3, optId);
                
                if(isOnRange) {
                    pIdType = controller.setOptionIdType(optId);
                    
                    System.out.println("Type the id number: ");
                    pIdNumber = scan.next();
                    isAvailable = controller.checkIdAvailability(1, pIdNumber);
                    
                    if(isAvailable) {
                        System.out.println("Type the fullname: ");
                        pFullname = scan.next();                  
                        
                        System.out.println("Type your contact number: ");
                        pPhoneNumber = scan.next();
                        
                        System.out.println("Choose a phone type: ");
                        System.out.println(controller.showOptionPhoneType());
                        optPhone = scan.nextInt();
                        pPhoneType = controller.setOptionPhoneType(optPhone);
                        
                        System.out.println("Type the account number: ");
                        oAccountNumber = scan.next();
                        
                        System.out.println("Type the bank name: ");
                        oBankName = scan.next();
                        
                        msg = controller.registerOwner(oAccountNumber, oBankName, pIdType, pIdNumber, pFullname, pPhoneNumber, pPhoneType);
                        System.out.println(msg);
                    } else {
                        System.out.println("Error. This person id already exists.");
                    }

                } else {
                    System.out.println("Error. You selected an invalid option.");
                }

                break;                    

            case 4: 
                System.out.println("Choose the id type: ");
                System.out.println(controller.showOptionIdType());
                optId = scan.nextInt();
                
                isOnRange = controller.validateOptionRange(1, 3, optId);
                
                if(isOnRange) {
                    pIdType = controller.setOptionIdType(optId);
                    
                    System.out.println("Type the id number: ");
                    pIdNumber = scan.next();
                    isAvailable = controller.checkIdAvailability(2, pIdNumber);
                    
                    if(isAvailable) {
                        System.out.println("Type the fullname: ");
                        pFullname = scan.next();                  
                        
                        System.out.println("Type your contact number: ");
                        pPhoneNumber = scan.next();
                        
                        System.out.println("Choose a phone type: ");
                        System.out.println(controller.showOptionPhoneType());
                        optPhone = scan.nextInt();
                        pPhoneType = controller.setOptionPhoneType(optPhone);
                        
                        msg = controller.registerTenant(pIdType, pIdNumber, pFullname, pPhoneNumber, pPhoneType);
                        System.out.println(msg);
                    } else {
                        System.out.println("Error. This person id already exists.");
                    }

                } else {
                    System.out.println("Error. You selected an invalid option.");
                }
                break; 

            case 5: 
                System.out.println("Type the owner id number: ");
                pIdNumber = scan.next();
                hasExistence = controller.checkPersonExistence(1, pIdNumber);
                
                if(hasExistence) {
                    System.out.println("These are the available apartments to set: ");
                    System.out.println(controller.getAvailableApartmentsToSet());
                
                    System.out.println("Choose an apartment: ");
                    aIdNumber = scan.next();
                    
                    pos = controller.getPositionApartmentToSet(aIdNumber);
                    
                    if(pos != -1) {
                        controller.setRentsPaymentToOwner(pos);
                        controller.setApartmentAvailability(pos);
                        System.out.println("Apartment set to its owner correctly.");
                        
                        controller.setOwnerApartment(aIdNumber, pIdNumber);
                    } else {
                        System.out.println("The apartment specified doesn't exist.");
                    }
                } else {
                    System.out.println("The owner is incorrect or doesn't exists.");
                }
                
                break; 

            case 6: 	
                System.out.println("Type the tenant id number: ");
                pIdNumber = scan.next();
                hasExistence = controller.checkPersonExistence(2, pIdNumber);
                
                
                if(hasExistence) {
                    System.out.println("These are the available apartments to rent: ");
                    System.out.println(controller.getAvailableApartmentsToRent());
                
                    System.out.println("Choose an apartment: ");
                    aIdNumber = scan.next();
                    
                    pos = controller.getPositionApartmentToSet(aIdNumber);
                    
                    if(pos != -1) {
                        controller.setApartmentRented(pos);
                        controller.setTenantRents(pIdNumber);
                        System.out.println("Apartment rented correctly.");

                    } else {
                        System.out.println("The apartment specified doesn't exist.");
                    }
                } else {
                    System.out.println("The tenant id is incorrect or doesn't exists.");
                }
                break; 

            case 7: 
                System.out.println("Type the name of the building to search: ");
                bName = scan.next();
                pos = controller.getBuildingPosition(bName);
                
                if(pos != -1) {
                    availableApt = controller.getCountAvailableApartmentsToSet(bName);
                    System.out.println("Total apartments availables to set an owner: " + availableApt);
                    
                    availableApt = controller.getCountAvailableApartmentsToRent(bName);
                    System.out.println("Total apartments availables to rent: " + availableApt);

                    
                } else {
                    System.out.println("The building specified doesn't exists.");
                }
                break;                    

            case 8: 
                System.out.println("Type the name of the building: ");
                bName = scan.next();
                pos = controller.getBuildingPosition(bName);      
                
                if(pos != -1) {
                    totalMoney = controller.getMonthlyValueRentedApartments(bName); 
                    System.out.println("Total monthly value received by this building: " + totalMoney);
                } else {
                    System.out.println("The building doesn't exists.");
                }

                break; 

            case 9: 
                System.out.println("Type the apartment id: ");
                aIdNumber = scan.next();
                
                isValid = controller.getApartmentNumberAvailability(aIdNumber);
                
                if(isValid == false) {
                    isAvailable = controller.getApartmentAvailability(aIdNumber);     
                    System.out.println("Apartment available: " + isAvailable);
                } else {
                    System.out.println("The apartment id doesn't exists.");
                }
                
                break; 
                
            case 10:
                System.out.println("Type the tenant id number to search: ");
                pIdNumber = scan.next();
                pos = controller.searchPersonById(2, pIdNumber);
                
                if (pos != -1) {       
                    totalRents = controller.getTotalRentsOfTenant(pos);
                    System.out.println("Total rents of this tenant: " + totalRents);
                } else {
                    System.out.println("Error. The id number entered doesn't exists.");
                }
  
                break;
                
            case 11:
                System.out.println("Type the owner id number: ");
                pIdNumber = scan.next();
                hasExistence = controller.checkPersonExistence(1, pIdNumber);

                if (hasExistence) {
                    pos = controller.searchPersonById(1, pIdNumber);
                    totalMoney = controller.getOwnerMonthlyRentPayment(pos);
                    System.out.println("Total rent value received by an owner: " + totalMoney);
                }
                break;

            case 0: 
                System.out.println("Exit program.");
                break; 

            default: 
                System.out.println("You selected an invalid option.");
                break; 
            }
    }
    
    /**
     * validateIntegerOption validates integer entries entered by the user.
     * @return option represents the validation (if return -1 means that is not an integer).
     */    
    public int validateIntegerOption(){
        int option = 0; 

        if(scan.hasNextInt()){
            option = scan.nextInt(); 
        }
        else{
            scan.nextLine(); 
            System.out.println("Error. You entered a non-numeric value.");
            option = -1; 
        }

        return option; 
    }
}
