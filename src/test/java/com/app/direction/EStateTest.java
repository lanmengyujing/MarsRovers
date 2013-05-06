package com.app.direction;

import com.app.exception.OutOfBoundException;
import com.app.game.Plateau;
import com.app.game.Rover;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class EStateTest {
    private EState state;
    private Rover rover;
    @Before
    public void setUp() throws Exception {
        rover = new Rover(5, 2,'n');
        state = new EState(rover);

    }

    @Test
    public void should_get_north_when_turn_left(){
        assertThat(state.turnLeft() ,instanceOf( NState.class));
    }

    @Test
    public void should_get_south_when_turn_right(){
        assertThat(state.turnRight() ,instanceOf( SState.class));
    }

    @Test
    public void should_rover_move_when_forward() throws OutOfBoundException {
        Plateau plateau = new Plateau(10 ,10);
        rover.setPlateau(plateau);
        state.forward();
        assertThat(rover.getPosX(), is(6));
    }

}
