package com.app.parser;

import com.app.exception.WrongInputForRoverException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PlaceParserTest {
    private PlaceParser parser;

    @Before
    public void setup() {
        parser = new PlaceParser();
    }

    @Test
    public void should_pos_be_2_3_ori_be_N_when_input_string_23N() throws WrongInputForRoverException {
        parser.parse("2 3 N");
        assertThat(parser.getPosX(), is(2));
        assertThat(parser.getPosY(), is(3));
        assertThat(parser.getOrientation(), is('N'));
    }

    @Test(expected = WrongInputForRoverException.class)
    public void should_throw_exception_when_input_23t() throws WrongInputForRoverException {
        parser.parse("2 3 t");
    }
}
