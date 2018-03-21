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
public class PaceHelpView extends View{

    public PaceHelpView() {
        super("\n===============Mormon Trail Game================="
                + "\n                                             "
                + "\n               Pace Information              "
                + "\n                                             "
                + "\n  STEADY - You travel about 8 hours a day,   "
                + "\n  taking frequent rests. You take care not   "
                + "\n  to get too tired.                          "
                + "\n                                             "
                + "\n  STRENUOUS - You travel about 12 hours a    "
                + "\n  day, starting just after surise and        "
                + "\n  stopping shortly before sunset. You stop   "
                + "\n  to rest only when necessary. You finish    "
                + "\n  each day feeling very tired.               "
                + "\n                                             "
                + "\n  GRUELLING - You travel about 16 hours a    "
                + "\n  day, starting before sunrise and continuing"
                + "\n  until dark. You almost never stop to rest. "
                + "\n  You do not get enough sleep at night. You  "
                + "\n  finish each day feeling absolutely         "
                + "\n  exhousted, and your health suffers.        "
                + "\n=============================================",
                "\nPress 'C' to continue: ");
    }

    @Override
    public boolean doAction(String choice) {
        this.console.println("\n*** Invalid selection *** Try again");
        return false;
    }    
}
