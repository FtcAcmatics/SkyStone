package org.firstinspires.ftc.autos;

public abstract class Action {
    public Action next = null;

    public abstract void start();
    public abstract void update();
    public abstract boolean isFinished();
    public abstract void done();
}
