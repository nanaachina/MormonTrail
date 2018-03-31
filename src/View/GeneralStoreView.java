/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.GameControl;
import Control.InventoryControl;
import Exceptions.InventoryControlException;
import Model.InventoryItem;
import Model.ItemType;
import Model.Occupation;
import java.text.DecimalFormat;

/**
 *
 * @author adm-achina
 */
public class GeneralStoreView extends View {

    private final String storePage1;
    private final String promptMessage;
    private final String promptMessage1;
    private final String promptMessage2;

    public GeneralStoreView() {

        this.storePage1 = "\n"
                + "\n================Felix General Store=============="
                + "\n                                                 "
                + "\n  Hello, I´m Felix. So you´re going to Salt Lake Valley!    "
                + "\n  I can fix you up with whatever you need:       "
                + "\n                                                 "
                + "\n  - A team of oxen to pull your wagon            "
                + "\n                                                 "
                + "\n  - Clothing for both summer and winter          "
                + "\n                                                 "
                + "\n  - Plenty of food for your trip                 "
                + "\n                                                 "
                + "\n  - Ammunition for your rifles                   "
                + "\n                                                 "
                + "\n  - Spare parts for your wagon                   "
                + "\n=================================================";

        this.promptMessage = "\nPlease press 'C' to continue: ";

        this.promptMessage1 = "\nPlease choose an item to buy...";

        this.promptMessage2 = "OR - Press 'C' to leave the store: ";
    }

    void displayStorePage() {
        boolean done = false; // set flag to not done
        do {
            // continue will exit loop
            String displayStorePage1 = this.getStorePage1();
            if (displayStorePage1.toUpperCase().equals("C"))// user wants to return to main menu
            {
                break; // exit loop
            }
            // do the requested action and display the next view
            done = this.doAction(displayStorePage1);
        } while (!done);

        do {
            // continue will exit loop

            String displayStorePage2 = this.getStorePage2();
            if (displayStorePage2.toUpperCase().equals("C"))// user wants move to game menu
            {
                GameMenuView gameMenu = new GameMenuView();
                gameMenu.display();
            }
            // do the requested action and display the next view
            done = this.doAction(displayStorePage2);
        } while (!done);

    }

    @Override
    public boolean doAction(String text) {

        text = text.toUpperCase();

        switch (text) {

            case "1": //Choose Oxen
                this.oxenChoice();
                break;

            case "2": //Choose Food
                this.foodChoice();
                break;

            case "3": //Choose Clothing
                this.clothChoice();
                break;

            case "4": //Choose Ammunition
                this.ammoChoice();
                break;

            case "5": //Choose Spare Parts
                this.wheelsChoice();
                break;

            case "6": //Choose Spare Parts
                this.axleChoice();
                break;

            case "7": //Choose Spare Parts
                this.tongueChoice();
                break;

            default: //Get error message
               // ErrorView.display(this.getClass().getName(), "*** Invalid selection *** Try again");
                break;
        }

        return false;

    }

    private String getStorePage1() {

//        Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        String value = ""; // value to be returned
        boolean valid = false; // initialize to not valid
        try {
            while (!valid) { // loop while an invalid value is entered
                this.console.printf(this.storePage1);
                this.console.printf(this.promptMessage);

                value = keyboard.readLine(); // get next line typed on keyboard

                value = value.trim().toUpperCase(); // trim off leading and trailing blanks

                if (value.length() < 1) { // value is blank
                 //   ErrorView.display(this.getClass().getName(), "You must enter a value.");
                    continue;
                }
                break; // end the loop
            }
        } catch (Exception e) {
         //   ErrorView.display(this.getClass().getName(), "Error reading input: " + e.getMessage());
        }
        return value; // return the value entered      
    }

