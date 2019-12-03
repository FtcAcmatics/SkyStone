package org.firstinspires.ftc.teamcode;

//trying to code trapezoidal motion
//notes in Andrew's black comp nb(towards the back-ish)
public class TrapezoidalMotionProfile {
    double d, t;
    double d1, d2, d3;
    double timeState = t/3;
    double maxVel;
    public TrapezoidalMotionProfile(double d, double t){
        this.d = d;
        this.t = t;
    }
    public void calcDist(){
        d1 = d/4;
        d2 = d/2;
        d3 = d/4;
    }
    public void calMaxVel(){
        maxVel = 1.5*(d/t);
    }
    public void calcAccel3rdPart(){
        double acc3 = -maxVel/d3-d2;
    }
}
