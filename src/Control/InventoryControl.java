/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Exceptions.InventoryControlException;
import java.io.Serializable;

/**
 *
 * @author adm-achina
 */
public class InventoryControl implements Serializable{
    
        

    public static void checkInventoryLimits(int oxenQuantity, int clothQuantity,
            int ammoQuantity, int foodQuantity, int axleQuantity, int wheelQuantity,
            int tongueQuantity)
            throws InventoryControlException {

        if ( oxenQuantity > 8 || oxenQuantity < 0) {
            throw new InventoryControlException("Oxen out of range: "
                    + "Cannot be negative and cannot be more than 8");
        }
        
        if (clothQuantity  < 0) {
            throw new InventoryControlException("Clothiing out of range: "
                    + "Cannot be negative");
        }
        
        if (ammoQuantity  > 20 || ammoQuantity  < 0) {
            throw new InventoryControlException("Ammunition out of range: "
                    + "Cannot be negative or more than 20 boxes");
        }
        
        if (foodQuantity > 2000 || foodQuantity < 0) {
            throw new InventoryControlException("Food out of range: "
                    + "Cannot be negative or more than 2000lbs");
        }

        if (axleQuantity  > 8 || axleQuantity  < 0) {
            throw new InventoryControlException("Axles out of range: "
                    + "Cannot be negative or more than 8 axles");
        }
        
        if (wheelQuantity  > 8 || wheelQuantity  < 0) {
            throw new InventoryControlException("Wheels out of range: "
                    + "Cannot be negative or more than 8 wheels");
        }
        
        if (tongueQuantity  > 8 || tongueQuantity  < 0) {
            throw new InventoryControlException("Tongues out of range: "
                    + "Cannot be negative or more than 8 togues");
        }
    }

}