    private String getStorePage2() {

        //Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        String value = ""; // value to be returned
        boolean valid = false; // initialize to not valid
        try {
            while (!valid) { // loop while an invalid value is entered
                this.store();
                this.console.println(this.promptMessage1);
                this.console.printf(this.promptMessage2);

                value = keyboard.readLine(); // get next line typed on keyboard
                value = value.trim().toUpperCase(); // trim off leading and trailing blanks

                if (value.length() < 1) { // value is blank
                 //   ErrorView.display(this.getClass().getName(), "You must enter a value.");
                    continue;
                }

                break; // end the loop

            }

        } catch (Exception e) {
        //    ErrorView.display(this.getClass().getName(), "Error reading input: " + e.getMessage());

        }
        return value; // return the value entered 
    }

    public void oxenChoice() {
        DecimalFormat decForm = new DecimalFormat("$#,##0.00");
//        Scanner keyboard = new Scanner(System.in);
        int oxenQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Oxen.ordinal()].getQuantityInStock();
        String oxenDescription = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Oxen.ordinal()].getDescription();
        int clothQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Clothing.ordinal()].getQuantityInStock();
        String clothDescription = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Clothing.ordinal()].getDescription();
        int ammoQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Ammunition.ordinal()].getQuantityInStock();
        String ammoDescription = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Ammunition.ordinal()].getDescription();
        int foodQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Food.ordinal()].getQuantityInStock();
        String foodDescription = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Food.ordinal()].getDescription();
        int axleQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Axle.ordinal()].getQuantityInStock();
        String axleDescription = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Axle.ordinal()].getDescription();        
        int wheelQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Wheel.ordinal()].getQuantityInStock();
        String wheelDescription = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Wheel.ordinal()].getDescription();        
        int tongueQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Tongue.ordinal()].getQuantityInStock();
        int tongueDescription = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Tongue.ordinal()].getQuantityInStock();
        int addQuantity = 0;
        boolean done = false;
        try {
            do {
                try {
                    this.console.printf("\nPlease enter the " + oxenDescription + " Quantity: ");
                    boolean complete = false;
                    do {
                        try {
                            String quantity = keyboard.readLine();
                            addQuantity = Integer.parseInt(quantity);
                            complete = true;
                        } catch (NumberFormatException nf) {
                         //   ErrorView.display(this.getClass().getName(), "***You must enter a valid number***");
                            this.console.println("\nPlease enter the " + oxenDescription + " Quantity: ");
                            complete = false;
//                        sleep(2500);
                        } 
                    } while (!complete);
                    oxenQuantity = addQuantity + oxenQuantity;
                    InventoryControl.checkInventoryLimits(oxenQuantity, clothQuantity, ammoQuantity, foodQuantity, axleQuantity, wheelQuantity, tongueQuantity);
                    done = true;
                } catch (InventoryControlException ice) {
                    this.console.println(ice.getMessage());
                    oxenQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Oxen.ordinal()].getQuantityInStock();
                    addQuantity = 0;
                    done = false;

                }

            } while (!done);
        } catch (Exception e) {
        //    ErrorView.display(this.getClass().getName(), "***Error reading input***");
        }

        InventoryItem item = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Oxen.ordinal()]; // get item from array
        int quantity = item.getQuantityInStock() + addQuantity; // adds orginal to entered quantity

        item.setQuantityInStock(quantity); // sets new amount of inventory item
        mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Oxen.ordinal()] = item; // good practice - sets updated inventory item to inventory array

        this.console.println("\n*** You have purchased " + quantity + " " + item.getDescription() + " *** costing " + decForm.format((item.getCost()) * (item.getQuantityInStock())));
