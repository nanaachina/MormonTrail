/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.GameControl;
import Model.Location;
import Model.Scene;
import java.io.BufferedReader;
import java.io.PrintWriter;
import mormontrail.MormonTrail;

/**
 *
 * @author adm-achina
 */
public class DisplayMapView {
    
    protected final BufferedReader keyboard = MormonTrail.getInFile();
    protected final PrintWriter console = MormonTrail.getOutFile();
        
    public void displayMap() {

        // get the map for the game
        Location[][] locations = GameControl.getMapLocations();
        int noColumns = locations[0].length; // get number columns in row

        this.printTitle(noColumns, "THE MORMON TRAIL");
        this.printColumnHeaders(noColumns);

        for (int i = 0; i < locations.length; i++) {
            Location[] rowLocations = locations[i];
            this.printRowDivider(noColumns);
            this.console.println(); // move down one i
            if (i < 9) {
                this.console.print(" " + (i + 1));
            } else {
                this.console.print(i + 1);
            }

            // for every column in the row
            for (int column = 0; column < noColumns; column++) {
                this.console.print("|"); // print column divider
                Location location = rowLocations[column];
                if (/*location.isVisited() ||*/ location !=null && location.getSceneType()!=null) { // if location is visited 
                    Scene scene = location.getSceneType();
                    this.console.print(scene.getMapSymbol());
                } else {
                    this.console.print(" ?? ");
                }

                Scene scene = location.getSceneType();
                this.console.print("");//(scene.getMapSymbol());

            }
            this.console.print("|"); // print column divider
        }

        this.printRowDivider(noColumns);
    }

    private void printColumnHeaders(int noOfColumns) {
        for (int i = 1; i < noOfColumns + 1; i++) {
            if (i < 10) {
                this.console.print("   " + i + " ");
            } else {
                this.console.print("  " + i + " ");
            }
        }
    }    

    private void printRowDivider(int noColumns) {
        this.console.println();
        this.console.print("  ");
        for (int i = 0; i < noColumns; i++) { // print row divider
            this.console.print("-----");
        }
        this.console.print("-");
    }

    private void printTitle(int noOfColumns, String title) {

        int titleLength = title.length();
        int lineLength = noOfColumns * 5 + 3;
        int startPosition = (lineLength / 2) - (titleLength / 2);
        this.console.println("\n");
        for (int i = 0; i < startPosition; i++) {
            this.console.print(" ");
        }
        this.console.print(title);
        this.console.println("\n");
    }
    
    private void viewLocation() {
        ViewLocationView viewLocationView = new ViewLocationView();
        viewLocationView.display();
    }
}
