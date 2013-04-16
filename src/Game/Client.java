package Game;


import Initialization.InitCommand;
import Initialization.InstructionInitialization;
import Initialization.PlaceInitialization;
import Initialization.PlateauInitialization;

public class Client {
    Invoker invoker = new Invoker();

    public void setPlateau(String area) {
        InitCommand initCommand = new PlateauInitialization(area);
        setInstruction(initCommand);
    }

    public void setRoverPlace(String placeStr,Rover rover) {
        InitCommand initCommand = new PlaceInitialization(placeStr, rover);
        setInstruction(initCommand);
    }

    public void setRoverInstruction(String instruction, Rover rover) {
        InitCommand initCommand = new InstructionInitialization(instruction, rover);
        setInstruction(initCommand);
    }

    private void setInstruction(InitCommand initCommand) {
        invoker.setInitCommand(initCommand);
        invoker.initialize();
    }
}
