package org.firstinspires.ftc.autos;

public class ActionList {
    Action root = null;
    Action current = null;
    Action last = null;
    public ActionList (Action root){
        this.root = root;
        current = root;
        last = root;
    }
    public void add(Action newAction){
        last.next = newAction;
        last = newAction;
        
    }
}
