/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormontrail;

import View.StartProgramView;
import Model.Player;
import Model.Game;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author adm-achina
 */
public class MormonTrail {

    private static Game currentGame = null;
    private static Player player = null;
    
    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;
    
    private static PrintWriter logFile = null;
    
    public static void main(String[] args) {

        
        try {
            
            //open character stream files for end user input and output
            MormonTrail.inFile =
                    new BufferedReader(new InputStreamReader(System.in));
            
            MormonTrail.outFile = new PrintWriter(System.out, true);
            
            // open log file
            String filePath = "log.txt";
            MormonTrail.logFile = new PrintWriter(filePath);
            
            // create StartProgramView and start program
            StartProgramView startProgramView = new StartProgramView();
            startProgramView.display();

        
        } catch (FileNotFoundException te) {
            System.out.println("Exception: " + te.toString()+
                                "\nCause: " + te.getCause() +
                                "\nMessage: "+ te.getMessage());
            te.printStackTrace();
        }
        
        finally {
            try {
                if (MormonTrail.inFile !=null) 
                    MormonTrail.inFile.close();
                
                if(MormonTrail.outFile !=null)
                   MormonTrail.outFile.close();
                
                if(MormonTrail.logFile !=null)
                   MormonTrail.logFile.close();
                    
                
            } catch (IOException ex) {
                System.out.println("Error closing files");
                return;
            }
        }
    }
    

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        MormonTrail.currentGame = currentGame;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        MormonTrail.player = player;
    }

    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        MormonTrail.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        MormonTrail.inFile = inFile;
    }

    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        MormonTrail.logFile = logFile;
    }
    public Point getCoordinates;

}

