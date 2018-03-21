/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.BufferedReader;
import java.io.PrintWriter;
import Control.GameControl;
import Model.Player;
import mormontrail.MormonTrail;


/**
 *
 * @author adm-achina
 */
public class StartProgramView {
    
    protected final BufferedReader keyboard = MormonTrail.getInFile();
    protected final PrintWriter console = MormonTrail.getOutFile();

    private String promptMessage;

    public StartProgramView() {

        this.promptMessage = "\nPlease enter your name: ";
        // display the banner when view is created
        this.displayBanner();

    }

    private void displayBanner() {

        this.console.println(
                "\n========================================================="
                + "\n                                                       "
                + "\n    Welcome to the Game of The Mormon Trail            "
                + "\n                                                       "
                + "\n Your goal is to reach the Salt Lake Valley.           "
                + "\n While in Nauvoo, you choose the members of your       "
                + "\n party and pool your available money in order to       "
                + "\n purchase a wagon, team and supplies for your journey. "
                + "\n                                                       "
                + "\n Any available money leftover from your purchases      "
                + "\n can be taken with you in order to purchase additional "
                + "\n supplies at forts along the way. Along the way on the "
                + "\n trail you will stop at forts, landmarks and rivers,   "
                + "\n facing obstacles based on your choices and random     "
                + "\n events. You and your party will be faced with "
                + "\n challenges that will test your survival skills on     "
                + "\n the trail. You are the leader of your party and       "
                + "\n you make all of the decisions."
                + "\n                                                       "
                + "\n           Good Luck on your journey                   "
                + "\n                                                       "
                + "\n======================================================="
        );
    }

    public void display() {
        boolean done = false; // set flag to not done
        do {
            // prompt for and get players name
            String playersName = this.getPlayersName();
            if (playersName.toUpperCase().equals("Q")) // user wants to quit
            {
                return; // exit the game
            }            // do the requested action and display the next view
            done = this.doAction(playersName);

        } while (!done);
    }

    public String getPlayersName() {

        //Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        String value = null; // value to be returned
        boolean valid = false; // initialize to not valid
        try {
            while (!valid) { // loop while an invalid value is entered
                this.console.printf(this.promptMessage);/*(this.promptMessage)*/


                value = keyboard.readLine(); // get next line typed on keyboard
                value = value.trim(); // trim off leading and trailing blanks

                if (value.length() < 1) { // value is blank
                    ErrorView.display(this.getClass().getName(), "You must enter a value.");
                    continue;
                }
                break; // end the loop
            }
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), "Error reading input: " + e.getMessage());

        }

        return value; // return the value entered
    }

    private boolean doAction(String playersName) {
        try {
            if (playersName.length() < 2) {
                ErrorView.display(this.getClass().getName(), "Input must be greater than"
                        + " one character");
                return false;
            }
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), "Error reading input: " + e.getMessage());
        }
        // call createPlayer() control function
        Player player = GameControl.createPlayer(playersName);

        try {
            if (player == null) { // if unsuccessful
                ErrorView.display(this.getClass().getName(), "\nError creating player");
                return false;
            }
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), "Error reading input: " + e.getMessage());  
        }
        
        // display next view
        this.displayNextView(player);
        return true; // success!
    }
    
    private void displayNextView(Player player) {
        // display a custom welcome message
        this.console.println("\n================================================"
                + "\n                                                "
                + "\n    Welcome to the Mormon Trail " + player.getName()
                + "\n                                                "
                + "\n    We wish you God Speed!                      "
                + "\n                                                "
                + "\n================================================");

        // Create MainMenuView object
        MainMenuView mainMenuView = new MainMenuView();

        // Display the main menu view
        mainMenuView.display();
    }

}
