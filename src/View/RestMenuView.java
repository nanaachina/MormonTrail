/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.GameControl;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author adm-achina
 */
class RestMenuView extends View{
    public RestMenuView() {
        super("\n"
                + "\n===============Mormon Trail Game================="
                + "\n                                                 "
                + "\n        "+ GameControl.getStartDate()
                + "\n                                                 "
                + "\n Take a rest from your arduous journey. You must  "
                + "\nensure that you are in the best of health at all "
                + "\ntimes. The journey will be hard and long.        "
                + "\n                                                 "
                + "\nThe longer you are able to rest the better your  "
                + "\nhealth will be.                                  "
                + "\n                                                 "
                + "\nX - Exit                                         "
                + "\n                                                 "
                + "\n=================================================",
                "\nEnter the days you wish to rest "
                + "or press X to exit: ");

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
                int addValue = Integer.parseInt(value);
                this.console.println("\nYou have rested for " + addValue + " days.");
                done = this.doAction1(addValue);
            } while (!done);
        } catch (NumberFormatException nfe) {
            ErrorView.display(this.getClass().getName(), "*** Invalid selection *** Try again");
        }
    }


    public boolean doAction1(int date) {
        //menu = menu.toUpperCase(); // convert choice to upper case
        Date startDate = GameControl.getStartDate();
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        cal.add(Calendar.DATE, date);
        startDate = cal.getTime();
        
        this.console.println("\nThe New Date is: " + startDate);
        
        GameControl.setStartDate(startDate);
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
        
        return true;
    }

    @Override
    public boolean doAction(String value) {
        
        return false;
    }

}
