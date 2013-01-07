import javax.activation.MailcapCommandMap;
import java.rmi.activation.ActivationGroupDesc;
import java.util.Arrays;
import java.util.List;

public class Rover {
    public static final List<Character> ORIENTATIONS = Arrays.asList('N', 'E', 'S', 'W');

    public static final int INS_LEN = 100;

    private String name = " ";
    private int posX = 0;
    private int posY = 0;
    private char orientation = ' ';
    private String instruction = " ";

    public Rover(int posX, int posY, char orientation) {
        this.posX = posX;
        this.posY = posY;
        setOrientation(orientation);
    }

    public Rover(String name, int posX, int posY, char orientation) {
        this.name = name;
        this.posX = posX;
        this.posY = posY;
        setOrientation(orientation);
    }

    public String getName() {
        return name;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setOrientation(char ori) {
        char orientation = Character.toUpperCase(ori);

        for (char ORIENTATION : ORIENTATIONS) {
            if (orientation == ORIENTATION) {
                this.orientation = orientation;
                return;
            }
        }
        throw new AssertionError();
    }

    public char getOrientation() {
        return orientation;
    }

    public void setInstruction(String insList) {
        if (!insList.isEmpty() && insList.length() < INS_LEN) {
            instruction = insList;
        }
    }

    public String getInstruction() {
        return instruction;
    }

    public boolean isInPlateau(int x, int y) {
        if (!Plateau.getInstance().isInRange(x, y)) {
            System.out.println("Caution " + this.name + " is out of bound ");
            return false;
        }
        return true;
    }

    public void operation(char instruction) throws AssertionError {
        Command  command = CommandFactory.createCommand(this,instruction );
        try{
            command.action();
        }catch (OutOfBoundException e){
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        char ori = getOrientation();
        if (isInPlateau(posX, posY)) {
            return name + ' ' + posX + " " + posY + " " + ori;
        } else {
            return name + ' ' + posX + " " + posY + " " + ori + " RIP";
        }
    }
}
