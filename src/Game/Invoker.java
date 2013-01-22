package Game;

import Initialization.InitCommand;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-1-19
 * Time: 下午9:56
 * To change this template use File | Settings | File Templates.
 */
public class Invoker {
    InitCommand initCommand;
    public void setInitCommand(InitCommand initCommand){
        this.initCommand = initCommand;
    }

    public void initialize(){
        initCommand.configure();
    }
}
