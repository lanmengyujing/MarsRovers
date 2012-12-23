import java.util.Arrays;
import java.util.List;

public class Rover {
    public static final List<Character> ORIENTATIONS = Arrays.asList('N', 'E', 'S', 'W');

    public static final int INS_LEN = 100;

    private String m_name = " ";
    private int m_PosX = 0;
    private int m_PosY = 0;
    private char m_Orientation = ' ';
    private String m_Instruction = " ";

    public Rover(int posX, int posY, char orientation) {
        m_PosX = posX;
        m_PosY = posY;
        setOrientation(orientation);

    }

    public Rover(String name, int posX, int posY, char orientation) {
        m_name = name;
        m_PosX = posX;
        m_PosY = posY;
        setOrientation(orientation);

    }

    public String getName() {
        return m_name;
    }

    public int getPosX() {
        return m_PosX;
    }

    public int getPosY() {
        return m_PosY;
    }

    private void setOrientation(char ori) {
        char orientation = Character.toUpperCase(ori);

        for (char ORIENTATION : ORIENTATIONS) {
            if (orientation == ORIENTATION) {
                m_Orientation = orientation;
                return;
            }
        }
        throw new AssertionError();
    }

    public char getOrientation() {
        return m_Orientation;
    }

    public void setInstruction(String insList) {
        if (!insList.isEmpty() && insList.length() < INS_LEN) {
            m_Instruction = insList;
        }
    }

    public String getInstruction() {
        return m_Instruction;
    }

    public boolean isInPlateau(int x, int y) {
        if (!Plateau.getInstance().isInRange(x, y)) {
            System.out.println("Caution" + this.m_name + " is out of bound ");
            return false;
        }
        return true;
    }

    public void operation(char instruction) throws AssertionError {
        switch (instruction) {
            case 'L':
            case 'l':
                turnLeft();
                break;
            case 'R':
            case 'r':
                turnRight();
                break;
            case ' ':
                break;
            case 'M':
            case 'm':
                moveForward();
                break;
            default:
                throw new AssertionError();

        }
    }

    private void moveForward() throws AssertionError {

        switch (this.getOrientation()) {
            case 'N':
            case 'n':

                if (!isInPlateau(m_PosY + 1, m_PosX)) {
                    return;
                }
                m_PosY += 1;
                break;
            case 'E':
            case 'e':
                if (!isInPlateau(m_PosX + 1, m_PosY)) {
                    return;
                }
                m_PosX += 1;
                break;
            case 'S':
            case 's':
                if (!isInPlateau(m_PosY - 1, m_PosX)) {
                    return;
                }
                m_PosY -= 1;
                break;
            case 'W':
            case 'w':
                if (!isInPlateau(m_PosX - 1, m_PosY)) {
                    return;
                }
                m_PosX -= 1;
                break;
            default:
                throw new AssertionError();

        }
    }

    private void turnLeft() {
        int index = ORIENTATIONS.indexOf(m_Orientation);
        index = (index + ORIENTATIONS.size() - 1) % ORIENTATIONS.size();
        m_Orientation = ORIENTATIONS.get(index);
    }

    private void turnRight() {
        int index = ORIENTATIONS.indexOf(m_Orientation);
        index = (index + 1) % ORIENTATIONS.size();
        m_Orientation = ORIENTATIONS.get(index);
    }

    @Override
    public String toString() {
        char ori = getOrientation();
        if (isInPlateau(m_PosX, m_PosY)) {
            return m_name + ' ' + m_PosX + " " + m_PosY + " " + ori;
        } else {
            return m_name + ' ' + m_PosX + " " + m_PosY + " " + ori + " RIP";
        }
    }
}