//            sleep(2500);
    }

    public void clothChoice() {
        DecimalFormat decForm = new DecimalFormat("$#,##0.00");
//        Scanner keyboard = new Scanner(System.in);
        int oxenQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Oxen.ordinal()].getQuantityInStock();
        String oxenDescription = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Oxen.ordinal()].getDescription();
        int clothQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Clothing.ordinal()].getQuantityInStock();
        String clothDescription = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Clothing.ordinal()].getDescription();
        int ammoQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Ammunition.ordinal()].getQuantityInStock();
        String ammoDescription = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Ammunition.ordinal()].getDescription();
        int foodQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Food.ordinal()].getQuantityInStock();
        String foodDescription = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Food.ordinal()].getDescription();
        int axleQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Axle.ordinal()].getQuantityInStock();
        String axleDescription = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Axle.ordinal()].getDescription();        
        int wheelQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Wheel.ordinal()].getQuantityInStock();
        String wheelDescription = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Wheel.ordinal()].getDescription();        
        int tongueQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Tongue.ordinal()].getQuantityInStock();
        int tongueDescription = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Tongue.ordinal()].getQuantityInStock();
        int addQuantity = 0;
        boolean done = false;
        try {
            do {
                try {
                    this.console.printf("\nPlease enter the " + clothDescription + " Quantity: ");
                    boolean complete = false;
                    do {
                        try {
                            String quantity = keyboard.readLine();
                            addQuantity = Integer.parseInt(quantity);
                            complete = true;
                        } catch (NumberFormatException nf) {
                      //      ErrorView.display(this.getClass().getName(), "***You must enter a valid number***");
                            this.console.printf("\nPlease enter the " + clothDescription + " Quantity: ");
                            complete = false;
//                        sleep(2500);
                        } 
                    } while (!complete);
                    clothQuantity = addQuantity + clothQuantity;
                    InventoryControl.checkInventoryLimits(oxenQuantity, clothQuantity, ammoQuantity, foodQuantity, axleQuantity, wheelQuantity, tongueQuantity);

                } catch (InventoryControlException ice) {
                    this.console.println(ice.getMessage());
                    clothQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Clothing.ordinal()].getQuantityInStock();
                    addQuantity = 0;
                    done = false;
                }
                done = true;
            } while (!done);
        } catch (Exception e) {
        //    ErrorView.display(this.getClass().getName(), "***Error reading input***");
        }

        InventoryItem item = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Clothing.ordinal()]; // get item from array
        int quantity = item.getQuantityInStock() + addQuantity; // adds orginal to entered quantity

        item.setQuantityInStock(quantity); // sets new amount of inventory item
        mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Clothing.ordinal()] = item; // good practice - sets updated inventory item to inventory array

        this.console.println("\n*** You have purchased " + quantity + " " + item.getDescription() + " *** costing " + decForm.format((item.getCost()) * (item.getQuantityInStock())));
//            sleep(2500);
    }

    public void ammoChoice() {
        DecimalFormat decForm = new DecimalFormat("$#,##0.00");
//        Scanner keyboard = new Scanner(System.in);
        int oxenQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Oxen.ordinal()].getQuantityInStock();
        String oxenDescription = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Oxen.ordinal()].getDescription();
        int clothQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Clothing.ordinal()].getQuantityInStock();
        String clothDescription = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Clothing.ordinal()].getDescription();
        int ammoQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Ammunition.ordinal()].getQuantityInStock();
        String ammoDescription = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Ammunition.ordinal()].getDescription();
        int foodQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Food.ordinal()].getQuantityInStock();
        String foodDescription = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Food.ordinal()].getDescription();
        int axleQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Axle.ordinal()].getQuantityInStock();
        String axleDescription = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Axle.ordinal()].getDescription();        
        int wheelQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Wheel.ordinal()].getQuantityInStock();
        String wheelDescription = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Wheel.ordinal()].getDescription();        
        int tongueQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Tongue.ordinal()].getQuantityInStock();
        int tongueDescription = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Tongue.ordinal()].getQuantityInStock();
        int addQuantity = 0;
        boolean done = false;
        try {
            do {
                try {
                    this.console.printf("\nPlease enter the " + ammoDescription + " Quantity: ");
                    boolean complete = false;
                    do {
                        try {
                            String quantity = keyboard.readLine();
                            addQuantity = Integer.parseInt(quantity);
                            complete = true;
                        } catch (NumberFormatException nf) {
                         //   ErrorView.display(this.getClass().getName(), "***You must enter a valid number***");
                            this.console.printf("\nPlease enter the " + ammoDescription + " Quantity: ");
                            complete = false;
//                        sleep(2500);
                        } 
                    } while (!complete);
                    ammoQuantity = addQuantity + ammoQuantity;
                    InventoryControl.checkInventoryLimits(oxenQuantity, clothQuantity, ammoQuantity, foodQuantity, axleQuantity, wheelQuantity, tongueQuantity);

                } catch (InventoryControlException ice) {
                    this.console.println(ice.getMessage());
                    ammoQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Ammunition.ordinal()].getQuantityInStock();
                    addQuantity = 0;
                    done = false;
                }
                done = true;
            } while (!done);
        } catch (Exception e) {
          //  ErrorView.display(this.getClass().getName(), "***Error reading input***");
        }

        InventoryItem item = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Ammunition.ordinal()]; // get item from array
        int quantity = item.getQuantityInStock() + addQuantity; // adds orginal to entered quantity

        item.setQuantityInStock(quantity); // sets new amount of inventory item
        mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Ammunition.ordinal()] = item; // good practice - sets updated inventory item to inventory array

        this.console.println("\n*** You have purchased " + quantity + " " + item.getDescription() + " *** costing " + decForm.format((item.getCost()) * (item.getQuantityInStock())));
