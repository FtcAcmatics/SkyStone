package org.firstinspires.ftc.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.subsystems.Drive;

@Autonomous (name = "BasicAutoProgram")

public class BasicAutoProgram extends OpMode{

    ActionList actions;
    Drive drive;
    VoltageDrive voltageDrive;
    Action turn;

    @Override
    public void init() {
        voltageDrive = new VoltageDrive(this, 10);
        actions = new ActionList(voltageDrive);
        drive = Drive.getInstance(hardwareMap);
    }

    @Override
    public void loop() {
        actions.run();
    }
}