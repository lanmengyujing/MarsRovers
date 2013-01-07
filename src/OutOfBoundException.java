/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-1-7
 * Time: 下午5:11
 * To change this template use File | Settings | File Templates.
 */
public class OutOfBoundException extends RuntimeException {

    @Override
    public String getMessage(){
        return "rover out of bound!";
    }

}
