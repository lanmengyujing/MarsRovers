package com.app.initialization;

import com.app.exception.GameException;
import com.app.game.Plateau;
import com.app.game.Rover;
import com.app.parser.PlaceParser;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlaceInitializationTest {
    @Test
    public void should_rover_in_23N_when_input_23N() throws GameException {
        Rover rover = new Rover();
        PlaceInitialization initialization = new PlaceInitialization("2 3 N", rover);
        Plateau.getInstance().setUpperX(4);
        Plateau.getInstance().setUpperY(5);

        PlaceParser parser = mock(PlaceParser.class);
        when(parser.getPosX()).thenReturn(2);
        when(parser.getPosX()).thenReturn(3);
        when(parser.getOrientation()).thenReturn('N');

        initialization.configure();
        assertThat(rover.getPosX(), is(2));
        assertThat(rover.getPosY(), is(3));
        assertThat(rover.getOrientation().orientationName(), is('N'));
    }
}
