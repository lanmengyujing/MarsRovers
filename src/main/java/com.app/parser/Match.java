package com.app.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
