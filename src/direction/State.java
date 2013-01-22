package direction;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-1-7
 * Time: 下午10:24
 * To change this template use File | Settings | File Templates.
 */
public interface State {

    public void forward();

    public void turnLeft();

    public void turnRight();

    public char orientationName();
}
