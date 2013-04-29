package com.app.direction;

import com.app.exception.OutOfBoundException;

public interface State {

    public void forward() throws OutOfBoundException;

    public void turnLeft();

    public void turnRight();

    public char orientationName();
}
