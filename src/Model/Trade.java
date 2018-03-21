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
public class Trade implements Serializable {

    //class instance variables
    private String tradeItem;
    private double tradeItemAmount;

    //relationship instance variables
    private Player player;

    public Trade() {
    }

    public String getTradeItem() {
        return tradeItem;
    }

    public void setTradeItem(String tradeItem) {
        this.tradeItem = tradeItem;
    }

    public double getTradeItemAmount() {
        return tradeItemAmount;
    }

    public void setTradeItemAmount(double tradeItemAmount) {
        this.tradeItemAmount = tradeItemAmount;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.tradeItem);
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.tradeItemAmount) ^ (Double.doubleToLongBits(this.tradeItemAmount) >>> 32));
        return hash;
    }

    @Override
    public String toString() {
        return "Trade{" + "tradeItem=" + tradeItem + ", tradeItemAmount=" + tradeItemAmount + '}';
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
        final Trade other = (Trade) obj;
        if (Double.doubleToLongBits(this.tradeItemAmount) != Double.doubleToLongBits(other.tradeItemAmount)) {
            return false;
        }
        if (!Objects.equals(this.tradeItem, other.tradeItem)) {
            return false;
        }
        return true;
    }

}
