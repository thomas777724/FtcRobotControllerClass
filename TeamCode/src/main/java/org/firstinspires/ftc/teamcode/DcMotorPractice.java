package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.mechanisms.TestBench;

@TeleOp
public class DcMotorPractice extends OpMode {

    TestBench bench = new TestBench();

    public void init(){
        bench.init(hardwareMap);
    }

    @Override
    public void loop(){

        /*double motorSpeed = gamepad1.left_stick_y;
        bench.setMotorSpeed(motorSpeed);
        if(gamepad1.a){
            bench.brakeOrFloat(DcMotor.ZeroPowerBehavior.BRAKE);
        } else if (gamepad1.b) {
            bench.brakeOrFloat(DcMotor.ZeroPowerBehavior.FLOAT);
        }
        telemetry.addData("Motor Revs", bench.getMotorRevs());
         */

        double motorSpeed;
        if(bench.getDistance()<3){
            motorSpeed = .9;
        }
        else {
            motorSpeed = 0;
        }
        bench.setMotorSpeed(motorSpeed);
    }
}
