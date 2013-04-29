package com.app.game;
import com.app.direction.State;
import com.app.exception.OutOfBoundException;

import java.lang.reflect.Constructor;

public class Rover {
    public static final int INS_LEN = 100;
    private String name = " ";
    private int posX = 0;
    private int posY = 0;
    private String instruction = " ";

    State orientation;

    public Rover (){
    }

    public Rover(int posX, int posY, char orientation) {
        this.posX = posX;
        this.posY = posY;
        setOrientation(orientation);
    }

    public Rover(String name, int posX, int posY, char orientation) {
        this.name = name;
        this.posX = posX;
        this.posY = posY;
        setOrientation(orientation);
    }

    public String getName() {
        return name;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setOrientation(char ori) {
        char charOrientation = Character.toUpperCase(ori);
        String className = new StringBuilder().append("com.app.direction.").append(charOrientation).append("State").toString();
        try {
            Class<?> orientationClass = Class.forName(className);
            Constructor constructor = orientationClass.getConstructor(Rover.class);
            this.orientation = (State)constructor.newInstance(this);
        }catch (ClassNotFoundException e) {
            throw new IllegalArgumentException();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setOrientation(State orientation) {
        this.orientation = orientation;
    }

    public State getOrientation() {
        return orientation;
    }

    public void setInstruction(String insList) {
        if (!insList.isEmpty() && insList.length() < INS_LEN) {
            instruction = insList;
        }
    }

    public String getInstruction() {
        return instruction;
    }

    public boolean isInPlateau(int x, int y)  {
        if (!Plateau.getInstance().isInRange(x, y)) {
            return false;
        }
        return true;
    }

    public void operation(char instruction) throws OutOfBoundException {
        instruction = Character.toUpperCase(instruction);
        switch (instruction) {
            case 'M':
                forward();
                break;
            case 'R':
                turnRight();
                break;
            case 'L':
                turnLeft();
                break;
            default:
                throw  new AssertionError();
        }

    }

    private void forward() throws OutOfBoundException {
        orientation.forward();
    }

    private void turnRight() {
        orientation = orientation.turnRight();
    }

    private void turnLeft() {
        orientation = orientation.turnLeft();
    }

    @Override
    public String toString() {
        char ori = getOrientation().orientationName();
        if (isInPlateau(posX, posY)) {
            return   posX + " " + posY + " " + ori;
        } else {
            return  posX + " " + posY + " " + ori + " RIP";
        }
    }
}
