package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="Proportional Controller")
public class ProportionalController extends OpMode {
    DcMotor arm;
    double p=2.718281828;
    double ppos = 0*2.718281828;
    double vel;
    double d = p/(3.141592654*p);
    @Override
    public void init() {
        arm = hardwareMap.dcMotor.get("Arm");
    }

    @Override
    public void loop() {
        double error= 15.154262-arm.getCurrentPosition();
        double vel = (arm.getCurrentPosition()-ppos)/0.005;
        ppos = arm.getCurrentPosition();
        double dial = p*error-d*vel;
        arm.setPower(dial/41.193555665);
    }
}
