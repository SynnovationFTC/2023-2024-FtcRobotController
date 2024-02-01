package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

import java.util.Objects;

@Autonomous
public class RobotFullAutonomous extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
        double runCount = 0;
        boolean isLeftObjectDetected;
        boolean isMiddleObjectDetected;
        boolean isRightObjectDetected;
        DigitalChannel color = hardwareMap.get(DigitalChannel.class, "color");
        DigitalChannel boardside = hardwareMap.get(DigitalChannel.class, "boardside");
        color.setMode(DigitalChannel.Mode.INPUT);
        boardside.setMode(DigitalChannel.Mode.INPUT);
        DistanceSensor left;
        DistanceSensor middle;
        DistanceSensor right;
        left = hardwareMap.get(DistanceSensor.class, "distanceleft");
        middle = hardwareMap.get(DistanceSensor.class, "distancemiddle");
        right = hardwareMap.get(DistanceSensor.class, "distanceright");
        String side = null;
        String colorvalue = null;
        if (color.getState()) {
            telemetry.addData("Color", "Red");
            colorvalue = "red";
        }
        if (!color.getState()) {
            telemetry.addData("Color", "Blue");
            colorvalue = "blue";
        }
        if (boardside.getState()) {
            telemetry.addData("Side", "Board");
            side = "board";

        }
        if (!boardside.getState()) {
            telemetry.addData("Side", "Audience");
            side = "audience";
        }
        double slowVel = 15;
        TrajectorySequence redboardsideright = drive.trajectorySequenceBuilder(new Pose2d(12.08, -62.19, Math.toRadians(90.00)))
                .lineTo(new Vector2d(24.00, -62.19))
                .lineTo(new Vector2d(23.55, -39.70))
                .lineTo(new Vector2d(35.62, -59.77))
                .lineTo(new Vector2d(36.08, -38.19))
                .splineToLinearHeading(new Pose2d(44.08, -58.42, Math.toRadians(0.35)), Math.toRadians(0.35))
                .build();

        TrajectorySequence redboardsidemiddle = drive.trajectorySequenceBuilder(new Pose2d(11.92, -61.74, Math.toRadians(90.00)))
                .lineTo(new Vector2d(11.77, -33.06))
                .lineTo(new Vector2d(24.30, -50.57))
                .lineTo(new Vector2d(37.74, -35.17))
                .splineToLinearHeading(new Pose2d(44.08, -58.42, Math.toRadians(0.35)), Math.toRadians(0.35))
                .build();

        TrajectorySequence redboardsideleft = drive.trajectorySequenceBuilder(new Pose2d(11.02, -60.53, Math.toRadians(90.00)))
                .lineTo(new Vector2d(23.25, -60.83))
                .lineTo(new Vector2d(23.25, -35.62))
                .splineTo(new Vector2d(8.91, -34.57), Math.toRadians(180.00))
                .lineTo(new Vector2d(31.09, -34.42))
                .splineToLinearHeading(new Pose2d(44.08, -58.42, Math.toRadians(0.35)), Math.toRadians(0.35))
                .build();

        TrajectorySequence redaudienceright = drive.trajectorySequenceBuilder(new Pose2d(-37.28, -62.04, Math.toRadians(90.00)))
                .lineTo(new Vector2d(-48.45, -61.13))
                .lineTo(new Vector2d(-48.30, -39.25))
                .splineTo(new Vector2d(-32.15, -34.87), Math.toRadians(0.00))
                .lineTo(new Vector2d(-51.17, -12.38))
                .lineTo(new Vector2d(13.28, -11.32))
                .lineTo(new Vector2d(20.08, -30.04))
                .lineTo(new Vector2d(31.70, -54.19))
                .lineTo(new Vector2d(42.72, -60.68))
                .splineToLinearHeading(new Pose2d(44.08, -58.42, Math.toRadians(0.35)), Math.toRadians(0.35))
                .build();

        TrajectorySequence redaudiencemiddle = drive.trajectorySequenceBuilder(new Pose2d(-37.58, -60.38, Math.toRadians(90.00)))
                .lineTo(new Vector2d(-36.38, -33.21))
                .lineTo(new Vector2d(-57.36, -52.98))
                .lineTo(new Vector2d(-51.62, -13.13))
                .splineTo(new Vector2d(-32.60, -11.17), Math.toRadians(8.39))
                .lineTo(new Vector2d(12.08, -9.36))
                .lineTo(new Vector2d(37.43, -12.08))
                .lineTo(new Vector2d(36.38, -51.62))

                .splineToLinearHeading(new Pose2d(44.08, -58.42, Math.toRadians(0.35)), Math.toRadians(0.35))
                .build();

        TrajectorySequence redaudienceleft = drive.trajectorySequenceBuilder(new Pose2d(-37.28, -62.04, Math.toRadians(90.00)))
                .lineTo(new Vector2d(-49.06, -62.04))
                .lineTo(new Vector2d(-47.40, -40.15))
                .lineTo(new Vector2d(-38.94, -57.81))
                .lineTo(new Vector2d(-33.36, -11.47))
                .lineTo(new Vector2d(3.47, -9.81))
                .lineTo(new Vector2d(34.11, -13.13))
                .lineTo(new Vector2d(36.08, -34.26))
                .splineToLinearHeading(new Pose2d(44.08, -58.42, Math.toRadians(0.35)), Math.toRadians(0.35))
                .build();

        TrajectorySequence blueboardsideright = drive.trajectorySequenceBuilder(new Pose2d(11.47, 60.38, Math.toRadians(270.00)))
                .lineTo(new Vector2d(24.00, 60.23))
                .lineTo(new Vector2d(23.70, 31.70))
                .splineTo(new Vector2d(8.45, 33.66), Math.toRadians(178.59))
                .lineTo(new Vector2d(41.66, 33.51))
                .splineToLinearHeading(new Pose2d(44.23, 59.47, Math.toRadians(1.23)), Math.toRadians(1.23))
                .build();

        TrajectorySequence blueboardsidemiddle = drive.trajectorySequenceBuilder(new Pose2d(11.77, 60.98, Math.toRadians(270.00)))
                .lineTo(new Vector2d(11.92, 32.75))
                .lineTo(new Vector2d(24.45, 50.11))
                .lineTo(new Vector2d(35.62, 40.00))
                .splineToLinearHeading(new Pose2d(44.23, 59.47, Math.toRadians(1.23)), Math.toRadians(1.23))
                .build();

        TrajectorySequence blueboardsideleft = drive.trajectorySequenceBuilder(new Pose2d(11.77, 60.98, Math.toRadians(270.00)))
                .lineTo(new Vector2d(24.00, 60.83))
                .lineTo(new Vector2d(23.70, 40.91))
                .lineTo(new Vector2d(23.70, 54.34))
                .lineTo(new Vector2d(38.79, 40.91))
                .splineToLinearHeading(new Pose2d(44.23, 59.47, Math.toRadians(1.23)), Math.toRadians(1.23))
                .build();

        TrajectorySequence blueaudienceright = drive.trajectorySequenceBuilder(new Pose2d(-35.77, 60.83, Math.toRadians(270.00)))
                .lineTo(new Vector2d(-48.15, 59.92))
                .lineTo(new Vector2d(-47.70, 40.75))
                .lineTo(new Vector2d(-38.04, 52.98))
                .lineTo(new Vector2d(-35.17, 28.38))
                .lineTo(new Vector2d(-34.87, 12.38))
                .splineTo(new Vector2d(1.21, 10.87), Math.toRadians(0.81))
                .lineTo(new Vector2d(35.02, 11.02))
                .lineTo(new Vector2d(36.08, 43.62))
                .splineToLinearHeading(new Pose2d(44.23, 59.47, Math.toRadians(1.23)), Math.toRadians(1.23))

                .build();

        TrajectorySequence blueaudiencemiddle = drive.trajectorySequenceBuilder(new Pose2d(-36.38, 60.08, Math.toRadians(270.00)))
                .lineTo(new Vector2d(-35.92, 33.21))
                .lineTo(new Vector2d(-56.91, 58.11))
                .lineTo(new Vector2d(-52.08, 12.38))
                .splineTo(new Vector2d(-21.43, 10.72), Math.toRadians(-3.10))
                .lineTo(new Vector2d(11.77, 11.92))
                .lineTo(new Vector2d(35.62, 11.17))
                .lineTo(new Vector2d(35.77, 49.21))
                .splineToLinearHeading(new Pose2d(44.23, 59.47, Math.toRadians(1.23)), Math.toRadians(1.23))
                .build();

        TrajectorySequence blueaudienceleft = drive.trajectorySequenceBuilder(new Pose2d(-35.77, 60.83, Math.toRadians(270.00)))
                .lineTo(new Vector2d(-48.15, 61.13))
                .lineTo(new Vector2d(-47.85, 33.96))
                .splineTo(new Vector2d(-32.15, 34.26), Math.toRadians(-1.19))
                .lineTo(new Vector2d(-51.02, 32.60))
                .lineTo(new Vector2d(-41.66, 5.89))
                .lineTo(new Vector2d(11.62, 4.98))
                .lineTo(new Vector2d(32.60, 4.98))
                .lineTo(new Vector2d(35.32, 32.15))
                .splineToLinearHeading(new Pose2d(44.23, 59.47, Math.toRadians(1.23)), Math.toRadians(1.23))
                .build();


        waitForStart();
        double rightDistance = right.getDistance(DistanceUnit.CM);
        double middleDistance = middle.getDistance(DistanceUnit.CM);
        double leftDistance = left.getDistance(DistanceUnit.CM);

        isRightObjectDetected = (rightDistance >= 36 && rightDistance <= 64);
        //isMiddleObjectDetected = (middleDistance >= 36 && middleDistance <= 100);
        isLeftObjectDetected = (leftDistance >= 36 && leftDistance <= 64);
        isMiddleObjectDetected = ((!isRightObjectDetected && !isLeftObjectDetected)&&((middleDistance >= 36 && middleDistance <= 100)));


        while (opModeIsActive()) {
            telemetry.addData("Right Distance", rightDistance);
            telemetry.addData("Left Distance", leftDistance);
            telemetry.addData("Is Right Object Detected", isRightObjectDetected);
            telemetry.addData("Is Left Object Detected", isLeftObjectDetected);
            telemetry.addData("Is Middle Object Detected", isMiddleObjectDetected);
            telemetry.addData("Side", side);
            telemetry.addData("Color", colorvalue);
            telemetry.update();

            if (Objects.equals(side, "board")) {
                if (Objects.equals(colorvalue, "red")) {
                    if (isRightObjectDetected) {
                        telemetry.addData("Object Detected:", "Right");
                        telemetry.update();
                        drive.setPoseEstimate(redboardsideright.start());
                        drive.followTrajectorySequence(redboardsideright);
                        break;
                    } else if (isMiddleObjectDetected) {
                        telemetry.addData("Object Detected:", "Middle");
                        telemetry.update();
                        drive.setPoseEstimate(redboardsidemiddle.start());
                        drive.followTrajectorySequence(redboardsidemiddle);
                        break;
                    } else if (isLeftObjectDetected) {
                        telemetry.addData("Object Detected:", "Left");
                        telemetry.update();
                        drive.setPoseEstimate(redboardsideleft.start());
                        drive.followTrajectorySequence(redboardsideleft);
                        break;
                    }
                } else if (Objects.equals(colorvalue, "blue")) {
                    // Add similar telemetry and trajectory execution for the blue case
                    telemetry.addData("Color", "Blue");
                    telemetry.update();
                    if (isRightObjectDetected) {
                        telemetry.addData("Object Detected:", "Right");
                        telemetry.update();
                        drive.setPoseEstimate(blueboardsideright.start());
                        drive.followTrajectorySequence(blueboardsideright);
                        break;
                    } else if (isMiddleObjectDetected) {
                        telemetry.addData("Object Detected:", "Middle");
                        telemetry.update();
                        drive.setPoseEstimate(blueboardsidemiddle.start());
                        drive.followTrajectorySequence(blueboardsidemiddle);
                        break;
                    } else if (isLeftObjectDetected) {
                        telemetry.addData("Object Detected:", "Left");
                        telemetry.update();
                        drive.setPoseEstimate(blueboardsideleft.start());
                        drive.followTrajectorySequence(blueboardsideleft);
                        break;
                    }
                }
            } else if (Objects.equals(side, "audience")) {
                if (Objects.equals(colorvalue, "red")) {
                    if (isRightObjectDetected) {
                        telemetry.addData("Object Detected:", "Right");
                        telemetry.update();
                        drive.setPoseEstimate(redaudienceright.start());
                        drive.followTrajectorySequence(redaudienceright);
                        break;
                    } else if (isMiddleObjectDetected) {
                        telemetry.addData("Object Detected:", "Middle");
                        telemetry.update();
                        drive.setPoseEstimate(redaudiencemiddle.start());
                        drive.followTrajectorySequence(redaudiencemiddle);
                        break;
                    } else if (isLeftObjectDetected) {
                        telemetry.addData("Object Detected:", "Left");
                        telemetry.update();
                        drive.setPoseEstimate(redaudienceleft.start());
                        drive.followTrajectorySequence(redaudienceleft);
                        break;
                    }
                } else if (Objects.equals(colorvalue, "blue")) {
                    // Add similar telemetry and trajectory execution for the blue case
                    telemetry.addData("Color", "Blue");
                    telemetry.update();
                    if (isRightObjectDetected) {
                        telemetry.addData("Object Detected:", "Right");
                        telemetry.update();
                        drive.setPoseEstimate(blueaudienceright.start());
                        drive.followTrajectorySequence(blueaudienceright);
                        break;
                    } else if (isMiddleObjectDetected) {
                        telemetry.addData("Object Detected:", "Middle");
                        telemetry.update();
                        drive.setPoseEstimate(blueaudiencemiddle.start());
                        drive.followTrajectorySequence(blueaudiencemiddle);
                        break;
                    } else if (isLeftObjectDetected) {
                        telemetry.addData("Object Detected:", "Left");
                        telemetry.update();
                        drive.setPoseEstimate(blueaudienceleft.start());
                        drive.followTrajectorySequence(blueaudienceleft);
                        break;
                    }
                }
            }
        }
    }
}