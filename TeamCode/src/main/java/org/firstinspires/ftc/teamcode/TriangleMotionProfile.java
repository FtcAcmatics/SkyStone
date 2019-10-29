package org.firstinspires.ftc.teamcode;

public class TriangleMotionProfile {
    double a, d, t1;

    public TriangleMotionProfile(double a, double d){
        this.a=a;
        this.d=d;
        t1=Math.sqrt(d/a);
    }

    public double calcPosition(double time){
        if(time < 0){
            return 0;
        }else if(time > 2*t1){
            return d;
        }
        if (time<t1){
            return ((a*time*time)/2);
        }else {
            return (-a/2)*time*time-2*a*t1*time;
        }
    }
    public double calcVel(double time){
        if (time<t1){
            return a*time;
        }else{
            return -a*(time-2*t1);
        }
    }
}