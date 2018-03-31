/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.BufferedReader;
import java.io.PrintWriter;
import mormontrail.MormonTrail;

/**
 *
 * @author adm-achina
 */
public abstract class View implements ViewInterface {

    protected String displayMessage;
    protected String displayPrompt;

    protected final BufferedReader keyboard = MormonTrail.getInFile();
    protected final PrintWriter console = MormonTrail.getOutFile();
    
    public View() {
    }

    //using principle of overloading
    public View(String message, String prompt) {
        this.displayMessage = message;
        this.displayPrompt = prompt;

    }

    @Override
    public void display() {

        boolean done = false; // set flag to not done
        do {
            // prompt for and get menu option
            String value = this.getInput();

            if (value.toUpperCase().equals("C"))// user wants to exit view                
            // do the requested action and display the next view
            {
                return; // exit view
            }
            done = this.doAction(value);
        } while (!done);
    }

    @Override
    public String getInput() {

        //Scanner keyboard = new Scanner(System.in);
        boolean valid = false; // initialize to not valid
        String value = null;
        try {
            // while a valid name has not been retrieved
            while (!valid) {

                // prompt for input
                this.console.printf(this.displayMessage);
                this.console.printf(this.displayPrompt);

                // get the value entered from keyboard
                value = keyboard.readLine();

                // trim off leading and trailing blanks
                value = value.trim();

                if (value.length() < 1) { // value is blank
          //          ErrorView.display(this.getClass().getName(), "You must enter a value.");
                    continue;
                }
                break; // end the loop
            }

        } catch (Exception ex) {
     //       ErrorView.display(this.getClass().getName(),"Error reading input: "+ ex.getMessage());
        }

        return value; // return the value entered
    }
}
