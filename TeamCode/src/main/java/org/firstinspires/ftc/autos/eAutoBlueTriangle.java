package org.firstinspires.ftc.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.teamcode.TriangleMotionProfile;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.PID;

@Autonomous (name="eAutoBlueTriangle")

public class eAutoBlueTriangle extends OpMode {
    //final double ticksToDistance = 0.00321035374941922699419*e; //inches
    final double distanceBetweenWheels = 12; //inches

    DcMotor Right;
    DcMotor Left;
    Servo RightGripper;
    Servo LeftGripper;
    Servo Hook1;
    Servo Hook2;

    DcMotor Ee;
    DcMotor eE;

    PID angleControl;
    PID posControl;

    PID pid;

    TriangleMotionProfile posProfile;

    int state = 0;
    double startTime;
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
        pid = new PID(0.7, 0.1);
    }

    @Override
    public void loop() {
        telemetry.addData("time",time-startTime);

//        telemetry.addData("powerRight", Right.getPower());
//        telemetry.addData("powerLeft", Left.getPower());
        switch(state){
            case 0:
                startTime =time;
                state=0;
                break;
            case 1:



        }
    }
}
