package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp

public class FlightServoMotor extends LinearOpMode {


    @Override
    public void runOpMode() {
        Servo top = hardwareMap.get(Servo.class, "topservo");
        Servo down = hardwareMap.get(Servo.class, "bottomservo");
        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        while (opModeIsActive()) {
            if (gamepad1.dpad_up){
                top.setPosition(0.5);
            }
            if (gamepad1.dpad_down){
                down.setPosition(1);
            }
        }
    }
}
