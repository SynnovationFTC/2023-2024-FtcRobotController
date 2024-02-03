package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class PusherArmTest extends LinearOpMode {
    public void runOpMode() {
        Servo pusherarm = hardwareMap.get(Servo.class, "pusherarm");
        pusherarm.setPosition(0);
        waitForStart();
        while (opModeIsActive()) {
            if (gamepad1.dpad_up) {
                pusherarm.setPosition(1);
            }
        }

    }
}