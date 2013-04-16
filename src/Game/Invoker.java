package Game;

import Initialization.InitCommand;
import exception.GameException;

public class Invoker {
    InitCommand initCommand;
    public void setInitCommand(InitCommand initCommand){
        this.initCommand = initCommand;
    }

    public void initialize(){
        try{
            initCommand.configure();
        }catch (GameException e){
            System.out.println(e.getMessage());
        }
    }
}
