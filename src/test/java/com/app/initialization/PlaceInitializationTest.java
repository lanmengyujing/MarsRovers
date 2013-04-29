package com.app.initialization;

import com.app.exception.GameException;
import com.app.game.Rover;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PlaceInitializationTest {
    @Test
    public void should_rover_in_23N_when_input_23N() throws GameException {
        Rover rover = new Rover();
        PlaceInitialization initialization = new PlaceInitialization("2 3 N", rover);
        initialization.configure();
        assertThat(rover.getPosX(), is(2));
        assertThat(rover.getPosY(), is(3));
        assertThat(rover.getOrientation().orientationName(), is('N'));
    }
}
