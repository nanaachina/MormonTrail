//<editor-fold defaultstate="collapsed" desc="comment">
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Exceptions;

/**
 *
 * @author adm-achina
 */
public class FoodControlException extends Exception {
    
    public FoodControlException() {
    }
    
    public FoodControlException(String message) {
        super(message);
    }
    
    public FoodControlException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public FoodControlException(Throwable cause) {
        super(cause);
    }
    
    public FoodControlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    
    
}

