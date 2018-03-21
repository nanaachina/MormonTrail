/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author adm-achina
 */
public class Pace implements Serializable{

    String description;
    int hoursTravelPerDay;

    public Pace() {
    }

    public Pace(int hoursTravelPerDay) {
        this.hoursTravelPerDay = hoursTravelPerDay;
    }

    public Pace(String description) {
        this.description = description;
    }

    public Pace(String description, int hoursTravelPerDay) {
        this.description = description;
        this.hoursTravelPerDay = hoursTravelPerDay;
    }

    
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHoursTravelPerDay() {
        return hoursTravelPerDay;
    }

    public void setHoursTravelPerDay(int hoursTravelPerDay) {
        this.hoursTravelPerDay = hoursTravelPerDay;
    }

    @Override
    public String toString() {
        return "Pace{" + "description=" + description + ", hoursTravelPerDay=" + hoursTravelPerDay + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.description);
        hash = 23 * hash + this.hoursTravelPerDay;
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
        final Pace other = (Pace) obj;
        if (this.hoursTravelPerDay != other.hoursTravelPerDay) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }
    
    
   
}
