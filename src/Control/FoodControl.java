/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Exceptions.FoodControlException;

/**
 *
 * @author adm-achina
 */
public class FoodControl {

    public static void calcRemainingFood(int noOfPeople, int noDaysTravelled,
            int rationType, int initialFood) throws  FoodControlException{
        int remainingFood;
        
        if (noOfPeople < 1 || noDaysTravelled < 0 || initialFood < 0) { // test for invalid cases
            throw new FoodControlException("You cannot enter a negative number");
        }
        if (initialFood == 0 || initialFood > 2000) { // test for boundary cases
            throw new FoodControlException("Out of range: must be between 0 and 2000Ibs inclusive");
        } else {
        }
        remainingFood = initialFood - (noOfPeople * noDaysTravelled * rationType);
    }
    
    public static void calcFoodConsumption(int noOfPeople, int noDaysTravelled, int rationType)throws FoodControlException{
        
        int foodConsumption;
        
        if(noDaysTravelled < 0 || noDaysTravelled < 0 || rationType < 0){
            throw new FoodControlException("You cannot enter a negative number");
        } 
        else {
            foodConsumption = (noOfPeople * noDaysTravelled * rationType);
        }
        
    }     
}