//            sleep(2500);
    }

    public void foodChoice() {
        DecimalFormat decForm = new DecimalFormat("$#,##0.00");
//        Scanner keyboard = new Scanner(System.in);
        int oxenQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Oxen.ordinal()].getQuantityInStock();
        String oxenDescription = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Oxen.ordinal()].getDescription();
        int clothQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Clothing.ordinal()].getQuantityInStock();
        String clothDescription = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Clothing.ordinal()].getDescription();
        int ammoQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Ammunition.ordinal()].getQuantityInStock();
        String ammoDescription = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Ammunition.ordinal()].getDescription();
        int foodQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Food.ordinal()].getQuantityInStock();
        String foodDescription = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Food.ordinal()].getDescription();
        int axleQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Axle.ordinal()].getQuantityInStock();
        String axleDescription = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Axle.ordinal()].getDescription();        
        int wheelQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Wheel.ordinal()].getQuantityInStock();
        String wheelDescription = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Wheel.ordinal()].getDescription();        
        int tongueQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Tongue.ordinal()].getQuantityInStock();
        int tongueDescription = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Tongue.ordinal()].getQuantityInStock();
        int addQuantity = 0;
        int newQuantity = 0;
        boolean done = false;
        try {
            do {
                try {
                    this.console.printf("\nPlease enter the " + foodDescription + " Quantity: ");
                    boolean complete = false;
                    do {
                        try {
                            String quantity = keyboard.readLine();
                            addQuantity = Integer.parseInt(quantity);
                            complete = true;
                        } catch (NumberFormatException nf) {
                         //   ErrorView.display(this.getClass().getName(), "***You must enter a valid number***");
                            this.console.printf("\nPlease enter the " + foodDescription + " Quantity: ");
                            complete = false;
//                        sleep(2500);
                        } 
                    } while (!complete);
                    foodQuantity = addQuantity + foodQuantity;
                    InventoryControl.checkInventoryLimits(oxenQuantity, clothQuantity, ammoQuantity, foodQuantity, axleQuantity, wheelQuantity, tongueQuantity);

                } catch (InventoryControlException ice) {
                    this.console.println(ice.getMessage());
                    foodQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Food.ordinal()].getQuantityInStock();
                    addQuantity = 0;
                    done = false;
                }
                done = true;
            } while (!done);
        } catch (Exception e) {
        //    ErrorView.display(this.getClass().getName(), "***Error reading input***");
        }

        InventoryItem item = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Food.ordinal()]; // get item from array
        int quantity = item.getQuantityInStock() + addQuantity; // adds orginal to entered quantity

        item.setQuantityInStock(quantity); // sets new amount of inventory item
        mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Food.ordinal()] = item; // good practice - sets updated inventory item to inventory array

        this.console.println("\n*** You have purchased " + quantity + " " + item.getDescription() + " *** costing " + decForm.format((item.getCost()) * (item.getQuantityInStock())));
