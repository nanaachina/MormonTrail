/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author adm-achina
 */
public class Actor implements Serializable {


    // class instance variables
    private String name;
    private int health = 100;
    private Point coordinates;
    
    // relationship instances
    private Game game;
    private ArrayList<RandomEvent> events = new ArrayList<RandomEvent>();
    
    // constructor function
    public Actor() {
    }

    // getter and setter functions
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public ArrayList<RandomEvent> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<RandomEvent> events) {
        this.events = events;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
    this.health = health;
    }

    public Point getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Point coordinates) {
        this.coordinates = coordinates;
    }
    
    

    // toString function

    @Override
    public String toString() {
        return "Actor{" + "name=" + name + ", health=" + health + ", game=" + game + ", events=" + events + '}';
    }

    // equals nad Hash function

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + this.health;
        hash = 97 * hash + Objects.hashCode(this.coordinates);
        hash = 97 * hash + Objects.hashCode(this.game);
        hash = 97 * hash + Objects.hashCode(this.events);
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
        final Actor other = (Actor) obj;
        if (this.health != other.health) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.coordinates, other.coordinates)) {
            return false;
        }
        if (!Objects.equals(this.game, other.game)) {
            return false;
        }
        if (!Objects.equals(this.events, other.events)) {
            return false;
        }
        return true;
    }

    


}
