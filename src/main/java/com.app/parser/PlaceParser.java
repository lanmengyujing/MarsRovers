package com.app.parser;

import com.app.exception.WrongInputForRoverException;

public class PlaceParser implements parser {
    String regEx = "^\\s*\\d*+\\s+\\d*+\\s+[N|S|W|E]\\s*$";
    int posX;
    int posY;
    char orientation;

    @Override
    public void parse(String posAndOrientation) throws WrongInputForRoverException {
        posAndOrientation = posAndOrientation.toUpperCase();
        try {
            Match.matchCondition(regEx, posAndOrientation);
            String[] posAndOri = posAndOrientation.split(" ");
            posX = Integer.valueOf(posAndOri[0]);
            posY = Integer.valueOf(posAndOri[1]);
            orientation = posAndOri[2].charAt(0);
        } catch (IllegalArgumentException e) {
            throw new WrongInputForRoverException(WrongInputForRoverException.ROVER_INIT_TIP);
        }
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public char getOrientation() {
        return orientation;
    }
}
