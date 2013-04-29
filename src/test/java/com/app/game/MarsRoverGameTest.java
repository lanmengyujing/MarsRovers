package com.app.game;

import org.junit.Before;
import org.junit.Test;

public class MarsRoverGameTest {
    private MarsRoverGame marsRoverGame;


    @Before
    public void setup(){
        marsRoverGame = new MarsRoverGame();
    }

    @Test
    public void test_startGame(){
        String strTest = "12 12\n"
                + "1 1 N\n"
                + "MLR\n"
                + "1 10 W\n"
                + "LMM\n"
                ;
        marsRoverGame = new MarsRoverGame(strTest);
        marsRoverGame.init();
        marsRoverGame.startGame();
        marsRoverGame.startGame();
    }
}
