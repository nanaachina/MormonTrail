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
public class OccupationHelpInfoView extends View {

    public OccupationHelpInfoView() {
        super("\n===============Mormon Trail Game================="
                + "\n                                                 "
                + "\n             Occupation Information              "
                + "\n                                                 "
                + "\n  Travelling to Salt Lake Valley isn't easy! but "
                + "\n  if you're a banker, you'll have more money for "
                + "\n  supplies and services than a carpenter or a    "
                + "\n  farmer.                                        "
                + "\n                                                 "
                + "\n  However, the harder you have to try, the more  "
                + "\n  points you deserve! Therefore, the farmer      "
                + "\n  earns the greatest number of points and the    "
                + "\n  banker earns the least.                        "
                + "\n                                                 "
                + "\n                                                 "
                + "\n=================================================",
                "\nPress 'C' to continue: ");
    }

    @Override
    public boolean doAction(String choice) {
      //  ErrorView.display(this.getClass().getName(), "*** Invalid selection *** Try again");
        return false;
    }
}
