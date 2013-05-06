package com.app.direction;

import com.app.exception.OutOfBoundException;
import com.app.game.Plateau;
import com.app.game.Rover;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class SStateTest {
private SState state;
private Rover rover;
    @Before
    public void setUp() throws Exception {
        rover = new Rover(5, 2,'s');
        state = new SState(rover);

    }

    @Test
    public void should_get_east_when_turn_left(){
        assertThat(state.turnLeft() instanceof EState ,is(true));
    }

    @Test
    public void should_get_west_when_turn_right(){
        assertThat((state.turnRight() instanceof WState) ,is(true));
    }

    @Test
    public void should_rover_move_when_forward() throws OutOfBoundException {
        Plateau plateau = new Plateau(5, 5);
        rover.setPlateau(plateau);
        state.forward();
        assertThat(rover.getPosY(), is(1));
    }
}
