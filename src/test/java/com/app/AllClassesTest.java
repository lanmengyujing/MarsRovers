package com.app;

import com.app.game.MarsRoverGameTest;
import com.app.game.RoverTest;
import com.app.parser.InstructionParseTest;
import com.app.parser.PlaceParserTest;
import com.app.parser.PlateauParserTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


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
