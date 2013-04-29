package com.app.exception;

public class WrongInputForPlateauException extends GameException {
    @Override
    public String getMessage(){
        return "The input area for Plateau is not valid!";
    }
}
