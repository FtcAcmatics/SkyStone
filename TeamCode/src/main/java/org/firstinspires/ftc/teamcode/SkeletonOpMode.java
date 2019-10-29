package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;

@TeleOp(name = "simple op mode", group = "Training")

//@Disabled
public class SkeletonOpMode extends OpMode {

    DcMotor leftMotor1, leftMotor2;
    DcMotor rightMotor1, rightMotor2;
    double mult;

    @Override
    public void init() {
        leftMotor1 = hardwareMap.dcMotor.get("Left 1");
        leftMotor2 = hardwareMap.dcMotor.get("Left 2");

        rightMotor1 = hardwareMap.dcMotor.get("Right 1");
        rightMotor2 = hardwareMap.dcMotor.get("Right 2");
        rightMotor1.setDirection(DcMotorSimple.Direction.REVERSE);
        rightMotor2.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void start() {
    }

    @Override
    public void loop() {
        if (gamepad1.right_bumper) {
            mult = 0.5;
        } else {
            mult = 1.0;
        }

        leftMotor1.setPower(mult * gamepad1.left_stick_y);
        leftMotor2.setPower(mult * gamepad1.left_stick_y);
        rightMotor1.setPower(mult * gamepad1.right_stick_y);
        rightMotor2.setPower(mult * gamepad1.right_stick_y);

        telemetry.addData("leftMotor1Enc", leftMotor1.getCurrentPosition());
        telemetry.addData("leftMotor2Enc", leftMotor2.getCurrentPosition());
        telemetry.addData("rightMotor1Enc", rightMotor1.getCurrentPosition());
        telemetry.addData("rightMotor2Enc", rightMotor2.getCurrentPosition());
    }

    @Override
    public void stop() {
    }
}
