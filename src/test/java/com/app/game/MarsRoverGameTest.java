package com.app.game;

import com.app.direction.NState;
import com.app.exception.GameException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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

    @Test
    public void should_init_plateau_when_input() throws GameException {
        marsRoverGame.setPlateau("5 6");
        assertThat(Plateau.getInstance().getUpperX(), is(5));
        assertThat(Plateau.getInstance().getUpperY(), is(6));
    }


    @Test
    public void should_rover_command_be_MMRL_when_input_mmrl() throws GameException {
        Rover rover = new Rover();
        marsRoverGame.setRoverInstruction("mmrl", rover);
        assertThat(rover.getInstruction(), is("MMRL"));
    }

    @Test
    public void should_rover_in_23N_when_set_rover_23n() throws GameException {
        Rover rover = new Rover();
        marsRoverGame.setPlateau("5 6");
        marsRoverGame.setRoverPlace("2 3 n", rover);
        assertThat(rover.getPosY(), is(3));
        assertThat(rover.getPosX(), is(2));
        assertThat(rover.getOrientation() instanceof NState, is(true));
    }


}
