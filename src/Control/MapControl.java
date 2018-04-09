/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Exceptions.MapControlException;
import Model.Actor;
import Model.Game;
import Model.InventoryItem;
import Model.Location;
import Model.Map;
import Model.Question;
import Model.QuestionType;
import Model.Scene;
import Model.SceneGroup;
import Model.SceneType;
import java.awt.Point;
import java.io.Serializable;
import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mormontrail.MormonTrail;



/**
 *
 * @author adm-achina
 */
public class MapControl implements Serializable{

    public static Map createMap() {
        // create the map
        Map map = new Map(20, 20);
        
        // create a list of different scenes in the game
        Scene[] scenes = createScenes();
        
//        assign different scenes to locations in the map
        assignScenesToLocations(map, scenes);
        return map;        
    }
        
    public static Location[][] createLocations(int rows, int columns) throws Exception{


        if (rows < 1 || columns < 1) {

        }
        
        Location[][] locations = new Location[rows][columns];
        
        
        for (int rowCount = 0; rowCount < rows; rowCount++) {
            for (int colCount = 0; colCount < columns; colCount++) {
               
                Location area = new Location();
                area.setVisited(false);
                
                locations[rowCount][colCount] = area;
            }
        }
        
        
        return locations;
    }

    public static Scene[] createScenes() {
        // create scenes
        Game game = MormonTrail.getCurrentGame();
        Scene[] scenes = new Scene[SceneType.values().length];

        Scene Start = new Scene();//1
        Start.setDescription("Start - GardenGrove");
        Start.setBlocked(false);
        Start.setMapSymbol("*NV*");
        Start.setTravelTime(0);
        Start.setLocation(new Point(18, 19));
        scenes[SceneType.GardenGrove.ordinal()] = Start;
        
        Scene MountPisgah = new Scene();//2
        MountPisgah.setDescription("Mount Pisgah");
        MountPisgah.setBlocked(false);
        MountPisgah.setMapSymbol("}=={");
        MountPisgah.setTravelTime(0);
        MountPisgah.setLocation(new Point(15, 19));
        scenes[SceneType.MountPisgah.ordinal()] = MountPisgah;
        
        Scene Kanesville = new Scene();//3
        Kanesville.setDescription("Kanesville");
        Kanesville.setBlocked(false);
        Kanesville.setMapSymbol("}=={");
        Kanesville.setTravelTime(0);
        Kanesville.setLocation(new Point(8, 19));
        scenes[SceneType.Kanesville.ordinal()] = Kanesville;

        Scene WinterQuarters = new Scene();//4
        WinterQuarters.setDescription("Winter Quarters");
        WinterQuarters.setBlocked(false);
        WinterQuarters.setMapSymbol("||||");
        WinterQuarters.setTravelTime(0);
        WinterQuarters.setLocation(new Point(10, 17));
        scenes[SceneType.WinterQuarters.ordinal()] = WinterQuarters;

        Scene FortKeamy = new Scene();//5
        FortKeamy.setDescription("Fort Keamy");
        FortKeamy.setBlocked(false);
        FortKeamy.setMapSymbol("*^^*");
        FortKeamy.setTravelTime(0);
        FortKeamy.setLocation(new Point(15, 16));
        scenes[SceneType.FortKeamy.ordinal()] = FortKeamy;
        
        Scene ChimneyRock = new Scene();//6
        ChimneyRock.setDescription("Chimney Rock");
        ChimneyRock.setBlocked(false);
        ChimneyRock.setMapSymbol("||||");
        ChimneyRock.setTravelTime(0);
        ChimneyRock.setLocation(new Point(16, 13));  
        scenes[SceneType.ChimneyRock.ordinal()] = ChimneyRock;
        
        
        Scene FortLaramie = new Scene();//7
        FortLaramie.setDescription("Fort Laramie");
        FortLaramie.setBlocked(false);
        FortLaramie.setMapSymbol("*^^*");
        FortLaramie.setTravelTime(0);
        FortLaramie.setLocation(new Point(11, 13));
        scenes[SceneType.FortLaramie.ordinal()] = FortLaramie;
        
        
        Scene IndependenceRock = new Scene();//8
        IndependenceRock.setDescription("Independence Rock");
        IndependenceRock.setBlocked(false);
        IndependenceRock.setMapSymbol("^--^");
        IndependenceRock.setTravelTime(0);
        IndependenceRock.setLocation(new Point(8, 11));
        scenes[SceneType.IndependenceRock.ordinal()] = IndependenceRock;
        
        
        Scene MartinsCove = new Scene();//9
        MartinsCove.setDescription("Martin's Cove");
        MartinsCove.setBlocked(false);
        MartinsCove.setMapSymbol("||||");
        MartinsCove.setTravelTime(0);
        MartinsCove.setLocation(new Point(5, 9));
        scenes[SceneType.MartinsCove.ordinal()] = MartinsCove;
        
       
        Scene FortBridger = new Scene();//10
        FortBridger.setDescription("Fort Bridger");
        FortBridger.setBlocked(false);
        FortBridger.setMapSymbol("||||");
        FortBridger.setTravelTime(0);
        FortBridger.setLocation(new Point(9, 8));  
        scenes[SceneType.FortBridger.ordinal()] = FortBridger;
        
        
        Scene SaltLakeValley = new Scene();//11
        SaltLakeValley.setDescription("Finish - Salt Lake Valley");
        SaltLakeValley.setBlocked(false);
        SaltLakeValley.setMapSymbol("*FN*");
        SaltLakeValley.setTravelTime(0);
        SaltLakeValley.setLocation(new Point(3, 0));  
        scenes[SceneType.SaltLakeValley.ordinal()] = SaltLakeValley;
        
        
        
return scenes;

    }

