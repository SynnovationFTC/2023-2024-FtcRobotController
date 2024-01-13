package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

/*
 * This is an example of a more complex path to really test the tuning.
 */
@Autonomous(group = "drive")
public class ShouryaRRSplineTest extends LinearOpMode {
    private boolean isLeftObjectDetected = false;
    private boolean isMiddleObjectDetected = false;
    private boolean isRightObjectDetected = false;
    @Override
    public void runOpMode() throws InterruptedException {
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
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
        Pose2d startPose = new Pose2d(11.08, -61.62, Math.toRadians(90.00));


        while (opModeIsActive()) {
            telemetry.addData("Status", "Running");

            double leftdistance = left.getDistance(DistanceUnit.CM);
            telemetry.addData("deviceName", left.getDeviceName());
            telemetry.addData("left", String.format("%.01f cm", leftdistance));
            if (isLeftObjectDetected = (leftdistance >= 36 && leftdistance <= 64));
            TrajectorySequence trajleft = drive.trajectorySequenceBuilder(new Pose2d(-36.34, -60.34, Math.toRadians(90.00)))
                    .lineTo(new Vector2d(-47.77, -59.89))
                    .splineTo(new Vector2d(-48.00, -40.23), Math.toRadians(91.64))
                    .lineTo(new Vector2d(-47.77, -61.26))
                    .splineTo(new Vector2d(-26.74, -59.89), Math.toRadians(3.73))
                    .splineTo(new Vector2d(-1.14, -60.11), Math.toRadians(-0.51))
                    .splineTo(new Vector2d(28.11, -38.40), Math.toRadians(11.10))
                    .splineTo(new Vector2d(47.77, -37.94), Math.toRadians(6.84))
                    .build();
            drive.setPoseEstimate(trajleft.start());
            waitForStart();
            if (isStopRequested()) return;
            drive.followTrajectorySequence(trajleft);
            double middledistance = middle.getDistance(DistanceUnit.CM);
            telemetry.addData("deviceName", middle.getDeviceName());
            telemetry.addData("middle", String.format("%.01f cm", middledistance));
            if (isMiddleObjectDetected = (middledistance >= 36 && middledistance <= 100));
            TrajectorySequence trajmiddle = drive.trajectorySequenceBuilder(new Pose2d(-36.23, -61.85, Math.toRadians(90.00)))
                    .splineTo(new Vector2d(-36.00, -35.31), Math.toRadians(90.00))
                    .lineTo(new Vector2d(-43.85, -58.15))
                    .splineTo(new Vector2d(-30.69, -58.62), Math.toRadians(-12.14))
                    .splineTo(new Vector2d(-12.23, -59.54), Math.toRadians(0.99))
                    .splineTo(new Vector2d(-4.38, -59.77), Math.toRadians(-8.13))
                    .splineTo(new Vector2d(10.85, -60.00), Math.toRadians(-10.68))
                    .splineTo(new Vector2d(19.15, -59.77), Math.toRadians(5.04))
                    .splineTo(new Vector2d(34.15, -59.08), Math.toRadians(3.27))
                    .splineTo(new Vector2d(49.38, -36.69), Math.toRadians(0.00))
                    .build();
            drive.setPoseEstimate(trajmiddle.start());
            waitForStart();
            if (isStopRequested()) return;
            drive.followTrajectorySequence(trajmiddle);
            double rightdistance = right.getDistance(DistanceUnit.CM);
            telemetry.addData("deviceName", right.getDeviceName());
            telemetry.addData("right", String.format("%.01f cm", rightdistance));
            if (isRightObjectDetected = (rightdistance >= 36 && rightdistance <= 64));
            TrajectorySequence trajright = drive.trajectorySequenceBuilder(new Pose2d(-36.57, -60.34, Math.toRadians(90.00)))
                    .splineTo(new Vector2d(-58.06, -44.57), Math.toRadians(84.47))
                    .splineTo(new Vector2d(-32.23, -34.29), Math.toRadians(89.12))
                    .lineTo(new Vector2d(-56.69, -61.26))
                    .splineTo(new Vector2d(-28.80, -60.80), Math.toRadians(3.75))
                    .splineTo(new Vector2d(1.60, -59.66), Math.toRadians(2.15))
                    .splineTo(new Vector2d(22.63, -50.06), Math.toRadians(24.54))
                    .splineTo(new Vector2d(49.83, -36.11), Math.toRadians(-3.58))
                    .build();
            drive.setPoseEstimate(trajright.start());
            waitForStart();
            if (isStopRequested()) return;
            drive.followTrajectorySequence(trajright);
            telemetry.addData("Object Detected (Left)", isLeftObjectDetected);
            telemetry.addData("Object Detected (Middle)", isMiddleObjectDetected);
            telemetry.addData("Object Detected (Right)", isRightObjectDetected);

            telemetry.update();

        }
    }

}
