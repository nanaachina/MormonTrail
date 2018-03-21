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
public class Occupation implements Serializable{

    public Occupation() {
        
    }
    // class instance variables
    private String description;
    private int fundAmount;

    // relationship instance variables
    private Player player;
    private Game game;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFundAmount() {
        return fundAmount;
    }

    public void setFundAmount(int fundAmount) {
        this.fundAmount = fundAmount;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public String toString() {
        return "OccupationType{" + "description=" + description + ", fundAmount=" + fundAmount + ", player=" + player + ", game=" + game + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.description);
        hash = 37 * hash + this.fundAmount;
        hash = 37 * hash + Objects.hashCode(this.player);
        hash = 37 * hash + Objects.hashCode(this.game);
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
        final Occupation other = (Occupation) obj;
        if (this.fundAmount != other.fundAmount) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.player, other.player)) {
            return false;
        }
        if (!Objects.equals(this.game, other.game)) {
            return false;
        }
        return true;
    }  
    
}
