package com.app.exception;


public class WrongCommandException extends GameException {
    @Override
    public String getMessage(){
        return "The input commands for rover are not valid!Please input commands as\"MRL\", try again";
    }
}
