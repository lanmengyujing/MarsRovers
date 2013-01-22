package parser;

import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-1-9
 * Time: 下午4:21
 * To change this template use File | Settings | File Templates.
 */
public class PlaceParserTest {
    private PlaceParser parser;

    @Before
    public void setup() {
        parser = new PlaceParser();
    }

    @Test
    public void should_pos_be_2_3_ori_be_N_when_input_string_23N() {
        parser.parse("2 3 N");
        assertThat(parser.getPosX(), is(2));
        assertThat(parser.getPosY(), is(3));
        assertThat(parser.getOrientation(), is('N'));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_input_23t() {
        parser.parse("2 3 t");
    }
}
