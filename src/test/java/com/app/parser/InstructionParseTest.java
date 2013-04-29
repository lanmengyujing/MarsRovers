package com.app.parser;

import com.app.exception.WrongCommandException;
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

    @Test(expected = WrongCommandException.class)
    public void should_be_invalid_when_input_ab12c() throws WrongCommandException {
        parser.parse("ab12c");
    }

}
