package com.app.game;


public class Main {
    public static void main(String[] args) {
        MarsRoverGame marsRoverGame = new MarsRoverGame();
        marsRoverGame.init();
        while (true) {
            marsRoverGame.startGame();
        }
    }
}
