package org.firstinspires.ftc.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Drive {
    private static Drive instance;
    public static Drive getInstance(HardwareMap hardwareMap){
        if(instance == null){
            instance = new Drive(hardwareMap);
        }
        return instance;
    }

    DcMotor Right, Left;

    private Drive(HardwareMap hardwareMap){
       Right = hardwareMap.dcMotor.get("eRight");
       Left = hardwareMap.dcMotor.get("eLeft");
    }

    public void set(double left, double right){
        Left.setPower(-left);
        Right.setPower(right);
    }
}

