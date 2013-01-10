package parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-1-9
 * Time: 上午9:38
 * To change this template use File | Settings | File Templates.
 */
public class PlateauParser implements parser {
    private String regEx ="^(\\d*)\\s(\\d*)$";   //"^(\\d*) (\\d*)$"
    private int upperX;
    private int upperY;

    @Override
    public boolean parse(String area) {
        Pattern pattern = Pattern.compile(regEx);
        Matcher m = pattern.matcher(area);
        if(m.find()){
            String[] inputArea = area.split(" ");
            upperX = Integer.valueOf(inputArea[0]);
            upperY = Integer.valueOf(inputArea[1]);
            return true;
        }else{
            throw new IllegalArgumentException("The input area for Plateau is not valid");
        }
    }

    public int getUpperX(){
        return upperX;
    }

    public int getUpperY(){
        return upperY;
    }
}
