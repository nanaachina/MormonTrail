/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author adm-achina
 */
public class Game implements Serializable {

    // class instance variables
    private int noPeople;
    private double totalTime;
    private String climate;
    private InventoryItem[] inventory;
    private Occupation[] occupation;
    private Map map; 
    private Player player;
    private List<Actor> actors = new ArrayList<Actor>(); // 1..* relationship
    private Date startDate;
    private Wagon wagon;
    private Weather weather;
    private Pace pace;
    private Ration ration;
    public Point playerCoordinates;
    
    // constructor
    public Game() {
    }
    
    // getter and setter functions

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }


    public int getNoPeople() {
        return noPeople;
    }

    public void setNoPeople(int noPeople) {
        this.noPeople = noPeople;
    }

    public double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }
    
    public InventoryItem[] getInventory() {
        return inventory;
    }

    public void setInventory(InventoryItem[] inventory) {
        this.inventory = inventory;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Occupation[] getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation[] occupation) {
        this.occupation = occupation;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
    
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Wagon getWagon() {
        return wagon;
    }

    public void setWagon(Wagon wagon) {
        this.wagon = wagon;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public Pace getPace() {
        return pace;
    }

    public void setPace(Pace pace) {
        this.pace = pace;
    }

    public Ration getRation() {
        return ration;
    }

    public void setRation(Ration ration) {
        this.ration = ration;
    }

    public Point getPlayerCoordinates() {
        return playerCoordinates;
    }

    public void setPlayerCoordinates(Point playerCoordinates) {
        this.playerCoordinates = playerCoordinates;
    }

    @Override
    public String toString() {
        return "Game{" + "noPeople=" + noPeople + ", totalTime=" + totalTime + ", climate=" + climate + ", inventory=" + inventory + ", occupation=" + occupation + ", map=" + map + ", player=" + player + ", actors=" + actors + ", startDate=" + startDate + ", wagon=" + wagon + ", weather=" + weather + ", pace=" + pace + ", ration=" + ration + ", playerCoordinates=" + playerCoordinates + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.noPeople;
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.totalTime) ^ (Double.doubleToLongBits(this.totalTime) >>> 32));
        hash = 47 * hash + Objects.hashCode(this.climate);
        hash = 47 * hash + Arrays.deepHashCode(this.inventory);
        hash = 47 * hash + Arrays.deepHashCode(this.occupation);
        hash = 47 * hash + Objects.hashCode(this.map);
        hash = 47 * hash + Objects.hashCode(this.player);
        hash = 47 * hash + Objects.hashCode(this.actors);
        hash = 47 * hash + Objects.hashCode(this.startDate);
        hash = 47 * hash + Objects.hashCode(this.wagon);
        hash = 47 * hash + Objects.hashCode(this.weather);
        hash = 47 * hash + Objects.hashCode(this.pace);
        hash = 47 * hash + Objects.hashCode(this.ration);
        hash = 47 * hash + Objects.hashCode(this.playerCoordinates);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Game other = (Game) obj;
        if (this.noPeople != other.noPeople) {
            return false;
        }
        if (Double.doubleToLongBits(this.totalTime) != Double.doubleToLongBits(other.totalTime)) {
            return false;
        }
        if (!Objects.equals(this.climate, other.climate)) {
            return false;
        }
        if (!Arrays.deepEquals(this.inventory, other.inventory)) {
            return false;
        }
        if (!Arrays.deepEquals(this.occupation, other.occupation)) {
            return false;
        }
        if (!Objects.equals(this.map, other.map)) {
            return false;
        }
        if (!Objects.equals(this.player, other.player)) {
            return false;
        }
        if (!Objects.equals(this.actors, other.actors)) {
            return false;
        }
        if (!Objects.equals(this.startDate, other.startDate)) {
            return false;
        }
        if (!Objects.equals(this.wagon, other.wagon)) {
            return false;
        }
        if (!Objects.equals(this.weather, other.weather)) {
            return false;
        }
        if (!Objects.equals(this.pace, other.pace)) {
            return false;
        }
        if (!Objects.equals(this.ration, other.ration)) {
            return false;
        }
        if (!Objects.equals(this.playerCoordinates, other.playerCoordinates)) {
            return false;
        }
        return true;
    }

    
    
    
}
