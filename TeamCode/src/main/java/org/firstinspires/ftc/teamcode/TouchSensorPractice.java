package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.TestBench;

@TeleOp
public class TouchSensorPractice extends OpMode {

    TestBench bench = new TestBench();

    @Override
    public void init(){
        bench.init(hardwareMap);
    }

    @Override
    public void loop(){
        String pressed = "pressed!";
        String not = "not pressed!";

        if(bench.isTouchSensorPressed()){
            telemetry.addData("Touch sensor state", pressed);
        }
        else{
            telemetry.addData("Touch sensor state", not);
        }


    }
}
