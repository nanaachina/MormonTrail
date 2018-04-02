/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.GameControl;
import Control.MapControl;

/**
 *
 * @author adm-achina
 */
public class TrailStatusView extends View {
        
    public TrailStatusView() {
        super("\n"
                + "\n===============Mormon Trail Game================="
                + "\n                                                 "
                + "\n               Trail Status Menu                 "
                + "\n                                                 "
                + "\n    Location: Independence"
                + "\n    Date:     " + GameControl.getStartDate()
                + "\n    Weather:  Cold                               "
                + "\n    Health:   Good                               "
                + "\n    Pace:     Steady                             "
                + "\n    Rations:  Filling                            "
                + "\n                                                 "
                + "\n1 - Continue on trail                            "
                + "\n2 - Check Inventory                              "
                + "\n3 - View map                                     "
                + "\n4 - Change pace                                  "
                + "\n5 - Change food rations                          "
                + "\n6 - Stop to rest                                 "
                + "\n7 - Attempt to trade                             "
                + "\n8 - Hunt                                         "
                + "\nX - Exit                                         "
                + "\n                                                 "
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
            ErrorView.display(this.getClass().getName(), "*** Invalid selection *** Try again");
        }
    }

    @Override
    public boolean doAction(String menu) {
       // menu = menu.toUpperCase(); // convert choice to upper case

        switch (menu) {
            case "1":
                this.getStarted();
                break;
            case "2":
                this.checkInventory();
                break;
            case "3":
                this.checkMap();
                break;
            case "4":
                this.changePace();
                break; 
            case "5":
                this.changeRations();
                break;
            case "6":
                this.stopToRest();
                break;  
            case "7":
                this.attemptToTrade();
                break;  
            case "8":
                
                break;                  
            default:
                ErrorView.display(this.getClass().getName(), "*** Invalid selection *** Try again");
                break;
        }
        return false;
    }  

    private void goHunting() {
        this.console.println("***goHunting() function stub called***");
    }

    private void huntingHelp() {
        this.console.println("***huntingHelp() function stub called***");
    }

    private void checkInventory() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void getStarted() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void checkMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void changePace() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void changeRations() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void stopToRest() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void attemptToTrade() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
