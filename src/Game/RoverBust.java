package Game;

import exception.CrashException;
import exception.GameException;
import exception.OutOfBoundException;

import java.util.ArrayList;

public class RoverBust {
    private ArrayList<Rover> roverList = new ArrayList<Rover>();

    public void addRover(Rover rover) {
        roverList.add(rover);
    }

    public void checkCrash(Rover rover) throws CrashException {
        for (Rover roverIn : roverList) {
            if ( !(roverIn.hashCode() == rover.hashCode() && roverIn.equals(rover))
                    && (roverIn.getPosX() == rover.getPosX())
                    && (roverIn.getPosY() == rover.getPosY())) {
                System.out.println("Caution:  Rover " + rover.getName() + " Crash  Rover " + roverIn.getName() );
                throw new CrashException();
            }
        }
    }

    public void runRover(Rover rover) {
        String instruction = rover.getInstruction();
        for(int index = 0; index < instruction.length(); index ++){
            char command = instruction.charAt(index);
            try {
                rover.operation(command);
            } catch (OutOfBoundException e) {
                System.out.println(e.getMessage());
            }
            try{
                checkCrash(rover);
            }catch (GameException e){
                System.out.println(e.getMessage());
            }
        }
    }
}

