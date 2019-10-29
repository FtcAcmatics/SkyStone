package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="DriveRobot", group = "Training")
public class DriveRobot extends OpMode {

    DcMotor left1, left2;
    DcMotor right1, right2;
    double setpoint = 100;

    @Override
    public void init() {
        left1 = hardwareMap.dcMotor.get("Left 1");
        left2 = hardwareMap.dcMotor.get("Left 2");
        right1 = hardwareMap.dcMotor.get("Right 1");
        right2 = hardwareMap.dcMotor.get("Right 2");
    }

    @Override
    public void start() {
    }
    double errorIntegral = 0;
    double changeInTime = 0.01;
    @Override
    public void loop() {
        double sensorRight = right2.getCurrentPosition();
        // to output: motor.setPower(percentage)
        double error= setpoint-sensorRight;
        errorIntegral += error*changeInTime;
        double kp=0.12;
        double ki=0.06;
        double voltage=error*kp+ki*errorIntegral;
        right2.setPower(voltage/12);
        right1.setPower(voltage/12);
        telemetry.addData("sensorRight", sensorRight);
        telemetry.addData("error", error);
        telemetry.addData("voltage", voltage);
    }

    @Override
    public void stop() {
    }
}
