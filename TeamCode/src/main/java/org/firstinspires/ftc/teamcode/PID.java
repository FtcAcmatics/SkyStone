package org.firstinspires.ftc.teamcode;

public class PID {
    double kp;
    double kd;
    double setpoint;
    double psensor;
    double error;
    public PID(double p, double d){
        kp=p;
        kd=d;
    }

    public void setSetpoint(double setpoint){
        this.setpoint = setpoint;
    }

    public double run(double sensorValue){
        error=setpoint-sensorValue;
        double output;
        if(!Double.isNaN(psensor)){
            double vel = (sensorValue-psensor)/.005;
            output=kp*error-kd*vel;
        }else{
            output = kp*error;
        }
        psensor=sensorValue;
        return output;
    }
    public double getError(){
        return error;
    }
}
