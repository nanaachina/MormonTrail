/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author adm-achina
 */
public class FoodControlTest {

    public FoodControlTest() {
    }

    /**
     * Test of calcRemainingFood method, of class FoodControl.
     */
    @Test
    public void testCalcRemainingFood() {

        /*
        * Valid Cases Tests #1 - #3
         */
        System.out.println("Test#1 calcRemainingFood");
        int noOfPeople = 2;
        int noDaysTravelled = 2;
        int rationType = 3;
        int initialFood = 1000;
        //FoodControl instance = new FoodControl();
        int expResult = 988;
        //int result = FoodControl.calcRemainingFood(noOfPeople, noDaysTravelled, rationType, initialFood);
//        assertEquals(expResult, result, 0.0001);

        System.out.println("Test#2 calcRemainingFood");
        noOfPeople = 2;
        noDaysTravelled = 2;
        rationType = 2;
        initialFood = 1000;
        expResult = 992;
        //result = instance.calcRemainingFood(noOfPeople, noDaysTravelled, rationType, initialFood);
//        assertEquals(expResult, result, 0.0001);

        System.out.println("Test#3 calcRemainingFood");
        noOfPeople = 2;
        noDaysTravelled = 2;
        rationType = 1;
        initialFood = 1000;
        expResult = 996;
        //result = instance.calcRemainingFood(noOfPeople, noDaysTravelled, rationType, initialFood);
//        assertEquals(expResult, result, 0.0001);

        /*
        * Invalid Test Cases #4 & #5
         */
        System.out.println("Test#4 calcRemainingFood");
        noOfPeople = 0;
        noDaysTravelled = 2;
        rationType = 1;
        initialFood = 1000;
        expResult = -1;
        //result = instance.calcRemainingFood(noOfPeople, noDaysTravelled, rationType, initialFood);
//        assertEquals(expResult, result, 0.0001);

        System.out.println("Test#5 calcRemainingFood");
        noOfPeople = 2;
        noDaysTravelled = -1;
        rationType = 2;
        initialFood = 1000;
        expResult = -1;
        //result = instance.calcRemainingFood(noOfPeople, noDaysTravelled, rationType, initialFood);
//        assertEquals(expResult, result, 0.0001);

        /*
        * Boundary Test Cases #6 & #7
         */
        System.out.println("Test#6 calcRemainingFood"); // Boundary 1 is 0 pounds
        noOfPeople = 1;
        noDaysTravelled = 1;
        rationType = 5;
        initialFood = 0;
        expResult = -1;
        //result = instance.calcRemainingFood(noOfPeople, noDaysTravelled, rationType, initialFood);
        //assertEquals(expResult, result, 0.0001);

        System.out.println("Test#7 calcRemainingFood");// Boundary 2 more than 2000 pounds
        noOfPeople = 1;
        noDaysTravelled = 1;
        rationType = 5;
        initialFood = 2001;
        expResult = -1;
        //result = instance.calcRemainingFood(noOfPeople, noDaysTravelled, rationType, initialFood);
        //assertEquals(expResult, result, 0.0001);
    }

}
