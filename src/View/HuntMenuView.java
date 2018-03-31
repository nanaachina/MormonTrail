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
public class HuntMenuView extends View {

    public HuntMenuView() {
        super("\n"
                + "\n===============Mormon Trail Game================="
                + "\n                                                 "
                + "\n                Hunt Menu                        "
                + "\n                                                 "
                + "\n1 - A hunting we will go!                        "
                + "\n2 - Hunt help information                        "
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
        //    ErrorView.display(this.getClass().getName(), "*** Invalid selection *** Try again");
        }
    }

    @Override
    public boolean doAction(String menu) {
        //menu = menu.toUpperCase(); // convert choice to upper case

        switch (menu) {
            case "1":
                this.goHunting();
                break;
            case "2":
                this.huntingHelp();
                break;
            case "3":
                
                break;
            case "4":
                
                break; 
            case "5":
                
                break;        
            default:
            //    ErrorView.display(this.getClass().getName(), "*** Invalid selection *** Try again");
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
    
}
