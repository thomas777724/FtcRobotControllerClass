package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.mechanisms.TestBench;

public class DcMotorPractice extends OpMode {

    TestBench bench = new TestBench();

    public void init(){
        bench.init(hardwareMap);
    }

    @Override
    public void loop(){
        bench.setMotorSpeed(.5);
    }
}
