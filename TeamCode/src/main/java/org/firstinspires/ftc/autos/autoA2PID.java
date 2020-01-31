package org.firstinspires.ftc.autos;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous (name="autoA2PID")
public class autoA2PID extends OpMode {
    DcMotor Right;
    DcMotor Left;
    Servo RightGripper;
    Servo LeftGripper;
    Servo Hook1;
    Servo Hook2;
    DcMotor Ee;
    DcMotor eE;
    int state = 1;
    int T = 1; //T is the variable for the switch that measures the vel
    double startTime;
    double RCP; //Right.getCurrentPos
    double LCP;  //Left.getCurrentPos
    double p; //Proportional
    double d; //Derivative
    double rE; //right error
    double lE; //left error
    double rVel; //right velocity
    double lVel; //left velocity
    double rt; //position at past time on the right
    double lt; //position at past time on the left
    double SP = 1;//1/(4 * 3.1415926); //the 10 is the distance in inches
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
        RCP = Right.getCurrentPosition();
        LCP = Left.getCurrentPosition();
        p=0.4;
        d=0;
        rE = SP-RCP; //set the SPs to different values within states
        lE = SP+LCP; //left needs to be negative
    }

    @Override
    public void loop() {
        telemetry.addData("leftPos", Left.getCurrentPosition());
        telemetry.addData("rightPos", Right.getCurrentPosition());
        switch (T) {  //approximating the velocity
            case 1:
                rt = Right.getCurrentPosition();
                lt = Left.getCurrentPosition(); //setting the position in the past
                T = 2;
                break;
            case 2: //calculating the velocity
                rVel = (Right.getCurrentPosition() - rt) / 0.005; //0.01=sampling rate
                lVel = (lt - Left.getCurrentPosition()) / 0.005; //reversed               T = 1;
                break;
    }

        switch (state) {
            case 1:
                startTime = time; //want to use time to give the robot time to grab a block.
                state = 2;
                break;
            case 2:
                Left.setPower(-(lE * p) - (d * lVel));
                Right.setPower((rE * p) + (d * rVel));

                if ((rE == 0 && lE == 0) || time > 5) {
                    Left.setPower(0);
                    Right.setPower(0);
                }

                break;
            case 3:

                break;
        }
    }
}
