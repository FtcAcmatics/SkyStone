package org.firstinspires.ftc.autos;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.PID;

@Autonomous (name="autoA1")
public class autoA1 extends OpMode {
    DcMotor Right;
    DcMotor Left;
    Servo RightGripper;
    Servo LeftGripper;
    Servo Hook1;
    Servo Hook2;

    DcMotor Ee;
    DcMotor eE;

    PID pid;
    @Override
    public void init() {
        Right = hardwareMap.dcMotor.get("eRight");
        Left = hardwareMap.dcMotor.get("eLeft");

        RightGripper = hardwareMap.servo.get("rightGrip");
        LeftGripper = hardwareMap.servo.get("leftGrip");
        Ee = hardwareMap.dcMotor.get("Ee");//ee's are pulleys and rollers
        eE = hardwareMap.dcMotor.get("eE");
        Hook1 = hardwareMap.servo.get("Hook1");
        Hook2 = hardwareMap.servo.get("Hook2");
        pid = new PID(1,0.2);
        pid.setSetpoint(10);// distance in inches

    }

    @Override
    public void loop() {
        double avePos = (Right.getCurrentPosition() + Left.getCurrentPosition())/2;// get avg position of the motors

        double output = pid.run(avePos);// calculates the output from PID numbers
        Right.setPower(output);
        Left.setPower(output);
    }
}
