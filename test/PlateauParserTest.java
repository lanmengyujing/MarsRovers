import MarsRover.Plateau;
import org.junit.Before;
import org.junit.Test;
import parser.PlateauParser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-1-9
 * Time: 下午4:01
 * To change this template use File | Settings | File Templates.
 */
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
