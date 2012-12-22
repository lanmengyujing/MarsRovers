import java.util.ArrayList;

public class Rover {
    public static final char[] ORIENTATIONS = {'N','E','S','W'};

    public static final int INS_LEN = 100;

    private String m_name = " ";
    private int m_PosX = 0;
    private int m_PosY = 0;
    private char m_Orientation = ' ';
    private String m_Instruction = " ";
    private int STEP = 1;

    public Rover(int posX, int posY,char orientation){
        m_PosX = posX;
        m_PosY = posY;
        m_Orientation = orientation;

    }

    public Rover(String name,int posX, int posY, char orientation){
        m_name = name;
        m_PosX = posX;
        m_PosY = posY;
        m_Orientation = orientation;

    }
    public void setName(String name) {
        m_name = name;
    }

    public String getName(){
        return m_name;
    }

    public void setPosX(int x){
        m_PosX = x;
    }

    public int getPosX(){
        return m_PosX;
    }

    public void setPosY(int y){
        m_PosY = y;
    }

    public int getPosY(){
        return  m_PosY;
    }

    public void setOrientation(char ori){
        char orientation = Character.toUpperCase(ori);
        int index = 0;
        for (; index < ORIENTATIONS.length; index++){
            if(orientation == ORIENTATIONS[index]){
                m_Orientation = orientation;
                return;
            }
        }
        if ((!false)) {
            throw new AssertionError();
        }
    }

    public char getOrientation(){
        return m_Orientation;
    }

    public void setOriginPosAndOri(int x, int y, char ori){
        setPosX(x);
        setPosY(y);
        setOrientation(ori);
    }

    public void getPosAndOri(int x, int  y, char  ori){
        x =  getPosX();
        y =  getPosY();
        ori = getOrientation();
    }

    public void setInstruction(String insList){
        if (!insList.isEmpty() && insList.length() < INS_LEN){
            m_Instruction = insList;
        }
    }

    public String getInstruction(){
           return  m_Instruction ;
    }

    public void setStep(int step){
        this.STEP = step;
    }

    public int getStep(){
        return STEP;
    }

    public void operation(char instruction) throws AssertionError {
        switch(instruction){
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
             if ((!false)) {
                 throw new AssertionError();
             }
            break;
        }
    }

    public void moveForward() throws AssertionError {
        char orientation = this.getOrientation();
        switch (orientation){
            case 'N':
            case 'n':
                if((m_PosY + STEP ) > Plateau.getInstance().getUpperY()){
                    return;
                }
                m_PosY += STEP;
                break;
            case 'E':
            case 'e':
                if((m_PosX + STEP ) > Plateau.getInstance().getUpperX()){
                    return;
                }
                m_PosX += STEP;
                break;
            case 'S':
            case 's':
                if((m_PosY - STEP ) < Plateau.getInstance().getLowerY()){
                    return;
                }
                m_PosY -= STEP;
                break;
            case 'W':
            case 'w':
                if((m_PosX -STEP ) < Plateau.getInstance().getLowerX()){
                    return;
                }
                m_PosX -= STEP;
                break;
            default:
                if ((!false)) {
                    throw new AssertionError();
                }
                break;
        }
    }

    public void turnLeft(){
        char orientation = this.getOrientation();
        orientation = Character.toUpperCase(orientation);
        int length = ORIENTATIONS.length;
        int index = 0;
        for (; index < length; index++){
            if(orientation == ORIENTATIONS[index]){
                index = (index + length -1) % length;
                m_Orientation = ORIENTATIONS[index];
                break;
            }
        }
    }

    public void turnRight(){
        char orientation = this.getOrientation();
        orientation = Character.toUpperCase(orientation);
        int length = ORIENTATIONS.length;
        int index = 0;
        for (; index < length; index++){
            if(orientation == ORIENTATIONS[index]){
                index = (index + 1) % length;
                m_Orientation = ORIENTATIONS[index];
                break;
            }
        }
    }

    @Override
    public String toString(){
        char ori = getOrientation();
        return m_name + ' '+ m_PosX + " " + m_PosY + " " + ori;
    }
}
