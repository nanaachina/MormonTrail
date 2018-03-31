/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author adm-achina
 */
public class TakeFerryView extends View {
    public TakeFerryView() {
        
    super("\n===============Mormon Trail Game================="
            + "\n                                                 "
            + "\n              Ferry Crossing                     "
            + "\n                                                 "
            + "\n  The ferry operator says that he will charge    "
            + "\n  you $5.00 and that you will have to wait x?    "
            + "\n  days. "
            + "\n                                                 "
            + "\n=================================================",
            "\nAre you Willing to do this (Y/N)?: ");
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
        //    ErrorView.display(this.getClass().getName(), "*** Invalid selection *** Try again");
        }
    }

    @Override
    public boolean doAction(String menu) {
        menu = menu.toUpperCase(); // convert choice to upper case
        switch (menu) {
            case "Y":
                this.console.println("\n*** The ferry has successfully carried you across the river *** ");
                this.takeFerryRide();
                break;
            case "N":
                this.console.println("\n*** Try another option to cross the river *** ");
                this.takeFerryRide();
                break;               
            default:
            //    ErrorView.display(this.getClass().getName(), "*** Invalid selection *** Try again");
                break;
        }
        return false;
    }  

    private void takeFerryRide() {
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }
}
