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
public class HealthLevelControlException extends Exception {

    public HealthLevelControlException() {
    }

    public HealthLevelControlException(String message) {
        super(message);
    }

    public HealthLevelControlException(String message, Throwable cause) {
        super(message, cause);
    }

    public HealthLevelControlException(Throwable cause) {
        super(cause);
    }

    public HealthLevelControlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
