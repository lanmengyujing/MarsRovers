package com.app.direction;

import com.app.exception.OutOfBoundException;

public interface State {

    public void forward() throws OutOfBoundException;

    public State turnLeft();

    public State turnRight();

    public char orientationName();
}
