package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="ArmControl")
public class ArmControl extends OpMode {

    DcMotor Arm;
    DcMotor Right, Left;
    double setpoint = -1000;
//    double p = 0.11823868116;
    double p = 0.118023806;

    @Override
    public void init() {
        Arm = hardwareMap.dcMotor.get("Arm");
        Right = hardwareMap.dcMotor.get("Right");
        Left = hardwareMap.dcMotor.get("Left");
//        p /= 4;
    }

    @Override
    public void loop() {
        double sensor = Arm.getCurrentPosition();
        double error = setpoint - sensor;
        double output = p * error;
        output = output/12;

        if (gamepad1.a) {
            setpoint = -1119;
        } else if (gamepad1.b) {
            setpoint = -2221;
        }else if(Math.abs(gamepad1.right_stick_y) >= .038){
            output=gamepad1.right_stick_y;
            setpoint=sensor;
        }

        Arm.setPower(-output);

        //Left.setPower(gamepad1.left_stick_y);
        //Right.setPower(-gamepad1.right_stick_y);
//        Left.setPower(gamepad1.left_stick_y);
        double jf=gamepad1.left_stick_y;
        double js = gamepad1.left_stick_x;
        double dist = Math.sqrt(jf*jf + js*js);
        if (dist>1){
            jf=jf/dist;
            js=js/dist;
        }
        output(jf+js, jf-js);

        telemetry.addData("Encoder", Arm.getCurrentPosition());
        telemetry.addData("Error", error);
    }


    public void output (double left, double right){
        Left.setPower(left);
        Right.setPower(-right);

    }
}
