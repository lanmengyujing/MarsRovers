package parser;

import exception.WrongCommandException;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class InstructionParseTest {
    private InstructionParser parser = new InstructionParser();

    @Test
    public void test_command_parser() throws WrongCommandException {
        parser.parse("MmRrLl");
        assertThat( parser.getInsruction(), is("MMRRLL") );
    }

}
