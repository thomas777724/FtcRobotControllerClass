package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Single Motor Control", group = "Examples")
public class SingleMotorControl extends LinearOpMode {

    private DcMotor testMotor;

    @Override
    public void runOpMode(){
        testMotor= hardwareMap.get(DcMotor.class, "motor");
        testMotor.setDirection(DcMotor.Direction.FORWARD);
        waitForStart();

        while (opModeIsActive()){
            double power = -gamepad1.left_stick_y;
            testMotor.setPower(power);
            telemetry.addData("Motor Power", power);
            telemetry.update();
        }
    }
}
