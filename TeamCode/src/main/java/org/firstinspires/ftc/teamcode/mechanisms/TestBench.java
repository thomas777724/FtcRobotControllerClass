package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class TestBench{

    //private DigitalChannel touchSensor;
    private DcMotor motor;

    public void init(HardwareMap hwMap){
        //touchSensor = hwMap.get(DigitalChannel.class, "touch sensor");
        //touchSensor.setMode(DigitalChannel.Mode.INPUT);
        motor = hwMap.get(DcMotor.class, "motor");
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }
    //ISNT WORKING RN, KEEP TRYING TO FIX IT LATER G
    //public boolean getTouchSensorState(){
    //    return touchSensor.getState();
    //}
    public void setMotorSpeed(double speed){
        motor.setPower(speed);
    }
}
