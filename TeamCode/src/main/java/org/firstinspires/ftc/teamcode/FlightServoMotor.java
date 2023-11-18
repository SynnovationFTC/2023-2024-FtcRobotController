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
        Servo dronelauncher = hardwareMap.get(Servo.class, "dronelaunchservo");
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        while (opModeIsActive()) {
            if (gamepad1.dpad_up){
                dronelauncher.setPosition(0.5);
            }
            if (gamepad1.dpad_down){
                dronelauncher.setPosition(1);
            }
        }
    }
}