//            sleep(2500);
    }

    public void wheelsChoice() {
        DecimalFormat decForm = new DecimalFormat("$#,##0.00");
//        Scanner keyboard = new Scanner(System.in);
        int oxenQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Oxen.ordinal()].getQuantityInStock();
        String oxenDescription = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Oxen.ordinal()].getDescription();
        int clothQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Clothing.ordinal()].getQuantityInStock();
        String clothDescription = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Clothing.ordinal()].getDescription();
        int ammoQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Ammunition.ordinal()].getQuantityInStock();
        String ammoDescription = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Ammunition.ordinal()].getDescription();
        int foodQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Food.ordinal()].getQuantityInStock();
        String foodDescription = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Food.ordinal()].getDescription();
        int axleQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Axle.ordinal()].getQuantityInStock();
        String axleDescription = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Axle.ordinal()].getDescription();        
        int wheelQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Wheel.ordinal()].getQuantityInStock();
        String wheelDescription = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Wheel.ordinal()].getDescription();        
        int tongueQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Tongue.ordinal()].getQuantityInStock();
        int tongueDescription = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Tongue.ordinal()].getQuantityInStock();
        int addQuantity = 0;
        boolean done = false;
        try {
            do {
                try {
                    this.console.printf("\nPlease enter the " + wheelDescription + " Quantity: ");
                    boolean complete = false;
                    do {
                        try {
                            String quantity = keyboard.readLine();
                            addQuantity = Integer.parseInt(quantity);
                            complete = true;
                        } catch (NumberFormatException nf) {
                         //   ErrorView.display(this.getClass().getName(), "***You must enter a valid number***");
                            this.console.printf("\nPlease enter the " + wheelDescription + " Quantity: ");
                            complete = false;
//                        sleep(2500);
                        } 
                    } while (!complete);
                    wheelQuantity = addQuantity + wheelQuantity;
                    InventoryControl.checkInventoryLimits(oxenQuantity, clothQuantity, ammoQuantity, foodQuantity, axleQuantity, wheelQuantity, tongueQuantity);

                } catch (InventoryControlException ice) {
                    this.console.println(ice.getMessage());
                    wheelQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Wheel.ordinal()].getQuantityInStock();
                    addQuantity = 0;
                    done = false;
                }
                done = true;
            } while (!done);
        } catch (Exception e) {
          //  ErrorView.display(this.getClass().getName(), "***Error reading input***");
        }

        InventoryItem item = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Wheel.ordinal()]; // get item from array
        int quantity = item.getQuantityInStock() + addQuantity; // adds orginal to entered quantity

        item.setQuantityInStock(quantity); // sets new amount of inventory item
        mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Wheel.ordinal()] = item; // good practice - sets updated inventory item to inventory array

        this.console.println("\n*** You have purchased " + quantity + " " + item.getDescription() + " *** costing " + decForm.format((item.getCost()) * (item.getQuantityInStock())));
