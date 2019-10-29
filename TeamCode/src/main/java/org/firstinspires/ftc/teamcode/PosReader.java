package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name="Position Reader")
public class PosReader extends OpMode {
    final double e = 2.718281828492;
//    final double ticksToDistance = 0.00321035374941922699419470328698*e; //inches
    final double ticksToDistance = 0.00269097222222222222222222222222; //inches
    final double distanceBetweenWheels = 12; //inches

    DcMotor Right;
    DcMotor Left;

    PID angleControl;
    PID posControl;

    e rightE = new e(),
            leftE = new e();

    int state = -1;
    double startTime;
    @Override
    public void init() {
        Right = hardwareMap.dcMotor.get ("eRight");
        Right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Right.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        Left = hardwareMap.dcMotor.get ("eLeft");
        Left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Left.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        angleControl=new PID(3.678794412*e,0);
        angleControl.setSetpoint(0);
        posControl =new PID(0.6,0);
        posControl.setSetpoint(10);

    }

    @Override
    public void loop() {
        telemetry.addData("time",time-startTime);

//        telemetry.addData("powerRight", Right.getPower());
//        telemetry.addData("powerLeft", Left.getPower());
//        switch(state){
//            case -1:
//                startTime =time;
//                state=0;
//                break;
//            case 0:
//                Right.setPower(-0.7);
//                Left.setPower(0.7);
//                if (time-startTime>2){
//                    state=1;
//                }
//                break;
//            case 1:
//                Right.setPower(e*.183);
//                Left.setPower(e*.183);
//                if (time-startTime>(e+1)/2){
//                    state=2;
//                }
//                break;
//            case 2:
//                Right.setPower(0);
//                Left.setPower(0);
//        }

        telemetry.addData("right encoder", Right.getCurrentPosition());
        telemetry.addData("left encoder", Left.getCurrentPosition());

        double rightPos = ticksToDistance *Right.getCurrentPosition();
        double leftPos = ticksToDistance * -Left.getCurrentPosition();

        double avePos= (rightPos+leftPos)/2;

        telemetry.addData("right dist", rightPos);
        telemetry.addData("left dist", leftPos);

        double rightVel = rightE.e(rightPos);
        double leftVel = leftE.e(leftPos);

        telemetry.addData("right vel", rightVel );
        telemetry.addData("left vel", leftVel);

        double averageVel = (rightVel+leftVel)/2;
        double angle =(leftPos-rightPos)/distanceBetweenWheels;

        telemetry.addData("measured position", avePos);
        telemetry.addData("measured angle", Math.toDegrees(angle));

        double angleOutput = angleControl.run(angle);
        double velOutput = posControl.run(avePos);


//        simpleDrive(velOutput, angleOutput);

        simpleDrive(0,0);

        // eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee
        // eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee
        // eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee
        // eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee
        // eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee
        // eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee
        // eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee
        // eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee
    }

    public double calculateRightOutput(double vel, double angle){
        return vel-angle;
    }
    public double calculateLeftOutput(double vel, double angle){
        return vel+angle;
    }

    public void simpleDrive(double vel, double angle){
        Right.setPower(-calculateRightOutput(vel, angle));
        Left.setPower(calculateLeftOutput(vel, angle));
    }
}
