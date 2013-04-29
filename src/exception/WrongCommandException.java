package exception;


public class WrongCommandException extends GameException {
    @Override
    public String getMessage(){
        return "The input commands for rover are not valid!";
    }
}
