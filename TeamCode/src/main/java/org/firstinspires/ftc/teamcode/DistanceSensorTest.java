package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@TeleOp
public class DistanceSensorTest extends LinearOpMode {

    private boolean isLeftObjectDetected = false;
    private boolean isMiddleObjectDetected = false;
    private boolean isRightObjectDetected = false;

    @Override
    public void runOpMode() {
        // Initialization code for distance sensors...
        DistanceSensor left;
        DistanceSensor middle;
        DistanceSensor right;
        left = hardwareMap.get(DistanceSensor.class, "distanceleft");
        middle = hardwareMap.get(DistanceSensor.class, "distancemiddle");
        right = hardwareMap.get(DistanceSensor.class, "distanceright");
        Rev2mDistanceSensor leftTOF = (Rev2mDistanceSensor) left;
        Rev2mDistanceSensor middleTOF = (Rev2mDistanceSensor) middle;
        Rev2mDistanceSensor rightTOF = (Rev2mDistanceSensor) right;

        waitForStart();

        while (opModeIsActive()) {
            telemetry.addData("Status", "Running");

            double leftdistance = left.getDistance(DistanceUnit.CM);
            telemetry.addData("deviceName", left.getDeviceName());
            telemetry.addData("left", String.format("%.01f cm", leftdistance));
            isLeftObjectDetected = (leftdistance >= 36 && leftdistance <= 64);

            double middledistance = middle.getDistance(DistanceUnit.CM);
            telemetry.addData("deviceName", middle.getDeviceName());
            telemetry.addData("middle", String.format("%.01f cm", middledistance));
            isMiddleObjectDetected = (middledistance >= 36 && middledistance <= 100);


            double rightdistance = right.getDistance(DistanceUnit.CM);
            telemetry.addData("deviceName", right.getDeviceName());
            telemetry.addData("right", String.format("%.01f cm", rightdistance));
            isRightObjectDetected = (rightdistance >= 36 && rightdistance <= 64);

            telemetry.addData("Object Detected (Left)", isLeftObjectDetected);
            telemetry.addData("Object Detected (Middle)", isMiddleObjectDetected);
            telemetry.addData("Object Detected (Right)", isRightObjectDetected);

            telemetry.update();
        }
    }
}
