package Game;


import Initialization.InitCommand;
import Initialization.InstructionInitialization;
import Initialization.PlaceInitialization;
import Initialization.PlateauInitialization;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-1-19
 * Time: 下午10:02
 * To change this template use File | Settings | File Templates.
 */
public class Client {
    Invoker invoker = new Invoker();

    public void setPlateau(String area){
        InitCommand initCommand = new PlateauInitialization(area);
        invoker.setInitCommand(initCommand);
        invoker.initialize();
    }

    public void setRoverPlace(String placeStr,Rover rover){
        InitCommand initCommand = new PlaceInitialization(placeStr, rover);
        invoker.setInitCommand(initCommand);
        invoker.initialize();
    }

    public void setRoverInstruction(String instruction, Rover rover){
        InitCommand initCommand = new InstructionInitialization(instruction, rover);
        invoker.setInitCommand(initCommand);
        invoker.initialize();
    }
}
