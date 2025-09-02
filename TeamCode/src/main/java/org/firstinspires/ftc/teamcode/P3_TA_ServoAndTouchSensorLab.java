package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name = "ServoAndTouchLab", group = "Program")
public class P3_TA_ServoAndTouchSensorLab extends LinearOpMode {

    private Servo labServo;
    private TouchSensor labTouchSensor;

    public void runOpMode(){

        boolean run = true;
        labServo = hardwareMap.get(Servo.class, "P3_TA_servo");
        labTouchSensor = hardwareMap.get(TouchSensor.class, "P3_TA_touch_sensor");
        ElapsedTime elapsedTime = new ElapsedTime();
        double start = elapsedTime.time();
        waitForStart();

        while (opModeIsActive()){
            if(labTouchSensor.isPressed()){
                if(run){
                    labServo.setPosition(-1);
                    double num = elapsedTime.time();
                    while(elapsedTime.time()-num<1){

                    }
                    run = false;
                }
                else{
                    labServo.setPosition(1);
                    double num = elapsedTime.time();
                    while(elapsedTime.time()-num<1){

                    }
                    run = true;
                }
            }
            else{
                labServo.setPosition(labServo.getPosition());
            }

            telemetry.addData("Servo Position", labServo.getPosition());
            telemetry.addData("Touch Sensor Value", labTouchSensor.isPressed());
            telemetry.addData("Run?", run);
            telemetry.update();
        }
    }
}
