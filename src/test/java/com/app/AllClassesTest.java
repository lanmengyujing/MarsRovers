package com.app;

import com.app.direction.*;
import com.app.game.MarsRoverGameTest;
import com.app.game.RoverBustTest;
import com.app.game.RoverTest;
import com.app.initialization.InstructionInitializationTest;
import com.app.initialization.PlaceInitializationTest;
import com.app.initialization.PlateauInitializationTest;
import com.app.parser.InstructionParseTest;
import com.app.parser.PlaceParserTest;
import com.app.parser.PlateauParserTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        RoverTest.class,
        RoverBustTest.class,
        MarsRoverGameTest.class,
        InstructionParseTest.class,
        PlaceParserTest.class,
        PlateauParserTest.class,
        InstructionInitializationTest.class,
        PlaceInitializationTest.class,
        PlateauInitializationTest.class,
        EStateTest.class,
        NStateTest.class,
        WStateTest.class,
        SStateTest.class
})

public class AllClassesTest {
}
