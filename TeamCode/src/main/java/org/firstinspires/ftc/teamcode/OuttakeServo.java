package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

public class OuttakeServo extends LinearOpMode {
    @Override
    public void runOpMode(){
        Servo top = hardwareMap.get(Servo.class, "topservo");
        Servo bottom = hardwareMap.get(Servo.class, "bottomservo");
        double initialtopservoposition = 0.5;
        double initialbottomservoposition = 0.5;
        top.setPosition(initialtopservoposition);
        bottom.setPosition(initialbottomservoposition);
        waitForStart();
        while (opModeIsActive()) {
            if (gamepad1.dpad_up){
                double currentTopUpPosition = top.getPosition();
                double newTopUpPosition = currentTopUpPosition + 0.1;
                top.setPosition(newTopUpPosition);
                telemetry.addData("Servo Position:", top.getPosition());
            }
            if (gamepad1.dpad_down){
                double currentTopDownPosition = top.getPosition();
                double newTopDownPosition = currentTopDownPosition - 0.1;
                top.setPosition(newTopDownPosition);
                telemetry.addData("Servo Position:", top.getPosition());
            }
            telemetry.update();
        }
    }
}
