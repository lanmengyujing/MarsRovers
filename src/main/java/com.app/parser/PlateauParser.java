package com.app.parser;

import com.app.exception.WrongInputForPlateauException;

public class PlateauParser implements parser {
    private String regEx = "^(\\d*)\\s(\\d*)\\s*$";
    private int upperX;
    private int upperY;

    @Override
    public void parse(String area) throws WrongInputForPlateauException {
        try {
            Match.matchCondition(regEx, area);
            String[] inputArea = area.split(" ");
            upperX = Integer.valueOf(inputArea[0]);
            upperY = Integer.valueOf(inputArea[1]);
        } catch (IllegalArgumentException e) {
            throw new WrongInputForPlateauException();
        }
    }

    public int getUpperX() {
        return upperX;
    }

    public int getUpperY() {
        return upperY;
    }
}