//            sleep(2500);
    }

    public void axleChoice() {
        DecimalFormat decForm = new DecimalFormat("$#,##0.00");
//        Scanner keyboard = new Scanner(System.in);
        int oxenQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Oxen.ordinal()].getQuantityInStock();
        String oxenDescription = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Oxen.ordinal()].getDescription();
        int clothQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Clothing.ordinal()].getQuantityInStock();
        String clothDescription = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Clothing.ordinal()].getDescription();
        int ammoQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Ammunition.ordinal()].getQuantityInStock();
        String ammoDescription = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Ammunition.ordinal()].getDescription();
        int foodQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Food.ordinal()].getQuantityInStock();
        String foodDescription = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Food.ordinal()].getDescription();
        int axleQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Axle.ordinal()].getQuantityInStock();
        String axleDescription = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Axle.ordinal()].getDescription();        
        int wheelQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Wheel.ordinal()].getQuantityInStock();
        String wheelDescription = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Wheel.ordinal()].getDescription();        
        int tongueQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Tongue.ordinal()].getQuantityInStock();
        int tongueDescription = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Tongue.ordinal()].getQuantityInStock();
        int addQuantity = 0;
        boolean done = false;
        try {
            do {
                try {
                    this.console.printf("\nPlease enter the " + axleDescription + " Quantity: ");
                    boolean complete = false;
                    do {
                        try {
                            String quantity = keyboard.readLine();
                            addQuantity = Integer.parseInt(quantity);
                            complete = true;
                        } catch (NumberFormatException nf) {
                          //  ErrorView.display(this.getClass().getName(), "***You must enter a valid number***");
                            this.console.printf("\nPlease enter the " + axleDescription + " Quantity: ");
                            complete = false;
//                        sleep(2500);
                        } 
                    } while (!complete);
                    axleQuantity = addQuantity + axleQuantity;
                    InventoryControl.checkInventoryLimits(oxenQuantity, clothQuantity, ammoQuantity, foodQuantity, axleQuantity, wheelQuantity, tongueQuantity);

                } catch (InventoryControlException ice) {
                    this.console.println(ice.getMessage());
                    axleQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Axle.ordinal()].getQuantityInStock();
                    addQuantity = 0;
                    done = false;
                }
                done = true;
            } while (!done);
        } catch (Exception e) {
        //    ErrorView.display(this.getClass().getName(), "***Error reading input***");
        }

        InventoryItem item = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Axle.ordinal()]; // get item from array
        int quantity = item.getQuantityInStock() + addQuantity; // adds orginal to entered quantity

        item.setQuantityInStock(quantity); // sets new amount of inventory item
        mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Axle.ordinal()] = item; // good practice - sets updated inventory item to inventory array

        this.console.println("\n*** You have purchased " + quantity + " " + item.getDescription() + " *** costing " + decForm.format((item.getCost()) * (item.getQuantityInStock())));
//            sleep(2500);
    }

    public void tongueChoice() {
        DecimalFormat decForm = new DecimalFormat("$#,##0.00");
//        Scanner keyboard = new Scanner(System.in);
        int oxenQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Oxen.ordinal()].getQuantityInStock();
        String oxenDescription = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Oxen.ordinal()].getDescription();
        int clothQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Clothing.ordinal()].getQuantityInStock();
        String clothDescription = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Clothing.ordinal()].getDescription();
        int ammoQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Ammunition.ordinal()].getQuantityInStock();
        String ammoDescription = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Ammunition.ordinal()].getDescription();
        int foodQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Food.ordinal()].getQuantityInStock();
        String foodDescription = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Food.ordinal()].getDescription();
        int axleQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Axle.ordinal()].getQuantityInStock();
        String axleDescription = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Axle.ordinal()].getDescription();
        int wheelQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Wheel.ordinal()].getQuantityInStock();
        String wheelDescription = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Wheel.ordinal()].getDescription();
        int tongueQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Tongue.ordinal()].getQuantityInStock();
        int tongueDescription = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Tongue.ordinal()].getQuantityInStock();

        int addQuantity = 0;
        boolean done = false;
        try {
            do {
                try {
                    this.console.printf("\nPlease enter the " + tongueDescription + " Quantity: ");
                    boolean complete = false;
                    do {
                        try {
                            String quantity = keyboard.readLine();
                            addQuantity = Integer.parseInt(quantity);
                            complete = true;
                        } catch (NumberFormatException nf) {
                       //     ErrorView.display(this.getClass().getName(), "***You must enter a valid number***");
                            this.console.printf("\nPlease enter the " + tongueDescription + " Quantity: ");
                            complete = false;
//                        sleep(2500);
                        } 
                    } while (!complete);
                    tongueQuantity = addQuantity + tongueQuantity;
                    InventoryControl.checkInventoryLimits(oxenQuantity, clothQuantity, ammoQuantity, foodQuantity, axleQuantity, wheelQuantity, tongueQuantity);

                } catch (InventoryControlException ice) {
                    this.console.println(ice.getMessage());
                    tongueQuantity = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Tongue.ordinal()].getQuantityInStock();
                    addQuantity = 0;
                    done = false;
                }
                done = true;
            } while (!done);
        } catch (Exception e) {
      //      ErrorView.display(this.getClass().getName(), "***Error reading input***");
        }

        InventoryItem item = mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Tongue.ordinal()]; // get item from array
        int quantity = item.getQuantityInStock() + addQuantity; // adds orginal to entered quantity

        item.setQuantityInStock(quantity); // sets new amount of inventory item
        mormontrail.MormonTrail.getCurrentGame().getInventory()[ItemType.Tongue.ordinal()] = item; // good practice - sets updated inventory item to inventory array

        this.console.println("\n*** You have purchased " + quantity + " " + item.getDescription() + " *** costing " + decForm.format((item.getCost()) * (item.getQuantityInStock())));
