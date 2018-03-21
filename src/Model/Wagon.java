/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author adm-achina
 */
public class Wagon implements Serializable {
    
    private double maxWeight;
    private double loadedWeight;

    public Wagon() {
        
        this.maxWeight = 5000;
        this.loadedWeight = 0;
    } 

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public double getLoadedWeight() {
        return loadedWeight;
    }

    public void setLoadedWeight(double loadedWeight) {
        this.loadedWeight = loadedWeight;
    }

    @Override
    public String toString() {
        return "Wagon{" + "maxWeight=" + maxWeight + ", loadedWeight=" + loadedWeight + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.maxWeight) ^ (Double.doubleToLongBits(this.maxWeight) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.loadedWeight) ^ (Double.doubleToLongBits(this.loadedWeight) >>> 32));
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
        final Wagon other = (Wagon) obj;
        if (Double.doubleToLongBits(this.maxWeight) != Double.doubleToLongBits(other.maxWeight)) {
            return false;
        }
        if (Double.doubleToLongBits(this.loadedWeight) != Double.doubleToLongBits(other.loadedWeight)) {
            return false;
        }
        return true;
    }
    
    
}
