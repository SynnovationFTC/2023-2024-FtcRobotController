package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class FlightServoMotor extends LinearOpMode {

    @Override
    public void runOpMode() {
        DcMotor launcher = hardwareMap.get(DcMotor.class, "dronelauncher");
        waitForStart();

        while (opModeIsActive()) {
            if (gamepad1.dpad_up) {
                launcher.setPower(1);
            }
            telemetry.addData("Power", launcher.getPower());
            telemetry.update();
        }
    }
}

