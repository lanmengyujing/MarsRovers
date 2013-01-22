package Game;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-1-9
 * Time: 下午3:30
 * To change this template use File | Settings | File Templates.
 */
public class MarsRoverGameTest {
    private MarsRoverGame marsRoverGame;


    @Before
    public void setup(){
        marsRoverGame = new MarsRoverGame();
    }

    @Test
    public void test_startGame(){
        String strTest = "12 12\n"
                + "1 1 N\n"
                + "MLR\n"
                + "1 10 W\n"
                + "LMM\n"
                ;
        marsRoverGame = new MarsRoverGame(strTest);
        marsRoverGame.init();
        marsRoverGame.startGame();
        marsRoverGame.startGame();
    }
}