    public static Question[] createQuestions(){
        Question[] questions = new Question[QuestionType.values().length];
        
        Question start = new Question();
        start.setQuestion("What month should I leave?");
        start.setAnswer("Don't leave too late or too early?");
        questions[QuestionType.start.ordinal()] = start;
        
        /**
        Question riverCross = new Question();
        riverCross.setQuestion("How much is it to cross");
        riverCross.setAnswer("It will cost $5.00");
        questions[QuestionType.riverCross.ordinal()] = riverCross;
        **/
        
        Question trade = new Question();
        trade.setQuestion("What can you give me");
        trade.setAnswer("Whatever you want");
        questions[QuestionType.trade.ordinal()] = trade;
        
        return questions;
    }
    
    public static void assignQuestionsToScenes(Question[] questions, 
                                                Scene[] scenes){
        System.out.println("\n*** assignQuestionsToScenes called ***");
    }
    
    public static void assignItemsToScenes(InventoryItem[] items,
                                            Scene[] scenes){
        System.out.println("\n*** assignItemsToScenes called ***");
    }

    public static void assignScenesToLocations(Map map, Scene[] scenes) {
        Location[][] location = map.getLocations();
    



        for(Scene scene: scenes){
            int x = scene.getLocation().x;
            int y = scene.getLocation().y;
            Location sceneLocation = location[x][y];
            sceneLocation.setSceneType(scene);
            location[x][y] = sceneLocation;
      
        }
    }    

    
        
    
    public void moveActorToLocation(Point playerCoordinates)
                            throws MapControlException{
        
        Map map = MormonTrail.getCurrentGame().getMap();
        int newRow = playerCoordinates.x-1;
        int newColumn = playerCoordinates.y-1;
        
        if (newRow < 0  || newRow >= map.getNoOfRows() ||
            newColumn < 0  || newColumn >= map.getNoOfColumns()) {
            throw new MapControlException("Cannot move player to location"
                    + playerCoordinates.x + ", " + playerCoordinates.y
                    + " because the location is outside"
                    + "the bounds of the map.");
        }
        
        
        
        // We can now move player to new location
        Location newLocation = map.getLocations()[newRow][newColumn];
        Point oldLocation = map.getPlayerCordinates();
        // mark new locations as visited on arrival  
        
        // check to see if the actor is in the current location
        if (oldLocation != null) {
//            oldLocation.removePlayer player; // remove actor from old location
        }
        
        newLocation.getPlayer(); // add actor to new location
        playerCoordinates.x = newRow;
        playerCoordinates.y = newColumn; // set actor to new location
        newLocation.setVisited(true); // mark as a visted location        
    }
  
    
    public static Location getLocation(Point coordinates) {
        System.out.println("*** getLocation() called");
        Location location = new Location();
        location.setRow(coordinates.x);
        location.setSceneType(new Scene(SceneGroup.regular, "You are in the ocean", "~~~", 0, true));
        location.setColumn(coordinates.y);
        return location;
    }
    
}