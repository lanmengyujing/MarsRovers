/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-1-7
 * Time: 下午5:00
 * To change this template use File | Settings | File Templates.
 */
public class MCommand extends Command {
    public MCommand(Rover rover) {
        super(rover);
    }

    @Override
    public void action() throws OutOfBoundException {
        int posX = rover.getPosX();
        int posY = rover.getPosY();
        switch (rover.getOrientation()) {
            case 'N':
            case 'n':
                if (!Plateau.getInstance().isInRange(posX,posY + 1 )){
                    throw new OutOfBoundException();
                }
                posY += 1;
                break;
            case 'E':
            case 'e':
                if (!Plateau.getInstance().isInRange(posX + 1, posY)) {
                    throw new OutOfBoundException();
                }
                posX += 1;
                break;
            case 'S':
            case 's':
                if (!Plateau.getInstance().isInRange(posX, posY - 1)) {
                    throw new OutOfBoundException();
                }
                posY -= 1;
                break;
            case 'W':
            case 'w':
                if (!Plateau.getInstance().isInRange(posX - 1, posY)) {
                    throw new OutOfBoundException();
                }
                posX -= 1;
                break;
            default:
                throw new AssertionError();
        }
        rover.setPosX(posX);
        rover.setPosY(posY);
    }
}
