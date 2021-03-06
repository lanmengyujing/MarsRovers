package com.app.initialization;

import com.app.exception.GameException;
import com.app.game.Plateau;
import com.app.parser.PlateauParser;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlateauInitializationTest {

    @Test
    public void should_plateau_be_4_5_when_input_4_and_5() throws GameException {
        Plateau plateau = new Plateau();
        PlateauInitialization plateauInitialization = new PlateauInitialization("4 5", plateau);
        PlateauParser parser = mock(PlateauParser.class);
        when(parser.getUpperX()).thenReturn(4);
        when(parser.getUpperY()).thenReturn(5);

        plateauInitialization.configure();
        assertThat(plateau.getUpperX(), is(4));
        assertThat(plateau.getUpperY(), is(5));
    }

}
