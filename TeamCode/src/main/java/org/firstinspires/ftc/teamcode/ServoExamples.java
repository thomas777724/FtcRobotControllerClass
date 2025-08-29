package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.TestBench;

@TeleOp
public class ServoExamples extends OpMode {

    TestBench bench = new TestBench();

    @Override
    public void init() {
        bench.init(hardwareMap);
    }

    @Override
    public void loop() {
        if(bench.isTouchSensorPressed()){
            bench.setServoPos(-1.0);
        }
        else {
            bench.setServoPos(1.0);
        }
    }
}
