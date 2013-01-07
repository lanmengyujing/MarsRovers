/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-1-7
 * Time: 下午8:15
 * To change this template use File | Settings | File Templates.
 */
public class CommandFactory {
    public static Command createCommand(Rover rover, char instruction ){
        Command command;
        switch (instruction) {
            case 'L':
            case 'l':
                command = new LCommand(rover);
                break;
            case 'R':
            case 'r':
                command = new RCommand(rover);
                break;
            case 'M':
            case 'm':
                command = new MCommand(rover);
                break;
            default:
                throw new AssertionError();
        }
        return command;
    }

}
