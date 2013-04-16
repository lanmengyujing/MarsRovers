package parser;

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
}
