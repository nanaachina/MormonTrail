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
public class RiverCrossingControlException extends Exception{

    public RiverCrossingControlException() {
    }

    public RiverCrossingControlException(String message) {
        super(message);
    }

    public RiverCrossingControlException(String message, Throwable cause) {
        super(message, cause);
    }

    public RiverCrossingControlException(Throwable cause) {
        super(cause);
    }

    public RiverCrossingControlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
