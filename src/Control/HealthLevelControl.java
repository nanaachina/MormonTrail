/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;


import Exceptions.HealthLevelControlException;
import java.io.Serializable;

/**
 *
 * @author adm-achina
 */
public class HealthLevelControl implements Serializable{

    public void evalHealthLevel(int days, int ration, int pace) throws HealthLevelControlException {
        int health = 0;

        if (ration < 0 || ration > 3) { // ration range 1-3
            throw new HealthLevelControlException("Error: Rations must be in the range 0 to 3 Inclusive");
        }

        if (pace < 0 || pace > 3) { // pace range 1-3
            throw new HealthLevelControlException("Error: Pace must be in the range 0 to 3 Inclusive");
        }

        if (days < 0) {  // negative days
            throw new HealthLevelControlException("Error: Days cannot be negative");

        }

        // Valid Cases
        if (days >= 1 && days <= 44 && ration >= 1 && ration <= 3 && pace >= 1 && pace <= 3) {
            throw new HealthLevelControlException("Normal: Good Health");
        }

        // days 45-89
        if (days >= 45 && days <= 89 && ration >= 1 && ration <= 3 && pace >= 1 && pace <= 3) {
            throw new HealthLevelControlException("Normal: Fair Health");

        }

        //days 90 - 134
        if (days >= 90 && days <= 134 && ration >= 1 && ration <= 3 && pace >= 1 && pace <= 3) {
            throw new HealthLevelControlException("Normal: Poor Health");
        }

        // days = 135
        if (days == 135 && ration >= 1 && ration <= 3 && pace >= 1 && pace <= 3) {
            throw new HealthLevelControlException("Normal: Death has arrived");
        }

        // Boundary Days
        if (days == 0 || days >= 136) {
            throw new HealthLevelControlException("Out of Range: days travel "
                    + "must be in the range of 0 to 136 inclusive");
        }
    }
}
