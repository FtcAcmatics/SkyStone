package org.firstinspires.ftc.autos;

public class ActionList {
    Action root = null;
    Action current = null;
    Action last = null;
    private boolean ranStart = false;
    public ActionList (Action root){
        this.root = root;
        current = root;
        last = root;
    }
    public void add(Action newAction){
        last.next = newAction;
        last = newAction;
    }
    public void reset(){
        current = root;
        ranStart = false;
    }
    public void run(){
        if(current == null){
            return;
        }
        if (!ranStart){
            current.start();
            ranStart = true;
        }
        current.update();
        if (current.isFinished()){
            current.done();
            current = current.next;
            ranStart = false;
        }


    }
}
