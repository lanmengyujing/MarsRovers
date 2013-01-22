package parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-1-9
 * Time: 上午9:46
 * To change this template use File | Settings | File Templates.
 */
public class InstructionParser implements parser {
    private String regEx = "^[L|M|R]*$";
    String instruction;

    @Override
    public void parse(String instruction) {
        instruction = instruction.toUpperCase();
        try {
            Match.matchCondition(regEx, instruction);
            this.instruction = instruction;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("The input commands for rover are not valid!");
        }
    }

    public String getInsruction() {
        return instruction;
    }
}
