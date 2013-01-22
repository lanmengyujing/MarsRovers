package parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-1-20
 * Time: 上午9:55
 * To change this template use File | Settings | File Templates.
 */
public class Match {
    public static boolean matchCondition(String regEx, String input) {
        Pattern pattern = Pattern.compile(regEx);
        Matcher m = pattern.matcher(input);
        if (m.find()) {
            return true;
        } else {
            throw new IllegalArgumentException("The input argument is not valid!");
        }
    }
}
