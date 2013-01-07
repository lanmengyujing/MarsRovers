/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-1-7
 * Time: 下午4:41
 * To change this template use File | Settings | File Templates.
 */
public class LCommand extends Command {
    public  LCommand(Rover rover){
        super(rover);
    }

    @Override
    public void action() {
        char orientation = rover.getOrientation();
        int index = Rover.ORIENTATIONS.indexOf(orientation);
        index = (index + Rover.ORIENTATIONS.size() - 1) % Rover.ORIENTATIONS.size();
        orientation = Rover.ORIENTATIONS.get(index);
        rover.setOrientation(orientation);
    }
}
