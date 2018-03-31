/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.GameControl;

/**
 *
 * @author adm-achina
 */
public class OccupationMenuView extends View { //

    public OccupationMenuView() {

        super("\n"
                + "\n===============Mormon Trail Game================="
                + "\n                                                 "
                + "\n  Many kinds of people made the trip to Salt Lake   "
                + "\n                                                 "
                + "\n  You may:                                       "
                + "\n                                                 "
                + "\n  1 - Be a Banker                                "
                + "\n  2 - Be a Carpenter                             "
                + "\n  3 - Be a Farmer                                "
                + "\n  4 - Find out the differences between these     "
                + "\n      choices                                    "
                + "\n  X - Exit                                       "
                + "\n                                                 "
                + "\n=================================================",
                "\nPlease enter your choice: ");
    }

    @Override
    public void display() {

        boolean done = false; // set flag to not done
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
    }

    @Override
    public boolean doAction(String choice) {

        choice = choice.toUpperCase(); // convert choice to upper cas
        try {
            switch (choice) {
                case "1":
                    //choose a banker
                    this.banker();
                    break;
                case "2":
                    //choose a carpenter
                    this.carpenter();
                    break;
                case "3":
                    //choose a farmer
                    this.farmer();
                    break;
                case "4": //display information abouteach occupation
                    this.occupationHelpInfo();
                    break;
                default:
                //    ErrorView.display(this.getClass().getName(), "*** Invalid selection *** Try again");
                    OccupationMenuView occupation = new OccupationMenuView();
                    occupation.display();
                    break;
            }
        } catch (Exception e) {
       //     ErrorView.display(this.getClass().getName(), "*** Invalid selection *** Try again");

        }
        return false;
    }

    private void banker() throws Exception {
        GameControl.setFundAmount(1600);
        GameControl.setOccupation("Banker");
        this.console.println();
        this.console.println("Funds: "+ GameControl.getFundAmount()+ " Occupation: " + GameControl.getOccupation());
        WagonPartyView partyMember = new WagonPartyView();
        partyMember.displayPartyList();
    }

    private void carpenter() throws Exception {
        GameControl.setFundAmount(800);
        GameControl.setOccupation("Carpenter");
        WagonPartyView partyMember = new WagonPartyView();
        partyMember.displayPartyList();
    }

    private void farmer() throws Exception {
        GameControl.setFundAmount(400);
        GameControl.setOccupation("Farmer");
        WagonPartyView partyMember = new WagonPartyView();
        partyMember.displayPartyList();
    }

    private void occupationHelpInfo() {
        OccupationHelpInfoView helpInfo = new OccupationHelpInfoView();
        helpInfo.display();
    }
}
