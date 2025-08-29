package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

@TeleOp(name = "ServoAndTouchLab", group = "Program")
public class ServoAndTouchSensorLab extends LinearOpMode {

    private Servo labServo;
    private TouchSensor labTouchSensor;

    public void runOpMode(){

        boolean run = true;
        labServo = hardwareMap.get(Servo.class, "P3_TA_servo");
        labTouchSensor = hardwareMap.get(TouchSensor.class, "P3_TA_touch_sensor");

        waitForStart();

        while (opModeIsActive()){
            if(labTouchSensor.isPressed()){
                if(run){
                    labServo.setPosition(-1);
                    sleep(1000);
                    run = false;
                }
                else{
                    labServo.setPosition(1);
                    sleep(1000);
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
