package com.app.direction;

import com.app.exception.OutOfBoundException;
import com.app.game.Plateau;
import com.app.game.Rover;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class WStateTest {
    private WState state;
    private Rover rover;
    @Before
    public void setUp() throws Exception {
        rover = new Rover(5, 2,'w');
        state = new WState(rover);
        Plateau.getInstance().setUpperX(10);
        Plateau.getInstance().setUpperY(10);
    }

    @Test
    public void should_get_north_when_turn_right(){
        assertThat(state.turnRight() ,instanceOf(NState.class));
    }

    @Test
    public void should_get_south_when_turn_left(){
        assertThat(state.turnLeft() ,instanceOf(SState.class));
    }

    @Test
    public void should_rover_move_when_forward() throws OutOfBoundException {
        state.forward();
        assertThat(rover.getPosX(), is(4));
    }
}
