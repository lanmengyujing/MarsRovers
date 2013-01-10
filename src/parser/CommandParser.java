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
public class CommandParser implements parser {
    private String regEx = "^[L|M|R]*$";
    String commands;

    @Override
    public boolean parse(String instruction) {
        instruction = instruction.toUpperCase();
        Pattern pattern = Pattern.compile(regEx);
        Matcher m = pattern.matcher(instruction);
        if (m.find()){
            this.commands = instruction;
            return true;
        }else {
            throw new IllegalArgumentException("The input commands for rover are not valid!");
        }
    }

    public String getCommands(){
        return commands;
    }
}
