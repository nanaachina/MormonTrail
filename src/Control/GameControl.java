/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Exceptions.GameControlException;
import Model.Actor;
import Model.Game;
import Model.InventoryItem;
import Model.ItemType;
import Model.Location;
import Model.Map;
import Model.Occupation;
import Model.OccupationType;
import Model.Pace;
import Model.PaceType;
import Model.Player;
import Model.Ration;
import Model.RationType;
import Model.Weather;
import Model.WeatherType;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mormontrail.MormonTrail;

/**
 *
 * @author adm-achina
 */
public class GameControl implements Serializable{

    private static List<Actor> actors = new ArrayList<>();
    private static double fundAmount = 0;
    private static Date startDate;
    private static double initFunds = 0;
    private static double totalBill = 0;
    private static String occupation = null;
    private static String weather = null;
    private static String pace = null;
    private static String ration = null;
    private static String health = null;

    public static Player createPlayer(String name) {

        if (name == null) {
            return null;
        }
        Player player = new Player();
        player.setName(name);

        MormonTrail.setPlayer(player); // save the player

        return player;
    }
    
    public static double getInitFunds() {
        return initFunds;
    }

    public static void setInitFunds(double initFunds) {
        GameControl.initFunds = initFunds;
    }

    public static double getTotalBill() {
        return totalBill;
    }

    public static void setTotalBill(double totalBill) {
        GameControl.totalBill = totalBill;
    }

    public static String getOccupation() {
        return occupation;
    }

    public static void setOccupation(String occupation) {
        GameControl.occupation = occupation;
    }

    public static String getWeather() {
        return weather;
    }

    public static void setWeather(String weather) {
        GameControl.weather = weather;
    }

    public static String getPace() {
        return pace;
    }

    public static void setPace(String pace) {
        GameControl.pace = pace;
    }

    public static String getRation() {
        return ration;
    }

    public static void setRation(String ration) {
        GameControl.ration = ration;
    }

    public static String getHealth() {
        return health;
    }

    public static void setHealth(String health) {
        GameControl.health = health;
    }

        
    /**
     * Add array for wagon party
     */
    public static int createActor(Actor actor) {
        //Check if the actor is valid        
        if (isActorValid(actor)) {
            //add actor to actors list
            actors.add(actor);
            return +1;
        }
        //if actor is not valid then display to user 
        //an invalid actor message and return to getPartyList()    
        System.out.println("\n*** Invalid actor " + actor.toString() + "***");
        return -1;
    }
    
    public static List<Actor> getActors() {
        return actors;
    }

    public static void setActors(List<Actor> actors) {
        GameControl.actors = actors;
    }

    private static boolean isActorValid(Actor actor) {
        if (actor == null) {
            return false;
        }
        if (actor.getName() == null) {
            return false;
        }
        return true;
    }

    public static double getFundAmount() {
        return fundAmount;
    }

    public static void setFundAmount(double fundAmount) {
        GameControl.fundAmount = fundAmount;
    }

    public static Date getStartDate() {
        return startDate;
    }

    public static void setStartDate(Date startDate) {
        GameControl.startDate = startDate;
    }



    public static void createNewGame(Player player) {
        Game game = new Game(); // create new game
        MormonTrail.setCurrentGame(game); // save in MormonTrail

        game.setPlayer(player); // save player in game

        //System.out.println("\n*** new game started ***");
        // create the inventory list and save in the game
        InventoryItem[] inventoryList = GameControl.createItems();
        game.setInventory(inventoryList);

        //System.out.println("\n*** inventory list created ***");
        Map map = MapControl.createMap(); // create and initialize new map
        game.setMap(map); // save map in game
        
        List<Actor> actor = GameControl.getActors();
        game.setActors(actors);
        
        game.setStartDate(null);
        
        

        //System.out.println("\n*** map created ***");
    }

