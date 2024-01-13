package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
@TeleOp
public class OuttakeServo extends LinearOpMode {
    @Override
    public void runOpMode(){
        Servo top = hardwareMap.get(Servo.class, "topservo");
        top.setDirection(Servo.Direction.REVERSE);
        Servo bottom = hardwareMap.get(Servo.class, "bottomservo");

        double initialtopservoposition = 0.05;
        double initialbottomservoposition = 0.5;
        top.setPosition(initialtopservoposition);
        bottom.setPosition(initialbottomservoposition);
        waitForStart();
        while (opModeIsActive()) {
            if (gamepad1.dpad_down){
                top.setPosition(0.05);
                telemetry.addData("Servo Position:", top.getPosition());
            }
            if (gamepad1.dpad_up){
                top.setPosition(0.45);
                telemetry.addData("Servo Position:", top.getPosition());

            }
            telemetry.update();
        }
    }
}
