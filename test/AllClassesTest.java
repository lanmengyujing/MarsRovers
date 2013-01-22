/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-1-11
 * Time: 上午10:53
 * To change this template use File | Settings | File Templates.
 */

import Game.MarsRoverGameTest;
import Game.RoverTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import parser.InstructionParseTest;
import parser.PlaceParserTest;
import parser.PlateauParserTest;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        RoverTest.class,
        //RoverBustTest.class,
        MarsRoverGameTest.class,
        PlateauParserTest.class,
        InstructionParseTest.class,
        PlaceParserTest.class
})

public class AllClassesTest {
}