    public static InventoryItem[] createItems() {
        // create array(list) of InventoryItem items

        InventoryItem[] inventory = new InventoryItem[7];

        InventoryItem oxen = new InventoryItem();
        oxen.setDescription(ItemType.Oxen.name());
        oxen.setQuantityInStock(0);
        oxen.setRequiredAmount(0);
        oxen.setCost(40.00);
        inventory[ItemType.Oxen.ordinal()] = oxen;

        InventoryItem food = new InventoryItem();
        food.setDescription(ItemType.Food.name());
        food.setQuantityInStock(0);
        food.setRequiredAmount(0);
        food.setCost(00.20);
        inventory[ItemType.Food.ordinal()] = food;

        InventoryItem clothing = new InventoryItem();
        clothing.setDescription(ItemType.Clothing.name());
        clothing.setQuantityInStock(0);
        clothing.setRequiredAmount(0);
        clothing.setCost(10.00);
        inventory[ItemType.Clothing.ordinal()] = clothing;

        InventoryItem ammunition = new InventoryItem();
        ammunition.setDescription(ItemType.Ammunition.name());
        ammunition.setQuantityInStock(0);
        ammunition.setRequiredAmount(0);
        ammunition.setCost(2.00);
        inventory[ItemType.Ammunition.ordinal()] = ammunition;

        InventoryItem wheel = new InventoryItem();
        wheel.setDescription(ItemType.Wheel.name());
        wheel.setQuantityInStock(0);
        wheel.setRequiredAmount(0);
        wheel.setCost(10.00);
        inventory[ItemType.Wheel.ordinal()] = wheel;

        InventoryItem axle = new InventoryItem();
        axle.setDescription(ItemType.Axle.name());
        axle.setQuantityInStock(0);
        axle.setRequiredAmount(0);
        axle.setCost(10.00);
        inventory[ItemType.Axle.ordinal()] = axle;

        InventoryItem tongue = new InventoryItem();
        tongue.setDescription(ItemType.Tongue.name());
        tongue.setQuantityInStock(0);
        tongue.setRequiredAmount(0);
        tongue.setCost(10.00);
        inventory[ItemType.Tongue.ordinal()] = tongue;

        return inventory;
    }

    public static Occupation[] createOccupation() {
        // create array list of OccupationType types
        Occupation[] occupation = new Occupation[3];

        Occupation banker = new Occupation();
        banker.setDescription("Banker");
        banker.setFundAmount(1600);
        occupation[OccupationType.Banker.ordinal()] = banker;

        Occupation carpenter = new Occupation();
        carpenter.setDescription("Carpenter");
        carpenter.setFundAmount(800);
        occupation[OccupationType.Carpenter.ordinal()] = carpenter;

        Occupation farmer = new Occupation();
        farmer.setDescription("Farmer");
        farmer.setFundAmount(400);
        occupation[OccupationType.Farmer.ordinal()] = farmer;

        return occupation;
    }
    
    public static Ration[] createRation(){
        // create array list of Ration types
        Ration[] rationSize = new Ration[3];
        
        Ration Filling = new Ration();
        Filling.setDescription("Filling");
        Filling.setSize(3);
        rationSize[RationType.Filling.ordinal()] = Filling;
        
        
        Ration Meagre = new Ration();
        Meagre.setDescription("Meagre");
        Meagre.setSize(2);
        rationSize[RationType.Meagre.ordinal()] = Meagre;
        
        Ration BareBones = new Ration();
        BareBones.setDescription("Meagre");
        BareBones.setSize(2);
        rationSize[RationType.BareBones.ordinal()] = BareBones;
        
        return rationSize;
        
    }
            
        public static Pace[] createPace(){
        // create array list of Ration types
        Pace[] pace = new Pace[3];
        
        Pace Steady = new Pace();
        Steady.setDescription("Steady");
        Steady.setHoursTravelPerDay(8);
        pace[PaceType.Steady.ordinal()] = Steady;
        
        Pace Strenuous = new Pace();
        Strenuous.setDescription("Strenuous");
        Strenuous.setHoursTravelPerDay(12);
        pace[PaceType.Strenuous.ordinal()] = Strenuous;
        
        Pace Gruelling = new Pace();
        Gruelling.setDescription("Gruelling");
        Gruelling.setHoursTravelPerDay(16);
        pace[PaceType.Gruelling.ordinal()] = Gruelling;
        
        return pace;
        
        }
        
        
        public static Weather[] createWeather(){
        // create array list of Ration types
        Weather[] weather = new Weather[6];
        
        Weather Hot = new Weather();
        Hot.setDescription("Hot");
        weather[WeatherType.Hot.ordinal()] = Hot;
        
        Weather Warm = new Weather();
        Warm.setDescription("Warm");
        weather[WeatherType.Warm.ordinal()] = Warm;
        
        Weather Fair = new Weather();
        Fair.setDescription("Fair");
        weather[WeatherType.Fair.ordinal()] = Fair;
        
        Weather Cool = new Weather();
        Cool.setDescription("Cool");
        weather[WeatherType.Cool.ordinal()] = Cool;
        
        Weather Cold = new Weather();
        Cold.setDescription("Cold");
        weather[WeatherType.Cold.ordinal()] = Cold;
        
        Weather Freezing = new Weather();
        Freezing.setDescription("Freezing");
        weather[WeatherType.Freezing.ordinal()] = Freezing;
        
        return weather;
        }
        
