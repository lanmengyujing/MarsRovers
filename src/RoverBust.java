import java.util.ArrayList;

public class RoverBust {
    private int m_rangeX = 0;
    private int m_rangeY = 0;

    private boolean m_bInstructionValid = true;//输入指令是否有误
    private boolean m_bOutBound = false;//是否出界
    private boolean m_bCrash = false;//是否冲撞

    private ArrayList<Rover> roverList = new ArrayList<Rover>();

    public RoverBust(int rangeX, int rangeY ){
        m_rangeX = rangeX;
        m_rangeY = rangeY;
    }

    public RoverBust(int rangeX, int rangeY,ArrayList<Rover> roverList){
        m_rangeX = rangeX;
        m_rangeY = rangeY;
        this.roverList = roverList;
    }

    public void setRange(int x, int y){
        setRangeX(x);
        setRangeY(y);
    }

    private void setRangeX (int x){
        if (x > 0){
            m_rangeX = x;
        }
        else{
            System.out.println("Caution: The Input Range for Y is not valid!");
        }
    }

    private void setRangeY (int y){
        if (y > 0){
            m_rangeY = y;
        }
        else{
            System.out.println("Caution: The Input Range for Y is not valid!");
        }
    }

    public int getRangeX() {
        return m_rangeX;
    }

    public int getRangeY() {
        return m_rangeY;
    }

    public void setRovers(ArrayList<Rover> roverList) {
        this.roverList = roverList;
    }

    public ArrayList<Rover>  getRovers() {
        return roverList;
    }

    public boolean isOutBound(Rover rover){
        int x = rover.getPosX();
        int y = rover.getPosY();
        char ori = rover.getOrientation();
        String name = rover.getName();
        if(x > m_rangeX ||x < 0|| y > m_rangeY ||y < 0){
            m_bOutBound = true;
            System.out.println("Caution: " + name +" Out of bound!");
            return true;
        }
        return false;
    }

    public boolean isInstructionValid(String instrcution ){
        for(int i = 0; i < instrcution.length();i++){
            char ins = instrcution.charAt(i);
            if ( !('L' == ins|| 'l' == ins || 'R' == ins
                  || 'r' ==ins || 'M' == ins|| 'm' == ins)){
                System.out.println("The instruction is unvalid!");
                m_bInstructionValid = false;
                return false;
            }
        }
        return true;
    }

    public boolean checkCrash(Rover rover){
        for(Rover roverIn : roverList ) {
         if ( (! roverIn.getName().equals(rover.getName())) && (roverIn.getPosX() == rover.getPosX())
                 && (roverIn.getPosY() == rover.getPosY())) {
                System.out.println("Caution: Rovers Crash!");
                m_bCrash = true;
                return true;
         }
        }
        return false;
    }

    public  void startMoving(){
        for (Rover rover : roverList ) {
            String instr = rover.getInstruction();
            if (null == instr){
                return;
            }else{
                for(int i = 0; i <  instr.length();i++){
                    char command =   instr.charAt(i);
                    rover.operation(command);
                    m_bCrash = checkCrash(rover);
                    m_bOutBound = isOutBound(rover);
                    if (m_bCrash||m_bOutBound){
                        if ((!false)) {
                            throw new AssertionError();
                        }
                        return;
                    }
                }
            }
        }
    }

    public void  outPutRoverPosAndOrientation(){
        for(Rover rover : roverList){
            System.out.println(rover);
        }
    }

}

