package com.app.parser;

import com.app.exception.WrongCommandException;

public class InstructionParser implements parser {
    private String regEx = "^[L|M|R]*$";
    String instruction;

    @Override
    public void parse(String instruction) throws WrongCommandException {
        instruction = instruction.toUpperCase();
        try {
            Match.matchCondition(regEx, instruction);
            this.instruction = instruction;
        } catch (IllegalArgumentException e) {
            throw new WrongCommandException();
        }
    }

    public String getInsruction() {
        return instruction;
    }
}
