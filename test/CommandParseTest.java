import org.junit.Test;
import parser.CommandParser;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-1-9
 * Time: 下午5:18
 * To change this template use File | Settings | File Templates.
 */
public class CommandParseTest {
    private CommandParser parser = new CommandParser();

    @Test
    public void test_command_parser(){
        parser.parse("MmRrLl");
        assertThat( parser.getCommands(), is("MMRRLL") );
    }

}
