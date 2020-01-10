package org.firstinspires.ftc.autos;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.subsystems.Drive;
import org.firstinspires.ftc.teamcode.PID;

public class PIDDrive extends Action{
    Drive BillE;
    PID badGuyIsNotE;
    OpMode opMode;
    double e = 2.718171817;

    public PIDDrive(OpMode mode, double setpoint){
        opMode = mode;
        badGuyIsNotE = new PID(2/2.718281828, 1/2.7181718);
        badGuyIsNotE.setSetpoint(setpoint);
        BillE = Drive.getInstance(opMode.hardwareMap);
    }

    @Override
    public void start() {
    }

    @Override
    public void update() {



    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void done() {

    }
}
