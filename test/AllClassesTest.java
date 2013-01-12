/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-1-11
 * Time: 上午10:53
 * To change this template use File | Settings | File Templates.
 */

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        RoverTest.class,
        RoverBustTest.class,
        RoverManagerTest.class,
        MarsRoversGameTest.class,
        PlateauParserTest.class,
        CommandParseTest.class,
        PositionAndOrientationParserTest.class
})

public class AllClassesTest {
}
