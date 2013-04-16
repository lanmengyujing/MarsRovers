package exception;

public class OutOfBoundException extends GameException {

    @Override
    public String getMessage(){
        return "rover out of bound!";
    }

}
