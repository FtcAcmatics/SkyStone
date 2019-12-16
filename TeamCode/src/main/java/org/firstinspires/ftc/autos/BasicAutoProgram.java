package org.firstinspires.ftc.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous (name = "BasicAutoProgram")

public class BasicAutoProgram extends OpMode{

    DcMotor Right;
    DcMotor Left;


    @Override
    public void init() {
        Right = hardwareMap.dcMotor.get ("eRight");
        Left = hardwareMap.dcMotor.get ("eLeft");
    }

    @Override
    public void loop() {

    }
}