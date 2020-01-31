package org.firstinspires.ftc.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.PID;

@Autonomous(name = "AutoDriveForward")

public class AutoDriveForward extends OpMode {

    DcMotor Right;
    DcMotor Left;

    /*
    public double getTime() {
        return time;
    }
     */

    int state = 1;
    double startTime;
    @Override
    public void init() {
        Right = hardwareMap.dcMotor.get("eRight");
        Left = hardwareMap.dcMotor.get("eLeft");

    }

    @Override
    public void loop() {
        startTime = time;
        if (time > 5 && time < 7){
        Left.setPower(-0.5);
        Right.setPower(.5);
        }
        if (time > 7){
            Right.setPower(0);
            Left.setPower(0);
        }
    }
}