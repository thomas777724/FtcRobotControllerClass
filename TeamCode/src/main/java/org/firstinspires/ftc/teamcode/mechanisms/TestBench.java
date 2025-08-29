package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

import java.security.PublicKey;

public class TestBench{

    private DigitalChannel touchSensor;
    private DcMotor motor;
    private double ticksPerRev;
    private Servo servo;
    private NormalizedColorSensor colorSensor;
    private DistanceSensor distance;
    private IMU imu;

    public void init(HardwareMap hwMap){
        //touch-------------------------------------
        touchSensor = hwMap.get(DigitalChannel.class, "touch_sensor");
        touchSensor.setMode(DigitalChannel.Mode.INPUT);
        //motor-------------------------------------
        motor = hwMap.get(DcMotor.class, "motor");
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        ticksPerRev = motor.getMotorType().getTicksPerRev();
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor.setDirection(DcMotor.Direction.REVERSE);
        //servo-------------------------------------
        servo = hwMap.get(Servo.class, "servo");
        servo.setDirection((Servo.Direction.REVERSE));
        //color sensor-----------------------------------------
        colorSensor = hwMap.get(NormalizedColorSensor.class, "color_sensor");
        colorSensor.setGain(4);
        //distance sensor------------------------------------------------
        distance = hwMap.get(DistanceSensor.class, "color_sensor");
        //gyro--------------------------------------------------
        imu = hwMap.get(IMU.class, "imu");
        RevHubOrientationOnRobot RevOrientation = new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD
        );
        imu.initialize(new IMU.Parameters(RevOrientation));
    }

    //touch-------------------------------------
    public boolean isTouchSensorPressed(){
        return !touchSensor.getState();
    }
    public boolean isTouchSensorReleased(){
        return touchSensor.getState();
    }

    //motor-------------------------------------
    public void setMotorSpeed(double speed){
        motor.setPower(speed);
    }
    public double getMotorRevs(){
        return motor.getCurrentPosition() / ticksPerRev * 20;
    }
    public void brakeOrFloat(DcMotor.ZeroPowerBehavior zeroBehavior){
        motor.setZeroPowerBehavior(zeroBehavior);
    }


    //servo-----------------------------------
    public void setServoPos(double angle){
        servo.setPosition(angle);
    }


    //color sensor-------------------------------------------
    public enum DetectedColor{
        RED,
        YELLOW,
        BLUE,
        UNKNOWN
    }

    public DetectedColor getDetectedColor(Telemetry telemetry) {

        NormalizedRGBA colors = colorSensor.getNormalizedColors();

        float normRed, normGrn, normBlu;
        normRed = colors.red / colors.alpha;
        normGrn = colors.green / colors.alpha;
        normBlu = colors.blue / colors.alpha;

        telemetry.addData("red", normRed);
        telemetry.addData("green", normGrn);
        telemetry.addData("blue", normBlu);

        if (normRed > .3 && normGrn < .2 && normBlu < .08) {
            return DetectedColor.RED;
        } else if (normRed < .04 && normGrn < .05 && normBlu > .02) {
            return DetectedColor.BLUE;
        } else if (normRed > .05 && normGrn > .05 && normBlu < .02) {
            return DetectedColor.YELLOW;
        } else {
            return DetectedColor.UNKNOWN;
        }
    }

    //distance sensor---------------------------------------
    public double getDistance(){
        return distance.getDistance(DistanceUnit.CM);
    }

    public double getHeading(AngleUnit angleUnit){
        return imu.getRobotYawPitchRollAngles().getYaw(angleUnit);
    }

}

