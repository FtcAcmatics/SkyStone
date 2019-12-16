package org.firstinspires.ftc.autos;

public abstract class Action {
    public Action next = null;

    public abstract void start(); // runs when the action starts
    public abstract void update(); // runs while the action updates
    public abstract boolean isFinished(); // determines when the action is finished updating
    public abstract void done(); // runs when the action is done
}
