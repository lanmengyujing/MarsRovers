package command;

import MarsRover.Rover;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-1-7
 * Time: 下午8:15
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractFactory {

    public static AbstractFactory getInstance(char instruction) {
        String className = new StringBuilder().append("command.").append(instruction).append("CommandFactory").toString();
        AbstractFactory factory = null;
        try {
            Class factoryClass = Class.forName(className);
            factory = (AbstractFactory) factoryClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return factory;
    }

    public abstract Command createCommand(Rover rover);

}
