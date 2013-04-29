package com.app.parser;

import com.app.exception.WrongInputForPlateauException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class PlateauParserTest {
    PlateauParser parser;
    @Before
    public void setup(){
        parser = new PlateauParser();
    }

    @Test
    public void test_plateau_parser() throws Exception {
        parser.parse("5 5");
        assertThat( parser.getUpperX(), is(5) );
        assertThat( parser.getUpperY(), is(5) );
    }

    @Test(expected = WrongInputForPlateauException.class)
    public void should_be_invalid_when_input_ab12c() throws WrongInputForPlateauException {
        parser.parse("4y");
    }
}
