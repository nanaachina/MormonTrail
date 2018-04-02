/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.GameControl;
import Model.PaceType;

/**
 *
 * @author adm-achina
 */
public class PaceMenuView extends View {

    /**
     *
     * @author sadss
     */
    public PaceMenuView() {
        super("\n"
                + "\n===============Mormon Trail Game================="
                + "\n                                                 "
                + "\n                Set Pace Menu                    "
                + "\n                                                 "
                + "\n1 - " + PaceType.Steady.name()
                + "\n2 - " + PaceType.Strenuous.name()
                + "\n3 - " + PaceType.Gruelling.name()
                + "\n4 - Find out what these different paces mean     "
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
            ErrorView.display(this.getClass().getName(), "*** Invalid selection *** Try again");
        }
    }

    @Override
    public boolean doAction(String menu) {
        menu = menu.toUpperCase(); // convert choice to upper cas

        switch (menu) {
            case "1":
                this.steadyPace();
                break;
            case "2":
                this.strenuousPace();
                break;
            case "3":
                this.gruellingPace();
                break;
            case "4":
                this.paceHelp();
                break;
            default:
                ErrorView.display(this.getClass().getName(), "*** Invalid selection *** Try again");
                break;
        }
        new GameMenuView();
        return false;
    }

    private void steadyPace() {
        GameControl.setPace("Steady");
        this.console.println("Your pace has been set to steady");
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void strenuousPace() {
        GameControl.setPace("Strenuous");
        this.console.println("Your pace has been set to strenuous.");
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();

    }

    private void gruellingPace() {
        GameControl.setPace("Gruelling");
        this.console.println("Your pace has been set to gruelling.");
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void paceHelp() {
        PaceHelpView paceHelp = new PaceHelpView();
        paceHelp.display();
    }

}
