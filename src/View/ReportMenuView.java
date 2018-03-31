/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.GameControl;
import Model.InventoryItem;
import Model.Occupation;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

/**
 *
 * @author adm-achina
 */
public class ReportMenuView extends View {

    public ReportMenuView() {
        super("\n"
                + "\n===============Mormon Trail Game================="
                + "\n                                                 "
                + "\n               Report Menu                       "
                + "\n                                                 "
                + "\n1 - Inventory Report - Sorted by Description     "
                + "\n2 - Inventory Report - Sorted by Item Cost       "
                + "\n3 - View Inventory   - Sorted by Description     "
                + "\n4 - View Inventory   - Sorted by Item cost       "
                + "\n5 - View Inventory   - Sorted by Qty in stock    "
                + "\nX - Exit                                         "
                + "\n"
                + "\n=================================================",
                "\nPlease enter your choice: ");

    }

    @Override
    public void display() {

        boolean done = false; // set flag to not done
        try {
            do {
                // prompt for and get menu option
                String value = this.getInput();
                if (value.toUpperCase().equals("X"))// user wants to exit view                
                // do the requested action and display the next view
                {
                    return; // exit view
                }
                done = this.doAction(value);
            } while (!done);
        } catch (NumberFormatException nfe) {
    //        ErrorView.display(this.getClass().getName(), "*** Invalid selection *** Try again");
        }
    }

    @Override
    public boolean doAction(String menu) {
        menu = menu.toUpperCase(); // convert choice to upper cas

        switch (menu) {
            case "1":
                this.fileInventoryDescription();
                break;
            case "2":
                this.fileInventoryCost();
                break;
            case "3":
                this.viewInventoryDescription();
                break;
            case "4":
                this.viewInventoryCost();
                break;
            case "5":
                this.viewInventoryInStock();
                break;
            default:
        //        ErrorView.display(this.getClass().getName(), "*** Invalid selection *** Try again");
                break;
        }
        return false;
    }

    public String getFileName() {

//        Scanner keyboard = new Scanner(System.in);
        boolean valid = false; // initialize to not valid
        String value = null;
        try {
            // while a valid name has not been retrieved
            while (!valid) {
                // get the value entered from keyboard
                value = keyboard.readLine();

                // trim off leading and trailing blanks
                value = value.trim();

                if (value.length() < 1) { // value is blank
             //       ErrorView.display(this.getClass().getName(), "You must enter a value.");
                    continue;
                }
                break; // end the loop
            }

        } catch (Exception e) {
            this.console.println("Error reading input: " + e.getMessage());
        }

        return value; // return the value entered
    }

