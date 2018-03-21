/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Point;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author adm-achina
 */
public class Scene implements Serializable {

    private SceneGroup sceneGroup;
    private String description;
    private String mapSymbol;
    private double travelTime;
    private boolean blocked;
    private Point location;

    public Scene() {
        
    }

    public Scene(SceneGroup sceneGroup, String description, String mapSymbol, double travelTime, boolean blocked) {
        this.sceneGroup = sceneGroup;
        this.description = description;
        this.mapSymbol = mapSymbol;
        this.travelTime = travelTime;
        this.blocked = blocked;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public SceneGroup getSceneGroup() {
        return sceneGroup;
    }

    public void setSceneGroup(SceneGroup sceneGroup) {
        this.sceneGroup = sceneGroup;
    }


    
    
    public Scene(SceneGroup sceneGroup, String you_are_in_the_ocean, String string, int i, boolean b) {
    
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMapSymbol() {
        return mapSymbol;
    }

    public void setMapSymbol(String mapSymbol) {
        this.mapSymbol = mapSymbol;
    }

    public double getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(double travelTime) {
        this.travelTime = travelTime;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    @Override
    public String toString() {
        return "Scene{" + "sceneGroup=" + sceneGroup + ", description=" + description + ", mapSymbol=" + mapSymbol + ", travelTime=" + travelTime + ", blocked=" + blocked + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.sceneGroup);
        hash = 61 * hash + Objects.hashCode(this.description);
        hash = 61 * hash + Objects.hashCode(this.mapSymbol);
        hash = 61 * hash + (int) (Double.doubleToLongBits(this.travelTime) ^ (Double.doubleToLongBits(this.travelTime) >>> 32));
        hash = 61 * hash + (this.blocked ? 1 : 0);
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
        final Scene other = (Scene) obj;
        if (Double.doubleToLongBits(this.travelTime) != Double.doubleToLongBits(other.travelTime)) {
            return false;
        }
        if (this.blocked != other.blocked) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.mapSymbol, other.mapSymbol)) {
            return false;
        }
        if (this.sceneGroup != other.sceneGroup) {
            return false;
        }
        return true;
    }

}
