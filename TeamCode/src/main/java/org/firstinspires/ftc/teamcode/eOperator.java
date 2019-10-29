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
    DcMotor Ee;
    DcMotor eE;

    @Override
    public void init() {
        Right = hardwareMap.dcMotor.get("eRight");
        Left= hardwareMap.dcMotor.get("eLeft");
        RightGripper = hardwareMap.servo.get("rightGrip");
        LeftGripper = hardwareMap.servo.get("leftGrip");
        Ee = hardwareMap.dcMotor.get("Ee");
        eE = hardwareMap.dcMotor.get("eE");
    }

    @Override
    public void loop() {
        double LeftOutput =-gamepad1.left_stick_y;
        double RightOutput = gamepad1.right_stick_y;
        Left.setPower(LeftOutput);
        Right.setPower(RightOutput);
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

        telemetry.addData("leftPos", LeftGripper.getPosition());
        telemetry.addData("rightPos", RightGripper.getPosition());

    }

}
