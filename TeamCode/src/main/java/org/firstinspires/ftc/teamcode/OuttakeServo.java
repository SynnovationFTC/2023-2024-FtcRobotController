package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class OuttakeServo extends LinearOpMode {
    @Override
    public void runOpMode() {
        Servo outtake = hardwareMap.get(Servo.class, "outtake");
        outtake.setDirection(Servo.Direction.REVERSE);
        waitForStart();
        while (opModeIsActive()) {
            if (gamepad1.dpad_up) {
                outtake.setPosition(1);
            }
            if (gamepad1.dpad_down) {
                outtake.setPosition(0.32);
            }
            //outtake.setPosition(gamepad1.right_trigger);
            telemetry.addLine(String.valueOf(outtake.getPosition()));
            telemetry.update();
        }

    }
}


