/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.PrintWriter;
import mormontrail.MormonTrail;

/**
 *
 * @author adm-achina
 */
public class ErrorView {

    private static final PrintWriter errorFile = MormonTrail.getOutFile();
    private static final PrintWriter logFile = MormonTrail.getLogFile();
    
    public static void display(String className, String errorMessage){
        
        errorFile.println(
                "-----------------------------------------------------"
              + "\n- Error - " + errorMessage
              + "\n----------------------------------------------------");
        
        // log error
        logFile.println(className + " - " + errorMessage);
    }
}