    private void fileInventoryDescription() {
        PrintWriter bw = null;
        FileWriter fw = null;

        //prompt for and get the name of the file to save the reort in
        this.console.printf("\n\nEnter the path to save report: ");
        File filePath = new File(this.getFileName());

        try {
            fw = new FileWriter(filePath);
            bw = new PrintWriter(fw);
            this.console.println("\nYour file has been saved in " + filePath);

            // get the sorted list of inventory items for the current game
            InventoryItem[] inventory = GameControl.getSortedInventoryListDescription();

            bw.println("\n===============Mormon Trail Game=================");
            bw.println("\n\n   Sorted List of Inventory Items(Description)     ");
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
        //    ErrorView.display(this.getClass().getName(), "***Error writing to file - try again***");
        } finally {

            try {

                if (bw != null) {
                    bw.close();
                }

                if (fw != null) {
                    fw.close();
                }

            } catch (IOException ex) {
            //    ErrorView.display(this.getClass().getName(), "***Error writing to file - try again***");
                ex.printStackTrace();

            }
        }
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
            this.console.println("\nYour file has been saved in " + filePath);

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
       //     ErrorView.display(this.getClass().getName(), "***Error writing to file - try again***");
        } finally {

            try {

                if (bw != null) {
                    bw.close();
                }

                if (fw != null) {
                    fw.close();
                }

            } catch (IOException ex) {
           //     ErrorView.display(this.getClass().getName(), "***Error writing to file - try again***");
                ex.printStackTrace();

            }
        }
    }

    private void viewInventory() {
        // get the sorted list of inventory items for the current game
        InventoryItem[] inventory = GameControl.getSortedInventoryListDescription();

        this.console.println("\nList of Inventory Items");
        StringBuilder line = new StringBuilder("                                                          ");
        line.insert(0, "Description");
        line.insert(20, "Required");
        line.insert(30, "In Stock");
        this.console.println(line.toString());

        // for each inventory item
        for (InventoryItem inventoryItem : inventory) {
            line = new StringBuilder("                                                          ");
            line.insert(0, inventoryItem.getDescription());
            line.insert(23, inventoryItem.getRequiredAmount());
            line.insert(33, inventoryItem.getQuantityInStock());

            // DISPLAY the description, the required amount and amount in stock
            this.console.println(line.toString());
        }
    }

    private void viewInventoryDescription() {
        // get the sorted list of inventory items for the current game
        InventoryItem[] inventory = GameControl.getSortedInventoryListDescription();

        this.console.println("\n===============Mormon Trail Game================="
                + "\n\n   Sorted List of Inventory Items(Description)   "
                + "\n-------------------------------------------------");
        StringBuilder line = new StringBuilder("                                                          ");
        line.insert(0, "Description");
        line.insert(15, "In Stock");
        line.insert(26, "Cost");
        line.insert(38, "Ext-Cost");
        this.console.println(line.toString());
        this.console.println("=================================================");

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
            this.console.println(line.toString());
        }
        double availableFunds = GameControl.getFundAmount();
        double remainingFunds = availableFunds - sumExCost;
        this.console.print("-------------------------------------------------");
        this.console.print("\nCost of Bill                          " + decForm.format(sumExCost));
        this.console.print("\nFunds in hand                         " + decForm.format(availableFunds));
        this.console.print("\nFunds remaining                       " + decForm.format(remainingFunds));
        this.console.println("\n=================================================");
    }

    //function calling bubble sort on inventory cost and displaying to user
    private void viewInventoryCost() {
        InventoryItem[] inventory = GameControl.getSortedInventoryListCost();

        this.console.println("\n===============Mormon Trail Game================="
                + "\n\n    Sorted List of Inventory Items(Item Cost)    "
                + "\n-------------------------------------------------");
        StringBuilder line = new StringBuilder("                                                          ");
        line.insert(0, "Description");
        line.insert(15, "In Stock");
        line.insert(26, "Cost");
        line.insert(38, "Ext-Cost");
        this.console.println(line.toString());
        this.console.println("=================================================");

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
            this.console.println(line.toString());
        }

        double availableFunds = GameControl.getFundAmount();
        double remainingFunds = availableFunds - sumExCost;
        this.console.print("-------------------------------------------------");
        this.console.print("\nCost of Bill                          " + decForm.format(sumExCost));
        this.console.print("\nFunds in hand                         " + decForm.format(availableFunds));
        this.console.print("\nFunds remaining                       " + decForm.format(remainingFunds));
        this.console.println("\n=================================================");
    }

    private void viewInventoryInStock() {

        InventoryItem[] inventory = GameControl.getSortedInventoryListInStock();

        this.console.println("\n===============Mormon Trail Game================="
                + "\n\n  Sorted List of Inventory Items (QTY in Stock)  "
                + "\n-------------------------------------------------");
        StringBuilder line = new StringBuilder("                                                          ");
        line.insert(0, "Description");
        line.insert(15, "In Stock");
        line.insert(26, "Cost");
        line.insert(38, "Ext-Cost");
        this.console.println(line.toString());
        this.console.println("=================================================");

        // for each inventory item
        DecimalFormat decForm = new DecimalFormat("$#,##0.00");
        double sumExCost = 0;
        int itemNo = 0;
        for (InventoryItem inventoryItem : inventory) {
            itemNo += 1;
            line = new StringBuilder("                                                          ");
            line.insert(0, inventoryItem.getDescription());
            line.insert(15, inventoryItem.getQuantityInStock());
            line.insert(26, decForm.format(inventoryItem.getCost()));
            double extCost = (inventoryItem.getCost() * inventoryItem.getQuantityInStock());
            line.insert(38, decForm.format(extCost));
            sumExCost += extCost;

            // DISPLAY the description, the amount in stock, the cost and the extended cost
            this.console.println(line.toString());
        }
        double availableFunds = GameControl.getFundAmount();
        double remainingFunds = availableFunds - sumExCost;
        this.console.print("-------------------------------------------------");
        this.console.print("\nCost of Bill                          " + decForm.format(sumExCost));
        this.console.print("\nFunds in hand                         " + decForm.format(availableFunds));
        this.console.print("\nFunds remaining                       " + decForm.format(remainingFunds));
        this.console.println("\n=================================================");

    }

    private void Inventory() {
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
        double availableFunds = GameControl.getFundAmount();
        double remainingFunds = availableFunds - sumExCost;
        this.console.print("-------------------------------------------------");
        this.console.print("\nCost of Bill                          " + decForm.format(sumExCost));
        this.console.print("\nFunds in hand                         " + decForm.format(availableFunds));
        this.console.print("\nFunds remaining                       " + decForm.format(remainingFunds));
        this.console.println("\n=================================================");

    }

    private void stockInHand() {
        InventoryItem[] inventory = mormontrail.MormonTrail.getCurrentGame().getInventory();
        Occupation[] occupation = mormontrail.MormonTrail.getCurrentGame().getOccupation();

        this.console.println("\n===============Mormon Trail Game================="
                + "\n\n          Inventory - Stock in Hand            "
                + "\n-------------------------------------------------");
        StringBuilder line = new StringBuilder("                                                          ");
        line.insert(0, "Description");
        line.insert(37, "Quantity");
        this.console.println(line.toString());
        this.console.println("=================================================");

        // for each inventory item
        int num = 0;

        for (InventoryItem inventoryItem : inventory) {
            num += 1;
            line = new StringBuilder("                                                          ");
            line.insert(0, num + " - " + inventoryItem.getDescription());
            line.insert(37, inventoryItem.getQuantityInStock());

            // DISPLAY the description, the amount in stock, the cost and the extended cost
            this.console.println(line.toString());
        }
        this.console.println("=================================================");

    }

    private void occupation() {
        Occupation[] occupation = mormontrail.MormonTrail.getCurrentGame().getOccupation();

        this.console.println("\n===============Mormon Trail Game================="
                + "\n\n       Occupation types & Initial Funds        "
                + "\n-------------------------------------------------");
        StringBuilder line = new StringBuilder("                                                          ");
        line.insert(0, "Description");
        line.insert(37, "Initial Fund");
        this.console.println(line.toString());
        this.console.println("=================================================");

        // for each inventory item
        int num = 0;

        for (Occupation job : occupation) {
            num += 1;
            line = new StringBuilder("                                                          ");
            line.insert(0, num + " - " + job.getDescription());
            line.insert(38, job.getFundAmount());

            // DISPLAY the description, the amount in stock, the cost and the extended cost
            this.console.println(line.toString());
        }
        this.console.println("=================================================");

    }

}
