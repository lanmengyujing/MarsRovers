package parser;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-1-9
 * Time: 下午5:18
 * To change this template use File | Settings | File Templates.
 */
public class InstructionParseTest {
    private InstructionParser parser = new InstructionParser();

    @Test
    public void test_command_parser(){
        parser.parse("MmRrLl");
        assertThat( parser.getInsruction(), is("MMRRLL") );
    }

}
