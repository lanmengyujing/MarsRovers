package com.app.game;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/29/13
 * Time: 10:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {
        MarsRoverGame marsRoverGame = new MarsRoverGame();
        marsRoverGame.init();
        while (true) {
            marsRoverGame.startGame();
        }
    }
}
