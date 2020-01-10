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
        Left = hardwareMap.dcMotor.get("eLeft");

        RightGripper = hardwareMap.servo.get("rightGrip");
        LeftGripper = hardwareMap.servo.get("leftGrip");
        Ee = hardwareMap.dcMotor.get("Ee");//ee's are pulleys and rollers
        eE = hardwareMap.dcMotor.get("eE");
        Hook1 = hardwareMap.servo.get("Hook1");
        Hook2 = hardwareMap.servo.get("Hook2");
    }
    @Override
    public void loop() {
        Right.setPower(-gamepad1.right_stick_y);
        Left.setPower(gamepad1.right_stick_y);

        if (gamepad1.x) {
            Ee.setPower(-1);
            eE.setPower(1);
        }else if (gamepad1.y){
            Ee.setPower(1);
            eE.setPower(-1);
        } else {
            Ee.setPower(0);
            eE.setPower(0);
        }
//        if (gamepad1.right_stick_x)
        if(gamepad1.a){
            RightGripper.setPosition(0);
            LeftGripper.setPosition(1);
        }

        if(gamepad1.b) {
            RightGripper.setPosition(1);
            LeftGripper.setPosition(0);
        }
        if (gamepad1.right_bumper){
            Hook1.setPosition(0);
            Hook2.setPosition(1);
        }
        if (gamepad1.left_bumper){
            Hook2.setPosition(0);
            Hook1.setPosition(1);
        }

        telemetry.addData("leftPos", LeftGripper.getPosition());
        telemetry.addData("rightPos", RightGripper.getPosition());

    }

}
