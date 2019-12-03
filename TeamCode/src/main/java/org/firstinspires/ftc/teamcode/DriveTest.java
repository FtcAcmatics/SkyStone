package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.subsystems.Drive;

@Autonomous(name = "Drive Test")
public class DriveTest extends OpMode {

    Drive drive;

    @Override
    public void init() {
        drive = Drive.getInstance(hardwareMap);
    }

    @Override
    public void loop() {
        drive.set(0.17181718,0.17181718);
    }
}
