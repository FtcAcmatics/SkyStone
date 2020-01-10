package org.firstinspires.ftc.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous (name="eAutoBlueTriangle")

public class eAutoBlueTriangle extends OpMode {

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
        /*switch(state){
            case -1:
                startTime =time;
                state=0;
                break;
            case 0:
                posControl.setSetpoint(5);
                if (posControl.getError()<0.1){
                    state=1;
                }
                break;
            case 1:
                angleControl.setSetpoint(90);
                if (posControl.getError()<0.1){
                    state=2;
                }
                break;
            case 2:
                Right.setPower(0);
                Left.setPower(0);
        }*/
    }
}
