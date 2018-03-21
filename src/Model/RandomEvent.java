/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author adm-achina
 */
public class RandomEvent implements Serializable {

    //Class instance variables
    private String eventType;
    private int eventLevel;

    //relationship instance variables
    private ArrayList<Actor> actors = new ArrayList<Actor>();

    public RandomEvent() {
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public int getEventLevel() {
        return eventLevel;
    }

    public void setEventLevel(int eventLevel) {
        this.eventLevel = eventLevel;
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public void setActors(ArrayList<Actor> actors) {
        this.actors = actors;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.eventType);
        hash = 41 * hash + this.eventLevel;
        return hash;
    }

    @Override
    public String toString() {
        return "RandomEvent{" + "eventType=" + eventType + ", eventLevel=" + eventLevel + '}';
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
        final RandomEvent other = (RandomEvent) obj;
        if (this.eventLevel != other.eventLevel) {
            return false;
        }
        if (!Objects.equals(this.eventType, other.eventType)) {
            return false;
        }
        return true;
    }

}
