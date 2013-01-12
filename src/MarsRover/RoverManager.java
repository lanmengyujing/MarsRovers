package MarsRover;

import parser.CommandParser;
import parser.PositionAndOrientationParser;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-1-8
 * Time: 上午11:29
 * To change this template use File | Settings | File Templates.
 */
public class RoverManager {
    public void initPositionAndOrientation (Rover rover, String posAndOri)throws OutOfBoundException{
        PositionAndOrientationParser parser = new PositionAndOrientationParser();
        if (parser.parse(posAndOri)){
            if (isInputPositionOutBound(parser.getPosX(), parser.getPosY())) {
                rover.setPosX(parser.getPosX());
                rover.setPosY(parser.getPosY());
            }
            rover.setOrientation(parser.getOrientation());
        }
    }

    private boolean isInputPositionOutBound(int x, int y){
        boolean flag = false;
        if (Plateau.getInstance().isInRange(x, y)){
            flag = true;
        }
        else {
            throw new OutOfBoundException();
        }
        return flag;
    }

    public void initCommand(Rover rover, String instruction ){
        CommandParser parser = new CommandParser();
        if (parser.parse(instruction)){
            rover.setInstruction(parser.getCommands());
        }
    }
}
