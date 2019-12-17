package org.firstinspires.ftc.autos;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.subsystems.Drive;

public class VoltageDrive extends Action {

    Drive drive;

    double time;

    OpMode opMode;

    double voltageRight = .5;
    double voltageLeft = .5;

    public VoltageDrive(OpMode mode, double time){
        this.opMode = mode;
        this.time = time;
        drive = Drive.getInstance(opMode.hardwareMap);
    }

    double startTime = 0;

    @Override
    public void start() {
        startTime = opMode.time;
    }

    public void setVoltage(double voltageLeft, double voltageRight){
        this.voltageRight = voltageRight;
        this.voltageLeft = voltageLeft;
    }

    @Override
    public void update() {
        drive.set(voltageLeft, voltageRight);
    }


    @Override
    public boolean isFinished() {
        return opMode.time-startTime > time;
    }

    @Override
    public void done() {
        drive.set(0,0);
    }
}
