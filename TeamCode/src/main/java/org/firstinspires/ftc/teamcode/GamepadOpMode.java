package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class GamepadOpMode extends OpMode {
    @Override
    public void init(){
    }

    @Override
    public void loop(){
        telemetry.addData("Left stick x", gamepad1.left_stick_x);
        telemetry.addData("Left stick y", gamepad1.left_stick_y);
        telemetry.addData("A button", gamepad1.a);
        telemetry.addData("Right stick x", gamepad1.right_stick_x);
        telemetry.addData("Right stick y", gamepad1.right_stick_y);
        telemetry.addData("B button", gamepad1.b);
        telemetry.addData("Difference between both sticks' y", gamepad1.left_stick_y - gamepad1.right_stick_y);
        telemetry.addData("Sum of triggers", gamepad1.right_trigger + gamepad1.left_trigger);
    }
}
