package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp

public class FlightServoMotor extends LinearOpMode {


    @Override
    public void runOpMode() {
        Servo Flight = hardwareMap.get(Servo.class, "FlightServo");
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        while (opModeIsActive()) {
            if (gamepad1.x) {
                Flight.setPosition(0.4);
            }
            if (gamepad1.y) {
                Flight.setPosition(0);
            }
            telemetry.addData("Status", "Running");
            telemetry.update();
        }
    }
}
