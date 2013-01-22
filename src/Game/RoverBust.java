package Game;

import java.util.ArrayList;

public class RoverBust {
    private ArrayList<Rover> roverList = new ArrayList<Rover>();

    public void addRover(Rover rover) {
        roverList.add(rover);
    }

    public void checkCrash(Rover rover) {
        for (Rover roverIn : roverList) {
            if ( !(roverIn.hashCode() == rover.hashCode() && roverIn.equals(rover))
                    && (roverIn.getPosX() == rover.getPosX())
                    && (roverIn.getPosY() == rover.getPosY())) {
                System.out.println("Caution:  Rover " + rover.getName() + " Crash  Rover " + roverIn.getName() );
                throw new RuntimeException("Rovers crash each other");
            }
        }
    }

    public void runRover(Rover rover){
        String instruction = rover.getInstruction();
        for(int index = 0; index < instruction.length(); index ++){
            char command = instruction.charAt(index);
            rover.operation(command);
            checkCrash(rover);
        }
    }
}

