package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class OuttakeServo extends LinearOpMode {
    @Override
    public void runOpMode() {
        Servo holder = hardwareMap.get(Servo.class, "holder");
        Servo launcher = hardwareMap.get(Servo.class, "launcher");

        holder.setDirection(Servo.Direction.REVERSE);
        waitForStart();
        while (opModeIsActive()) {
            if (gamepad1.dpad_down) {
                holder.setPosition(0.04);
            }
            if (gamepad1.dpad_up) {
                holder.setPosition(0.5);
            }
            if (gamepad1.dpad_right) {
                launcher.setPosition(0);
            }
            if (gamepad1.dpad_left) {
                launcher.setPosition(0.7);
            }
            //outtake.setPosition(gamepad1.right_trigger);
            telemetry.addLine(String.valueOf(holder.getPosition()));
            telemetry.update();
        }

    }
}


