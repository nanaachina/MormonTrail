/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.GameControl;
import Model.RationType;

/**
 *
 * @author adm-achina
 */
class RationMenuView extends View {
        public RationMenuView() {
        super("\n"
                + "\n===============Mormon Trail Game================="
                + "\n                                                 "
                + "\n                Ration Menu                        "
                + "\n                                                 "
                + "\n1 - "+ RationType.Filling.name()+"    - meals are large and generous    "
                + "\n2 - "+ RationType.Meagre.name()+"     - meals are small, but adequate   "
                + "\n3 - "+ RationType.BareBones.name()+"  - meals are very small; everyone  "
                + "\n    stays hungry                                "
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
     //       ErrorView.display(this.getClass().getName(), "*** Invalid selection *** Try again");
        }
    }

    @Override
    public boolean doAction(String menu) {
        menu = menu.toUpperCase(); // convert choice to upper cas

        switch (menu) {
            case "1":
                this.fillingRation();
                break;
            case "2":
                this.meagreRation();
                break;
            case "3":
                this.bareBonesRation();
                break;      
            default:
        //        ErrorView.display(this.getClass().getName(), "*** Invalid selection *** Try again");
                break;
        }
        return false;
        
    }  

    private void fillingRation() {
        GameControl.setRation("Filling");
        this.console.println("*** Rations are set to filling ***");
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void meagreRation() {
        GameControl.setRation("Meagre");
        this.console.println("*** Rations are set to Meagre ***");
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }
    
    private void bareBonesRation() {
        GameControl.setRation("Bare bones");
        this.console.println("*** Rations are set to Bare bones ***");
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }


}
