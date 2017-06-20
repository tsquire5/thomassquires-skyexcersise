package com.squiressoftware.skyexample.exceptions;

public class TechnicalFailureException extends Exception {

    public TechnicalFailureException(String message){
        super(message);
    }

    public TechnicalFailureException(String message, Throwable cause){
        super(message, cause);
    }

}