//            sleep(2500);
    }

    private void store() {
        InventoryItem[] inventory = mormontrail.MormonTrail.getCurrentGame().getInventory();
        Occupation[] occupation = mormontrail.MormonTrail.getCurrentGame().getOccupation();

        this.console.println("\n===============Mormon Trail Game================="
                + "\n\n                   Inventory                   "
                + "\n-------------------------------------------------");
        StringBuilder line = new StringBuilder("                                                          ");
        line.insert(0, "Description");
        line.insert(15, "Quantity");
        line.insert(26, "Cost");
        line.insert(38, "Ext-Cost");
        this.console.println(line.toString());
        this.console.println("=================================================");

        // for each inventory item
        DecimalFormat decForm = new DecimalFormat("$#,##0.00");
        double sumExCost = 0;
        int num = 0;

        for (InventoryItem inventoryItem : inventory) {
            num += 1;
            line = new StringBuilder("                                                          ");
            line.insert(0, num + " - " + inventoryItem.getDescription());
            line.insert(15, inventoryItem.getQuantityInStock());
            line.insert(26, decForm.format(inventoryItem.getCost()));
            double extCost = (inventoryItem.getCost() * inventoryItem.getQuantityInStock());
            line.insert(38, decForm.format(extCost));
            sumExCost += extCost;
            // DISPLAY the description, the amount in stock, the cost and the extended cost
            this.console.println(line.toString());
        }
        double availableFunds = GameControl.getFundAmount(); // set this in the game so that it will be saved and recalled.
        double remainingFunds = availableFunds - sumExCost;
        this.console.println("-------------------------------------------------");
        this.console.println("Cost of Bill                          " + decForm.format(sumExCost));
        this.console.println("Funds in hand                         " + decForm.format(availableFunds));
        this.console.println("Funds remaining                       " + decForm.format(remainingFunds));
        this.console.println("=================================================");

    }

    private void stockInHand() {
        InventoryItem[] inventory = mormontrail.MormonTrail.getCurrentGame().getInventory();
        Occupation[] occupation = mormontrail.MormonTrail.getCurrentGame().getOccupation();

        this.console.println("\n===============Mormon Trail Game================="
                + "\n\n                   Inventory                   "
                + "\n-------------------------------------------------");
        StringBuilder line = new StringBuilder("                                                          ");
        line.insert(0, "Description");
        line.insert(38, "Quantity");
        this.console.println(line.toString());
        this.console.println("=================================================");

        // for each inventory item
        int num = 0;

        for (InventoryItem inventoryItem : inventory) {
            num += 1;
            line = new StringBuilder("                                                          ");
            line.insert(0, num + " - " + inventoryItem.getDescription());
            line.insert(38, inventoryItem.getQuantityInStock());

            // DISPLAY the description, the amount in stock, the cost and the extended cost
            this.console.println(line.toString());
            this.console.println("=================================================");
        }
    }

    public static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
        }
    }
}
