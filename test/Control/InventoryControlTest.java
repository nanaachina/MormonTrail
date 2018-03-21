/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author adm-achina
 */
public class InventoryControlTest {

    public InventoryControlTest() {
    }

    /**
     * Test of calcRemainingFunds method, of class InventoryControl.
     */
    @Test
    public void testCalcRemainingFunds() {
        System.out.println("calcRemainingFunds");

        //This is test case #1
        System.out.println("Test case #1");
        int initFunds = 1600;
        int totalBill = 930;
        int remainingFunds = 670;
        int oxen = 8;
        int food = 2000;
        int clothing = 10;
        int ammo = 10;
        int wheel = 3;
        int axle = 3;
        int tongue = 3;
        InventoryControl instance = new InventoryControl();

        //Expected output return
        int expResult = 670;

        //Call the function to run test
//        int result = instance.calcRemainingFunds(initFunds, totalBill, remainingFunds, oxen, food, clothing, ammo, wheel, axle, tongue);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
        //This is test case #2
        System.out.println("Test case #2");
        initFunds = 600;
        totalBill = 410;
        remainingFunds = 190;
        oxen = 1;
        food = 1000;
        clothing = 10;
        ammo = 5;
        wheel = 2;
        axle = 2;
        tongue = 2;

        //Expected output return
        expResult = 190;

        //Call the function to run test
//        result = instance.calcRemainingFunds(initFunds, totalBill, remainingFunds, oxen, food, clothing, ammo, wheel, axle, tongue);
//        assertEquals(expResult, result);
        //This is test case #3
        System.out.println("Test case #3");
        initFunds = 400;
        totalBill = 400;
        remainingFunds = 0;
        oxen = 2;
        food = 1000;
        clothing = 5;
        ammo = 5;
        wheel = 2;
        axle = 2;
        tongue = 2;

        //Expected output return
        expResult = 0;

        //Call the function to run test
//        result = instance.calcRemainingFunds(initFunds, totalBill, remainingFunds, oxen, food, clothing, ammo, wheel, axle, tongue);
//        assertEquals(expResult, result);
        //This is test case #4
        System.out.println("Test case #4");
        initFunds = -1;
        totalBill = 350;
        remainingFunds = -1;
        oxen = 2;
        food = 1000;
        clothing = 0;
        ammo = 5;
        wheel = 2;
        axle = 2;
        tongue = 2;

        //Expected output return
        expResult = -1;

        //Call the function to run test
//        result = instance.calcRemainingFunds(initFunds, totalBill, remainingFunds, oxen, food, clothing, ammo, wheel, axle, tongue);
//        assertEquals(expResult, result);
        //This is test case #5
        System.out.println("Test case #5");
        initFunds = 600;
        totalBill = 230;
        remainingFunds = -1;
        oxen = -1;
        food = 1000;
        clothing = 0;
        ammo = 5;
        wheel = 2;
        axle = 2;
        tongue = 2;

        //Expected output return
        expResult = -1;

        //Call the function to run test
//        result = instance.calcRemainingFunds(initFunds, totalBill, remainingFunds, oxen, food, clothing, ammo, wheel, axle, tongue);
//        assertEquals(expResult, result);
        //This is test case #6
        System.out.println("Test case #6");
        initFunds = 600;
        totalBill = 149;
        remainingFunds = -1;
        oxen = 2;
        food = -1;
        clothing = 0;
        ammo = 5;
        wheel = 2;
        axle = 2;
        tongue = 2;

        //Expected output return
        expResult = -1;

        //Call the function to run test
//        result = instance.calcRemainingFunds(initFunds, totalBill, remainingFunds, oxen, food, clothing, ammo, wheel, axle, tongue);
//        assertEquals(expResult, result);
        //This is test case #7
        System.out.println("Test case #7");
        initFunds = 600;
        totalBill = 338;
        remainingFunds = -1;
        oxen = 2;
        food = 1000;
        clothing = 0;
        ammo = -1;
        wheel = 2;
        axle = 2;
        tongue = 2;

        //Expected output return
        expResult = -1;

        //Call the function to run test
//        result = instance.calcRemainingFunds(initFunds, totalBill, remainingFunds, oxen, food, clothing, ammo, wheel, axle, tongue);
//        assertEquals(expResult, result);
        //This is test case #8
        System.out.println("Test case #8");
        initFunds = 600;
        totalBill = 320;
        remainingFunds = -1;
        oxen = 2;
        food = 1000;
        clothing = 0;
        ammo = 5;
        wheel = -1;
        axle = 2;
        tongue = 2;

        //Expected output return
        expResult = -1;

        //Call the function to run test
//        result = instance.calcRemainingFunds(initFunds, totalBill, remainingFunds, oxen, food, clothing, ammo, wheel, axle, tongue);
//        assertEquals(expResult, result);
        //This is test case #9
        System.out.println("Test case #9");
        initFunds = 600;
        totalBill = 320;
        remainingFunds = -1;
        oxen = 2;
        food = 1000;
        clothing = 0;
        ammo = 5;
        wheel = 2;
        axle = -1;
        tongue = 2;

        //Expected output return
        expResult = -1;

        //Call the function to run test
//        result = instance.calcRemainingFunds(initFunds, totalBill, remainingFunds, oxen, food, clothing, ammo, wheel, axle, tongue);
//        assertEquals(expResult, result);
        //This is test case #10
        System.out.println("Test case #10");
        initFunds = 600;
        totalBill = 320;
        remainingFunds = -1;
        oxen = 2;
        food = 1000;
        clothing = 0;
        ammo = 5;
        wheel = 2;
        axle = 2;
        tongue = -1;

        //Expected output return
        expResult = -1;

        //Call the function to run test
//        result = instance.calcRemainingFunds(initFunds, totalBill, remainingFunds, oxen, food, clothing, ammo, wheel, axle, tongue);
//        assertEquals(expResult, result);
        //This is test case #11
        System.out.println("Test case #11");
        initFunds = 1600;
        totalBill = 830;
        remainingFunds = -1;
        oxen = 8;
        food = 2001;
        clothing = 0;
        ammo = 10;
        wheel = 3;
        axle = 3;
        tongue = 3;

        //Expected output return
        expResult = -1;

        //Call the function to run test
//        result = instance.calcRemainingFunds(initFunds, totalBill, remainingFunds, oxen, food, clothing, ammo, wheel, axle, tongue);
//        assertEquals(expResult, result);
        //This is test case #12
        System.out.println("Test case #12");
        initFunds = 1601;
        totalBill = 830;
        remainingFunds = -1;
        oxen = 8;
        food = 2000;
        clothing = 0;
        ammo = 10;
        wheel = 3;
        axle = 3;
        tongue = 3;

        //Expected output return
        expResult = -1;

        //Call the function to run test
//        result = instance.calcRemainingFunds(initFunds, totalBill, remainingFunds, oxen, food, clothing, ammo, wheel, axle, tongue);
//        assertEquals(expResult, result);
        //This is test case #13
        System.out.println("Test case #13");
        initFunds = 1600;
        totalBill = 832;
        remainingFunds = -1;
        oxen = 8;
        food = 2000;
        clothing = 0;
        ammo = 11;
        wheel = 3;
        axle = 3;
        tongue = 3;

        //Expected output return
        expResult = -1;

        //Call the function to run test
//        result = instance.calcRemainingFunds(initFunds, totalBill, remainingFunds, oxen, food, clothing, ammo, wheel, axle, tongue);
//        assertEquals(expResult, result);
        //This is test case #14
        System.out.println("Test case #14");
        initFunds = 1600;
        totalBill = 840;
        remainingFunds = -1;
        oxen = 8;
        food = 2000;
        clothing = 0;
        ammo = 10;
        wheel = 4;
        axle = 3;
        tongue = 3;

        //Expected output return
        expResult = -1;

        //Call the function to run test
//        result = instance.calcRemainingFunds(initFunds, totalBill, remainingFunds, oxen, food, clothing, ammo, wheel, axle, tongue);
//        assertEquals(expResult, result);
        //This is test case #15
        System.out.println("Test case #15");
        initFunds = 1600;
        totalBill = 840;
        remainingFunds = -1;
        oxen = 8;
        food = 2000;
        clothing = 0;
        ammo = 10;
        wheel = 3;
        axle = 4;
        tongue = 3;

        //Expected output return
        expResult = -1;

        //Call the function to run test
//        result = instance.calcRemainingFunds(initFunds, totalBill, remainingFunds, oxen, food, clothing, ammo, wheel, axle, tongue);
//        assertEquals(expResult, result);
        //This is test case #16
        System.out.println("Test case #16");
        initFunds = 1600;
        totalBill = 840;
        remainingFunds = -1;
        oxen = 8;
        food = 2000;
        clothing = 0;
        ammo = 10;
        wheel = 3;
        axle = 3;
        tongue = 4;

        //Expected output return
        expResult = -1;

        //Call the function to run test
//        result = instance.calcRemainingFunds(initFunds, totalBill, remainingFunds, oxen, food, clothing, ammo, wheel, axle, tongue);
//        assertEquals(expResult, result);
        //This is test case #17
        System.out.println("Test case #17");
        initFunds = 1600;
        totalBill = 840;
        remainingFunds = -1;
        oxen = 8;
        food = 2000;
        clothing = -1;
        ammo = 10;
        wheel = 3;
        axle = 3;
        tongue = 4;

        //Expected output return
        expResult = -1;

        //Call the function to run test
//        result = instance.calcRemainingFunds(initFunds, totalBill, remainingFunds, oxen, food, clothing, ammo, wheel, axle, tongue);
//        assertEquals(expResult, result);
    }

    /**
     * Test of checkInventoryLimits method, of class InventoryControl.
     */
    @Test
    public void testCheckInventoryLimits() {
        System.out.println("checkInventoryLimits");
        int oxenQuantity = 0;
        int clothQuantity = 0;
        int ammoQuantity = 0;
        int foodQuantity = 0;
        int axleQuantity = 0;
        int wheelQuantity = 0;
        int tongueQuantity = 0;
        InventoryControl.checkInventoryLimits(oxenQuantity, clothQuantity, ammoQuantity, foodQuantity, axleQuantity, wheelQuantity, tongueQuantity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
