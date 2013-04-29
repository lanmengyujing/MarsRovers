package com.app.exception;


public class CrashException extends GameException {
    @Override
    public String getMessage(){
        return "Rovers crash each other";
    }
}
