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

        double topservoposition = 0.5;  // Set to the initial position (0.5 is the mid position for Servo)
        double bottomservoposition = 0.5;

        top.setPosition(topservoposition);
        down.setPosition(bottomservoposition);

        double topservoincrement = 0.1;  // Adjust this increment based on your servo specs
        double bottomservoincrement = 0.1;

        waitForStart();

        while (opModeIsActive()) {
            if (gamepad1.dpad_up) {
                bottomservoposition -= 0.2;  // Decrease by 20 degrees
                down.setPosition(bottomservoposition);
                telemetry.addData("Dpad", "signal works up!" + bottomservoposition);
            }

            if (gamepad1.dpad_down) {
                bottomservoposition += 0.2;  // Increase by 20 degrees
                down.setPosition(bottomservoposition);
                telemetry.addData("Dpad", "signal works down!" + bottomservoposition);
            }

            if (gamepad1.dpad_left) {
                topservoposition -= 0.2;  // Decrease by 20 degrees
                top.setPosition(topservoposition);
                telemetry.addData("Dpad", "signal works left!" + topservoposition);
            }

            if (gamepad1.dpad_right) {
                topservoposition += 0.2;  // Increase by 20 degrees
                top.setPosition(topservoposition);
                telemetry.addData("Dpad", "signal works right!" + topservoposition);
            }

            telemetry.update();
        }
    }
}

