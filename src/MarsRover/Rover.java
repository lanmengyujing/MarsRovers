package MarsRover;

import command.AbstractFactory;
import command.Command;
import direction.*;

public class Rover {
    public static final int INS_LEN = 100;

    private String name = " ";
    private int posX = 0;
    private int posY = 0;

    private String instruction = " ";

    Orientation orientation ;

    public Rover (String name){
        this.name = name;
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
        String className = new StringBuilder().append("direction.").append(charOrientation).append("Action").toString();
        try {
            Class orientationClass = Class.forName(className);
            this.orientation = (Orientation) orientationClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public Orientation getOrientation() {
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

    public boolean isInPlateau(int x, int y) {
        if (!Plateau.getInstance().isInRange(x, y)) {
            System.out.println("Caution " + this.name + " is out of bound ");
            return false;
        }
        return true;
    }

    public void operation(char instruction) throws AssertionError {
        instruction = Character.toUpperCase(instruction);
        AbstractFactory abstractFactory =  AbstractFactory.getInstance(instruction);
        Command command = abstractFactory.createCommand(this);
        try{
            command.action();
        }catch (OutOfBoundException e){
            e.printStackTrace();
        }
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
