package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "AutoA3")
public class AutoA3 extends OpMode {
    Servo RightGripper;
    Servo LeftGripper;
    @Override
    public void init() {
        RightGripper = hardwareMap.servo.get("rightGrip");
        LeftGripper = hardwareMap.servo.get("leftGrip");
    }

    @Override
    public void loop() {
        RightGripper.setPosition(0.5);
        LeftGripper.setPosition(0.5);
    }
}
