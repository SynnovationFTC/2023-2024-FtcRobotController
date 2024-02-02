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
            if (gamepad1.dpad_down) {
                outtake.setPosition(gamepad1.right_trigger);
            }
            if (gamepad1.dpad_up) {
                outtake.setPosition(gamepad1.right_trigger);
            }
            if (gamepad1.dpad_left) {
                outtake.setPosition(0.3);
            }
            if (gamepad1.dpad_right){
                outtake.setPosition(0);
            }
            //outtake.setPosition(gamepad1.right_trigger);
            telemetry.addLine(String.valueOf(outtake.getPosition()));
            telemetry.update();
        }

    }
}