    public static Location[][] getMapLocations() {
        return MormonTrail.getCurrentGame().getMap().getLocations();
    }
    //function to sort Inventory by description

    public static InventoryItem[] getSortedInventoryListDescription() {

        // get inventory list for the current game
        InventoryItem[] originalInventoryList
                = MormonTrail.getCurrentGame().getInventory();

        // make a copy of orignalList
        InventoryItem[] inventoryList = originalInventoryList.clone();

        // using a BubbleSort to sort the list of inventoryList by description
        InventoryItem tempInventoryItem;
        for (int i = 0; i < inventoryList.length - 1; i++) {
            for (int j = 0; j < inventoryList.length - 1 - i; j++) {
                if (inventoryList[j].getDescription().
                        compareToIgnoreCase(inventoryList[j + 1].getDescription()) > 0) {
                    tempInventoryItem = inventoryList[j];
                    inventoryList[j] = inventoryList[j + 1];
                    inventoryList[j + 1] = tempInventoryItem;
                }
            }
        }
        return inventoryList;
    }   // function to sort by Inventory item cost
    

    public static InventoryItem[] getSortedInventoryListCost() {

        // get inventory list for the current game
        InventoryItem[] originalInventoryList
                = MormonTrail.getCurrentGame().getInventory();

        // make a copy of orignalList
        InventoryItem[] inventoryList = originalInventoryList.clone();

        // using a BubbleSort to sort the list of inventoryList by cost
        InventoryItem tempInventoryItem;
        for (int i = 0; i < inventoryList.length - 1; i++) {
            for (int j = 0; j < inventoryList.length - 1 - i; j++) {
                if (inventoryList[j + 1].getCost() < inventoryList[j].getCost()) {
                    tempInventoryItem = inventoryList[j];
                    inventoryList[j] = inventoryList[j + 1];
                    inventoryList[j + 1] = tempInventoryItem;
                }
            }
        }
        return inventoryList;
    }
    //function to sort inventory by quantity in stock 
    
    public static InventoryItem[] getSortedInventoryListInStock() {

        // get inventory list for the current game
        InventoryItem[] originalInventoryList
                = MormonTrail.getCurrentGame().getInventory();

        // make a copy of orignalList
        InventoryItem[] inventoryList = originalInventoryList.clone();

        // using a BubbleSort to sort the list of inventoryList by cost
        InventoryItem tempInventoryItem;
        for (int i = 0; i < inventoryList.length - 1; i++) {
            for (int j = 0; j < inventoryList.length - 1 - i; j++) {
                if (inventoryList[j + 1].getQuantityInStock() < inventoryList[j].getQuantityInStock()) {
                    tempInventoryItem = inventoryList[j];
                    inventoryList[j] = inventoryList[j + 1];
                    inventoryList[j + 1] = tempInventoryItem;
                }
            }
        }
        return inventoryList;
    }
    
    public static void saveGame(Game game, String filePath)
            throws GameControlException {
        try( FileOutputStream fops = new FileOutputStream(filePath)){
            ObjectOutputStream output = new ObjectOutputStream(fops);
            
            output.writeObject(game);// write the game object out to file
        } catch (Exception e) {
            throw new GameControlException(e.getMessage());
        }
    }
    
    public static void getSavedGame(String filePath)
            throws GameControlException {
        Game game = null;
        
    try (FileInputStream fips = new FileInputStream(filePath)) {
        ObjectInputStream input = new ObjectInputStream(fips);
        
        game = (Game) input.readObject(); // read the game object from file
    }
    catch(Exception e) {
            throw new GameControlException(e.getMessage());
    }
    
    // close the output file
    MormonTrail.setCurrentGame(game);
    }
}
