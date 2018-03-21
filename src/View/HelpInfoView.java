package View;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adm-achina
 */
public class HelpInfoView extends View {

    public HelpInfoView() {
        super("\n===================Mormon Trail Game================="
                + "\n                                                 "
                + "\n           Helpful Trail Information             "
                + "\n                                                 "
                + "\n                                                 "
                + "\n                                                 "
                + "\n                                                 "
                + "\n=================================================",
                "\nPress 'C' to continue: ");
    }

    @Override
    public boolean doAction(String choice) {
        this.console.println("\n*** Invalid selection *** Try again");
        return false;
    }

}
