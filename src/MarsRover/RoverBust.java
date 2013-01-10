package MarsRover;

import java.util.ArrayList;

public class RoverBust {
    private ArrayList<Rover> roverList = new ArrayList<Rover>();

    public void setRovers(ArrayList<Rover> roverList) {
        this.roverList = roverList;
    }

    public ArrayList<Rover> getRovers() {
        return roverList;
    }

    public void addRover(Rover rover) {
        roverList.add(rover);
    }

    public boolean isOutBound(Rover rover) {
        boolean outBound = false;
        String name = rover.getName();
        if (!Plateau.getInstance().isInRange(rover.getPosX(), rover.getPosY())) {
            outBound = true;
        }
        return outBound;
    }

    public boolean checkCrash(Rover rover) {
        boolean doesCrash = false;
        for (Rover roverIn : roverList) {
            if ((!roverIn.getName().equals(rover.getName())) && (roverIn.getPosX() == rover.getPosX())
                    && (roverIn.getPosY() == rover.getPosY())) {
                System.out.println("Caution:  Rover " + rover.getName() + " Crash  Rover " + roverIn.getName() );
                doesCrash = true;
                break;
            }
        }
        return doesCrash;
    }

    public void runRover(Rover rover){
        String instruction = rover.getInstruction();
        for(int index = 0; index < instruction.length(); index ++){
            char command = instruction.charAt(index);
            rover.operation(command);
            if (checkCrash(rover) || isOutBound(rover)) {
                throw new AssertionError();
            }
        }
    }
}

