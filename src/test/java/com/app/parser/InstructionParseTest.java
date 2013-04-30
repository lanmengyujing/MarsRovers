package com.app.parser;

import com.app.exception.WrongCommandException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class InstructionParseTest {
    private InstructionParser parser = new InstructionParser();

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void test_command_parser() throws WrongCommandException {
        parser.parse("MmRrLl");
        assertThat( parser.getInstruction(), is("MMRRLL") );
    }

    @Test(expected = WrongCommandException.class)
    public void should_be_invalid_when_input_ab12c() throws WrongCommandException {
        parser.parse("ab12c");
        expectedEx.expectMessage("The input commands for rover are not valid!Please input commands as\"MRL\", try again");

    }

}
