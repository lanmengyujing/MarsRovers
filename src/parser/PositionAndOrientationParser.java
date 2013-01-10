package parser;

import MarsRover.Rover;
import direction.Orientation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-1-9
 * Time: 上午9:25
 * To change this template use File | Settings | File Templates.
 */
public class PositionAndOrientationParser implements parser {
    String regEx = "^\\s*\\d+\\s+\\d+\\s+[N|S|W|E]\\s*$";
    int posX;
    int posY;
    char orientation;
    Rover rover;

    @Override
    public boolean parse(String posAndOrientation) {
        Pattern pattern = Pattern.compile(regEx,Pattern.CASE_INSENSITIVE);
        Matcher m = pattern.matcher(posAndOrientation);
        boolean  result = m.find();
        if(result){
            String[] posAndOri = posAndOrientation.toUpperCase().split(" ") ;
            posX = Integer.valueOf(posAndOri[0]);
            posY = Integer.valueOf(posAndOri[1]);
            orientation = posAndOri[2].charAt(0);
            return true;
        }
        else{
            throw new IllegalArgumentException("The input position or orientation for rover is not valid!");
        }
    }

    public int getPosX(){
        return posX;
    }

    public int getPosY(){
        return posY;
    }

    public char getOrientation(){
        return orientation;
    }
}
