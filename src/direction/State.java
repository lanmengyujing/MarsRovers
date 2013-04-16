package direction;

public interface State {

    public void forward();

    public void turnLeft();

    public void turnRight();

    public char orientationName();
}
