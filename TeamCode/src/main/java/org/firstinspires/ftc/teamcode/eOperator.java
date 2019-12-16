package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="eOperator")
public class eOperator extends OpMode {
    DcMotor Right;
    DcMotor Left;

    Servo RightGripper;
    Servo LeftGripper;
    Servo Hook1;
    Servo Hook2;

    DcMotor Ee;
    DcMotor eE;

    @Override
    public void init() {
        Right = hardwareMap.dcMotor.get("eRight");
        Left= hardwareMap.dcMotor.get("eLeft");
        RightGripper = hardwareMap.servo.get("rightGrip");
        LeftGripper = hardwareMap.servo.get("leftGrip");
        Ee = hardwareMap.dcMotor.get("Ee");//ee's are pulleys and rollers ???
        eE = hardwareMap.dcMotor.get("eE");
        Hook1 = hardwareMap.servo.get("Hook1");
        Hook2 = hardwareMap.servo.get("Hook2");
    }
    @Override
    public void loop() {
        double LeftOutput =-gamepad1.left_stick_y;
        double RightOutput = gamepad1.right_stick_y;
        Left.setPower(LeftOutput);
        Right.setPower(RightOutput);
        Hook1.setPosition(190); //right
        Hook2.setPosition(-190); //left
        if (gamepad1.x) {
            Ee.setPower(1);
            eE.setPower(1);
        }
        else {
            Ee.setPower(0);
            eE.setPower(0);
        }
        if(gamepad1.a){
            RightGripper.setPosition(0.5);
            LeftGripper.setPosition(0.5);
        }

        if(gamepad1.b) {
            RightGripper.setPosition(1);
            LeftGripper.setPosition(1);
        }
        if (gamepad1.right_bumper){
            Hook1.setPosition(190);
            Hook2.setPosition(-190);
        }
        if (gamepad1.left_bumper){
            Hook2.setPosition(-90);
            Hook1.setPosition(90);
        }

        telemetry.addData("leftPos", LeftGripper.getPosition());
        telemetry.addData("rightPos", RightGripper.getPosition());

    }

}
