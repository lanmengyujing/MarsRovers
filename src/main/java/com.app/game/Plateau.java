package com.app.game;

public class Plateau {
    private int upperX;
    private int upperY;
    static Plateau plateau;

    public Plateau(int upperX, int upperY) {
        this.upperX = upperX;
        this.upperY = upperY;
    }

    public Plateau() {
    }

    public int getUpperY() {
        return upperY;
    }

    public int getUpperX() {
        return upperX;
    }

    public static Plateau getInstance() {
        if (plateau == null) {
            plateau = new Plateau(5 ,5);
        }
        return plateau;
    }

    public void setUpperX(int upperX) {
        this.upperX = upperX;
    }

    public void setUpperY(int upperY) {
        this.upperY = upperY;
    }

    public boolean isInRange(int x, int y) {
        return x >= 0 && y >= 0 && x <= upperX && y <= upperY;
    }


}
