import org.junit.Before;
import org.junit.Test;
import parser.PositionAndOrientationParser;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-1-9
 * Time: 下午4:21
 * To change this template use File | Settings | File Templates.
 */
public class PositionAndOrientationParserTest {
    private PositionAndOrientationParser parser;
    @Before
    public void setup(){
        parser = new PositionAndOrientationParser();
    }

    @Test
    public void should_pos_be_2_3_ori_be_N_when_input_string_23N(){
        parser.parse("2 3 N");
        assertThat(parser.getPosX(), is(2));
        assertThat(parser.getPosY(), is(3));
        assertThat(parser.getOrientation(),is('N'));
    }
}
