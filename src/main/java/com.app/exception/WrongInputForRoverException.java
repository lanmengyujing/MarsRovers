package com.app.exception;

public class WrongInputForRoverException extends GameException {
    @Override
    public String getMessage(){
        return "The input position or orientation for rover is not valid!";
    }

}
