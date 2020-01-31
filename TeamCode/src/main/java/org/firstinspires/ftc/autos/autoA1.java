package org.firstinspires.ftc.autos;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.PID;

@Autonomous (name="autoA1")
public class autoA1 extends OpMode {
    DcMotor Right;
    DcMotor Left;
    Servo RightGripper;
    Servo LeftGripper;
    Servo Hook1;
    Servo Hook2;

    DcMotor Ee;
    DcMotor eE;
    PID pid;

    int state = 1;
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
        pid = new PID(0.5,0.0);
        pid.setSetpoint(32);// distance+e in inches
    }

    @Override
    public void loop() {
        double avePos = (-Right.getCurrentPosition() + Left.getCurrentPosition())/2;// get avg position of the motors

        double output = pid.run(avePos);// calculates the output from PID numbers
        //Right.setPower(0.5);
        //Left.setPower(-0.5);

       switch (state){
           case 1:
               startTime = time;
               state = 2;
               break;
           case 2:
               Right.setPower(0.5);
               Left.setPower(-0.5);
               if (time > 3 ){
                   Left.setPower(0);
                   Right.setPower(0);
                   state = 3;
               }
               break;
           case 3:
               RightGripper.setPosition(0.75);
               LeftGripper.setPosition(0.75);
               state = 4;
               break;
           case 4:
               startTime = time;
               state = 5;
               break;
           case 5:
               Right.setPower(-0.5);
               Left.setPower(0.5);
               if (time > 2) {
                   Right.setPower(0);
                   Left.setPower(0);
                   state = 6;
               }
               break;
           case 6:
               Right.setPower(.5);
               Left.setPower(.5);
               if (time > 4){
                   Right.setPower(0);
                   Left.setPower(0);
                   state = 7;
               }
               break;
           case 7:
               Right.setPower(.5);
               Left.setPower(-.5);
               if (time > 9){
                   Right.setPower(0);
                   Left.setPower(0);
                   state = 8;
               }
               break;

       }




   }
}

       /*switch (state){
            case 1: //Starting the clock
                startTime = time;
                state = 101;
                break;
            case 101: //setting pos of grippers
                RightGripper.setPosition(0.25); // Theta of right is |1-(thetaleft)|
                LeftGripper.setPosition(0.75);
                state=2;
                break;
            case 2:  // Going Forward
                Right.setPower(0.5);
                Left.setPower(-0.5);
                if (time > 3 ){  //dif =2.7
                    Left.setPower(0);
                    Right.setPower(0);
                    state = 3;
                }
                break;
            case 3:  //Setting the position for the grippers
                RightGripper.setPosition(0.81);
                LeftGripper.setPosition(0.21 );
                if (time>4){ state=4;}
                break;
            case 4:   //??
                state = 5;
                break;
            case 5:   //Going backwords
                Right.setPower(-0.5);
                Left.setPower(0.5);
                if (time > 6){ //dif =2
                    Right.setPower(0);
                    Left.setPower(0);
                    state = 6;
                }
                break;
            case 6: //Turn pi/2 radion left
                Right.setPower(.5);
                Left.setPower(.5);
                if (time >7.2){//dif = 1.2
                    Right.setPower(0);
                    Left.setPower(0);
                    state = 7;
                }
                break;
            case 7: //Move forward
                Right.setPower(.5);
                Left.setPower(-.5);
                if (time > 12.2   ){//dif =5
                    Right.setPower(0);
                    Left.setPower(0);
                    state = 8;
                }
                break;

        }




    }
}*/

