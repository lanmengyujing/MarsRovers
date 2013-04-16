package exception;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/16/13
 * Time: 10:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class CrashException extends GameException {
    @Override
    public String getMessage(){
        return "Rovers crash each other";
    }
}
