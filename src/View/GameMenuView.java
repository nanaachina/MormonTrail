/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.GameControl;
import Model.InventoryItem;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

/**
 *
 * @author adm-achina
 */
public class GameMenuView extends View {

    public GameMenuView() {
        super("\n"
                + "\n===============Mormon Trail Game================="
                + "\n                                                 "
                + "\n                   Game Menu                     "
                + "\n-------------------------------------------------"
                + "\n    Location: "
                + "\n    Date:     " + GameControl.getStartDate()
                + "\n    Weather:  " + GameControl.getWeather()
                + "\n    Health:   " + GameControl.getHealth()
                + "\n    Pace:     " + GameControl.getPace()
                + "\n    Rations:  " + GameControl.getRation()
                + "\n-------------------------------------------------"
                + "\n                                                 "
                + "\n1 - View map                                     "
                + "\n2 - View location                                "
                + "\n3 - Start on the trail                           "
                + "\n4 - Continue on the trail"
                + "\n5 - River Crossing menu                          "
                + "\n6 - Hunt menu                                    "
                + "\n7 - Change pace menu                             "
                + "\n8 - Change food rations menu                     "
                + "\n9 - Take a rest                                  "
                + "\nT - Attempt to trade menu                        "
                + "\nP - Talk to people                               "
                + "\nI - Inventory report menu                        "
                + "\nH - Display help menu                            "
                + "\nQ - Return to store                              "
                + "\nM - Return to main menu                          "
                + "\n                                                 "
                + "\n=================================================",
                "\nPlease enter your choice: ");
    }

    @Override
    public boolean doAction(String value) {

        value = value.toUpperCase(); // convert to all upper case
        char choice = value.charAt(0); // get first character entered

        switch (choice) {
            case '1': // Travel to new location
                this.displayMap();
                break;
            case '2': // View description of location
                this.viewLocation();
                break;
            case '3': // Move actors on trail
                this.travelTheTrail();
                break;
            case '4': // continue on the trail menu
                this.TrailMenu();
                break;
            /**case '5': // River crossing menu
                this.riverCrossing();
                break; **/
            case '6': // hunt menu
                this.hunt();
                break;
            case '7': // change pace
                this.paceChange();
                break;
            case '8': // change rations
                this.rationChange();
                break;
            case '9': // change rations
                this.TakeARest();
                break;
            case 'T': // attempt to trade
                this.tradeAttempt();
                break;
            case 'P': // talk to people
                this.talkToPeople();
                break;
            case 'I': // inventory report
                this.inventoryReport();
                break;
            case 'H': // display the help menu
                this.displayHelpMenu();
                break;
            case 'Q':
                GeneralStoreView storeView = new GeneralStoreView();
                storeView.display();
                return true;
            case 'M':
                MainMenuView mainMenu = new MainMenuView();
                mainMenu.display();
            default:
                ErrorView.display(this.getClass().getName(), "*** Invalid selection *** Try again");
        }
        return false;
    }

    private void displayMap() {
        DisplayMapView displayMap = new DisplayMapView();
        displayMap.displayMap();
    }

    private void viewLocation() {
        this.console.println("\n***viewLocation function stub called***");

    }

    private void travelTheTrail() {

        this.console.println("\n***travelTheTrail function stub called***");
        this.console.println("\n***We are almost completed this function***");
    }
/**
    private void riverCrossing() {
        RiverCrossingMenuView river = new RiverCrossingMenuView();
        river.display();
    }
**/
    private void hunt() {
        HuntMenuView hunt = new HuntMenuView();
        hunt.display();
    }

    private void inventoryReport() {
        ReportMenuView report = new ReportMenuView();
        report.display();
    }

    private void rationChange() {
        RationMenuView ration = new RationMenuView();
        ration.display();
    }

    private void paceChange() {
        PaceMenuView pace = new PaceMenuView();
        pace.display();
    }

    private void tradeAttempt() {
        this.console.println("***tradeAttempt() function stub called***");
    }

    private void TakeARest() {
        RestMenuView rest = new RestMenuView();
        rest.display();
    }

    private void TrailMenu() {

        this.console.println("\n***This is yet to be implemented - a menu has been      ***");
        this.console.println("***created and will be implemented when the Start on the***");
        this.console.println("***Trail menu has been sorted                           ***");
        

    }

    private void talkToPeople() {
        this.console.println("***talkToPeople() function stub called***");
    }

    private void displayHelpMenu() {
        HelpInfoView helpMenu = new HelpInfoView();
        helpMenu.display();
    }

    public String getFileName() {

       
        boolean valid = false; // initialize to not valid
        String value = null;
        try {
           
            while (!valid) {
                // get the value entered from keyboard
                value = keyboard.readLine();

                // trim off leading and trailing blanks
                value = value.trim();

                if (value.length() < 1) { // value is blank
                    ErrorView.display(this.getClass().getName(), "You must enter a value.");
                    continue;
                }
                break; // end the loop
            }

        } catch (Exception e) {
            this.console.println("Error reading input: " + e.getMessage());
        }

        return value; // return the value entered
    }

    private void fileInventoryCost() {
        PrintWriter bw = null;
        FileWriter fw = null;

        //prompt for and get the name of the file to save the game in
        this.console.printf("\n\nEnter the path to save report: ");
        File filePath = new File(this.getFileName());

        try {
            fw = new FileWriter(filePath);
            bw = new PrintWriter(fw);
            this.console.printf("\nYour file has been saved in " + filePath);

            // get the sorted list of inventory items for the current game
            InventoryItem[] inventory = GameControl.getSortedInventoryListCost();
            bw.println("\n===============Mormon Trail Game=================");
            bw.println("\n\n     Sorted List of Inventory Items(Cost)    ");
            bw.println("\n-------------------------------------------------");
            StringBuilder line = new StringBuilder("                                                          ");
            line.insert(0, "Description");
            line.insert(15, "In Stock");
            line.insert(26, "Cost");
            line.insert(38, "Ext-Cost");
            bw.println(line.toString());
            bw.println("=================================================");

            // for each inventory item
            DecimalFormat decForm = new DecimalFormat("$#,##0.00");
            double sumExCost = 0;
            for (InventoryItem inventoryItem : inventory) {
                line = new StringBuilder("                                                          ");
                line.insert(0, inventoryItem.getDescription());
                line.insert(15, inventoryItem.getQuantityInStock());
                line.insert(26, decForm.format(inventoryItem.getCost()));
                double extCost = (inventoryItem.getCost() * inventoryItem.getQuantityInStock());
                line.insert(38, decForm.format(extCost));
                sumExCost += extCost;

                // DISPLAY the description, the amount in stock, the cost and the extended cost
                bw.println(line.toString());
            }

            bw.println("-------------------------------------------------");
            bw.println("\nCost of Bill                          " + decForm.format(sumExCost));
            bw.println("\n=================================================");

        } catch (IOException e) {
            ErrorView.display(this.getClass().getName(), "***Error writing to file - try again***");
        } finally {

            try {

                if (bw != null) {
                    bw.close();
                }

                if (fw != null) {
                    fw.close();
                }

            } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(), "***Error writing to file - try again***");
                ex.printStackTrace();

            }
        }
    }

}
