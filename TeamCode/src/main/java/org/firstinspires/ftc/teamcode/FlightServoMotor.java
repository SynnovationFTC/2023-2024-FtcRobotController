package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp

public class FlightServoMotor extends LinearOpMode {
    Servo top = hardwareMap.get(Servo.class, "topservo");
    Servo down = hardwareMap.get(Servo.class, "bottomservo");
    double topservoposition = top.getPosition();
    double bottomservoposition = down.getPosition();
    private static double topservoincrement = 0.01;
    private static double bottomservoincrement = 0.01;


    @Override
    public void runOpMode() {
        Servo top = hardwareMap.get(Servo.class, "topservo");
        Servo down = hardwareMap.get(Servo.class, "bottomservo");
        top.getPosition();
        waitForStart();
        while (opModeIsActive()) {
            if (gamepad1.dpad_up){
                topservoposition -= topservoincrement;
                top.setPosition(topservoposition);
                telemetry.addData("Dpad", "signal worksup!");
            }
            if (gamepad1.dpad_down){
                topservoposition += topservoincrement;
                top.setPosition(topservoposition);
                telemetry.addData("Dpad", "signal worksdown!");
            }
            if (gamepad1.dpad_left){
                bottomservoposition -= bottomservoincrement;
                top.setPosition(bottomservoposition);

                telemetry.addData("Dpad", "signal worksleft!");
            }

            if (gamepad1.dpad_right){
                bottomservoposition += bottomservoincrement;
                top.setPosition(bottomservoposition);
                telemetry.addData("Dpad", "signal worksright!");
            }
            telemetry.update();
        }
    }
}
