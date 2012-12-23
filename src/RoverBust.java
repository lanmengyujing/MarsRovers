import java.util.ArrayList;

public class RoverBust {
    private boolean m_bOutBound = false;//是否出界
    private boolean m_bCrash = false;//是否冲撞

    private ArrayList<Rover> roverList = new ArrayList<Rover>();

    public void setRovers(ArrayList<Rover> roverList) {
        this.roverList = roverList;
    }

    public ArrayList<Rover> getRovers() {
        return roverList;
    }

    public boolean isOutBound(Rover rover) {
        int x = rover.getPosX();
        int y = rover.getPosY();
        String name = rover.getName();
        if (!Plateau.getInstance().isInRange(x, y)) {
            m_bOutBound = true;
            System.out.println("Caution: " + name + " Out of bound!");
            return true;
        }
        return false;
    }

    public boolean isInstructionValid(String instrcution) {
        for (int i = 0; i < instrcution.length(); i++) {
            char ins = instrcution.charAt(i);
            if (!('L' == ins || 'l' == ins || 'R' == ins
                    || 'r' == ins || 'M' == ins || 'm' == ins)) {
                System.out.println("The instruction is unvalid!");
                return false;
            }
        }
        return true;
    }

    public boolean checkCrash(Rover rover) {
        for (Rover roverIn : roverList) {
            if ((!roverIn.getName().equals(rover.getName())) && (roverIn.getPosX() == rover.getPosX())
                    && (roverIn.getPosY() == rover.getPosY())) {
                System.out.println("Caution:" + rover.getName() + " Rover Crash " + roverIn.getName() + " Rover");
                m_bCrash = true;
                break;
            }
        }
        return m_bCrash;
    }

    public void startMoving() {
        for (Rover rover : roverList) {
            String instr = rover.getInstruction();
            if (null == instr) {
                return;
            } else {
                for (int i = 0; i < instr.length(); i++) {
                    char command = instr.charAt(i);
                    rover.operation(command);
                    m_bCrash = checkCrash(rover);
                    m_bOutBound = isOutBound(rover);
                    if (m_bCrash || m_bOutBound) {
                        return;
                    }
                }
            }
        }
    }

}

