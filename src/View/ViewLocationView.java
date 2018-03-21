/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.MapControl;
import Model.Actor;
import Model.Location;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author adm-achina
 */
public class ViewLocationView extends View {

    public ViewLocationView() {
    }

    @Override
    public String getInput() {
        String[] inputs = new String[1];

        System.out.println(
            "\n"
            + "Enter the row and column number of the location "
            + "you want to view (e.g., 1 3).");

        return null;
    }

//    @Override
    public boolean doAction(String[] inputs) {

        Point coordinates = this.getCoordinates(inputs[0]); // get the row and column
        if (coordinates == null) {
            return false;
        }

        // get the location in the map
        Location location = MapControl.getLocation(coordinates);

        // display contents of location
        this.displayLocationInfo(coordinates, location);

        return true;

    }

    public Point getCoordinates(String value) {

        value = value.trim().toUpperCase();
        if (value.equals("Q")) {
            return null;
        }

        //tokenize values int string
        String[] values = value.split(", ");

        if (values.length < 2) {
            System.out.println("You must enter both a row and column number.");
            return null;
        }

        // parse out row and column numbers
        int row = Integer.parseInt(values[0]);
        int column = Integer.parseInt(values[1]);
        return new Point(row, column);

    }

    private void displayLocationInfo(Point coordinates, Location location) {
        System.out.println("\n"
                + "Location (" + coordinates.x + ", " + coordinates.y + ")"
                + "\n\t" + location.getSceneType().getDescription());
        System.out.println("\n\tActors in location");
        ArrayList<Actor> actorsInLocation = location.getActors();
        for (Actor actor : actorsInLocation) {
            System.out.println("\t" + actor);
        }

    }

    @Override
    public boolean doAction(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}