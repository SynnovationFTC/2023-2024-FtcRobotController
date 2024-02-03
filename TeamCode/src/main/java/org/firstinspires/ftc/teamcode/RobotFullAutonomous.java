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
    public void outtakeUp(){
        Servo outtake = hardwareMap.get(Servo.class, "outtake");
        outtake.setDirection(Servo.Direction.REVERSE);
        double servoIncrement = 0.0075;
        double currentservoposition = outtake.getPosition();
        while (currentservoposition > 1) {
            double newservoposition = (currentservoposition + servoIncrement);
            outtake.setPosition(newservoposition);
            sleep(5);
            currentservoposition = outtake.getPosition();
        }

    }
    public void outtakeDown(){
        Servo outtake = hardwareMap.get(Servo.class, "outtake");
        outtake.setDirection(Servo.Direction.REVERSE);
        outtake.setPosition(0.3);
    }
    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
        boolean isLeftObjectDetected;
        boolean isMiddleObjectDetected;
        boolean isRightObjectDetected;
        Servo holder = hardwareMap.get(Servo.class, "holder");
        Servo launcher = hardwareMap.get(Servo.class, "launcher");
        DigitalChannel color = hardwareMap.get(DigitalChannel.class, "color");
        DigitalChannel boardside = hardwareMap.get(DigitalChannel.class, "boardside");
        color.setMode(DigitalChannel.Mode.INPUT);
        boardside.setMode(DigitalChannel.Mode.INPUT);
        DistanceSensor left;
        //DistanceSensor middle;
        DistanceSensor right;
        left = hardwareMap.get(DistanceSensor.class, "distanceleft");
        //middle = hardwareMap.get(DistanceSensor.class, "distancemiddle");
        right = hardwareMap.get(DistanceSensor.class, "distanceright");
        Servo pusherarm = hardwareMap.get(Servo.class, "pusherarm");
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
        TrajectorySequence redboardsideright = drive.trajectorySequenceBuilder(new Pose2d(13.94, -62.17, Math.toRadians(90.00)))
                .lineTo(new Vector2d(24.00, -62.19))
                .lineTo(new Vector2d(23.55, -39.70))
                .addDisplacementMarker(() -> {
                    pusherarm.setPosition(1);
                })
                .waitSeconds(0.5)
                .lineTo(new Vector2d(35.62, -59.77))
                .lineTo(new Vector2d(36.08, -38.19))
                .lineToLinearHeading(new Pose2d(48.23, -36.57, Math.toRadians(0.00)))
                .addDisplacementMarker(() -> {
                    outtakeUp();
                })
                .waitSeconds(6)
                .addDisplacementMarker(() -> {
                    outtakeDown();
                })
                .waitSeconds(1)
                .lineTo(new Vector2d(35.43, -51.66))
                .splineToLinearHeading(new Pose2d(49.14, -58.97, Math.toRadians(0.00)), Math.toRadians(0.00))
                .build();

        TrajectorySequence redboardsidemiddle = drive.trajectorySequenceBuilder(new Pose2d(13.94, -62.17, Math.toRadians(90.00)))
                .lineTo(new Vector2d(11.77, -33.06))
                .addDisplacementMarker(() -> {
                    pusherarm.setPosition(1);
                })
                .waitSeconds(0.5)
                .lineTo(new Vector2d(24.30, -50.57))
                .lineTo(new Vector2d(37.74, -35.17))
                .lineToLinearHeading(new Pose2d(48.23, -36.57, Math.toRadians(0.00)))
                .addDisplacementMarker(() -> {
                    outtakeUp();
                })
                .waitSeconds(6)
                .addDisplacementMarker(() -> {
                    outtakeDown();
                })
                .waitSeconds(1)
                .lineTo(new Vector2d(35.43, -51.66))
                .splineToLinearHeading(new Pose2d(49.14, -58.97, Math.toRadians(0.00)), Math.toRadians(0.00))
                .build();

        TrajectorySequence redboardsideleft = drive.trajectorySequenceBuilder(new Pose2d(13.94, -62.17, Math.toRadians(90.00)))
                .lineTo(new Vector2d(23.25, -60.83))
                .lineTo(new Vector2d(23.25, -35.62))
                .splineTo(new Vector2d(9.5, -31.5), Math.toRadians(180.00))
                .addDisplacementMarker(() -> {
                    pusherarm.setPosition(1);
                })
                .waitSeconds(0.5)
                .lineTo(new Vector2d(31.09, -34.42))
                .lineToLinearHeading(new Pose2d(48.23, -36.57, Math.toRadians(0.00)))
                .addDisplacementMarker(() -> {
                    outtakeUp();
                })
                .waitSeconds(6)
                .addDisplacementMarker(() -> {
                    outtakeDown();
                })
                .waitSeconds(1)
                .lineTo(new Vector2d(35.43, -51.66))
                .splineToLinearHeading(new Pose2d(49.14, -58.97, Math.toRadians(0.00)), Math.toRadians(0.00))
                .build();

        TrajectorySequence redaudienceright = drive.trajectorySequenceBuilder(new Pose2d(-37.71, -61.94, Math.toRadians(90.00)))
                .lineTo(new Vector2d(-48.45, -61.13))
                .lineTo(new Vector2d(-48.30, -39.25))
                .splineTo(new Vector2d(-34.66, -34.87), Math.toRadians(0.00))
                .addDisplacementMarker(() -> {
                    pusherarm.setPosition(1);
                })
                .waitSeconds(0.5)
                .lineTo(new Vector2d(-51.17, -12.38))
                .lineTo(new Vector2d(-19.32, -10.11))
                .lineTo(new Vector2d(20.08, -30.04))
                .lineTo(new Vector2d(31.70, -54.19))
                .lineTo(new Vector2d(42.72, -60.68))
                .lineToLinearHeading(new Pose2d(48.23, -36.57, Math.toRadians(0.00)))
                .addDisplacementMarker(() -> {
                    outtakeUp();
                })
                .waitSeconds(6)
                .addDisplacementMarker(() -> {
                    outtakeDown();
                })
                .waitSeconds(1)
                .lineTo(new Vector2d(35.43, -51.66))
                .splineToLinearHeading(new Pose2d(49.14, -58.97, Math.toRadians(0.00)), Math.toRadians(0.00))
                .build();

        TrajectorySequence redaudiencemiddle = drive.trajectorySequenceBuilder(new Pose2d(-37.71, -61.94, Math.toRadians(90.00)))
                .lineTo(new Vector2d(-36.38, -33.21))
                .addDisplacementMarker(() -> {
                    pusherarm.setPosition(1);
                })
                .waitSeconds(0.5)
                .lineTo(new Vector2d(-57.36, -52.98))
                .lineTo(new Vector2d(-51.62, -13.13))
                .splineTo(new Vector2d(-32.60, -11.17), Math.toRadians(8.39))
                .lineTo(new Vector2d(-19.32, -10.11))
                .lineTo(new Vector2d(37.43, -12.08))
                .lineTo(new Vector2d(36.38, -51.62))
                .lineToLinearHeading(new Pose2d(48.23, -36.57, Math.toRadians(0.00)))
                .addDisplacementMarker(() -> {
                    outtakeUp();
                })
                .waitSeconds(6)
                .addDisplacementMarker(() -> {
                    outtakeDown();
                })
                .waitSeconds(1)
                .lineTo(new Vector2d(35.43, -51.66))
                .splineToLinearHeading(new Pose2d(49.14, -58.97, Math.toRadians(0.00)), Math.toRadians(0.00))
                .build();

        TrajectorySequence redaudienceleft = drive.trajectorySequenceBuilder(new Pose2d(-37.71, -61.94, Math.toRadians(90.00)))
                .lineTo(new Vector2d(-49.06, -62.04))
                .lineTo(new Vector2d(-47.40, -40.15))
                .addDisplacementMarker(() -> {
                    pusherarm.setPosition(1);
                })
                .waitSeconds(0.5)
                .lineTo(new Vector2d(-38.94, -57.81))
                .lineTo(new Vector2d(-33.36, -11.47))
                .lineTo(new Vector2d(3.47, -10.11))
                .lineTo(new Vector2d(34.11, -13.13))
                .lineTo(new Vector2d(36.08, -34.26))
                .lineToLinearHeading(new Pose2d(48.23, -36.57, Math.toRadians(0.00)))
                .addDisplacementMarker(() -> {
                    outtakeUp();
                })
                .waitSeconds(6)
                .addDisplacementMarker(() -> {
                    outtakeDown();
                })
                .waitSeconds(1)
                .lineTo(new Vector2d(35.43, -51.66))
                .splineToLinearHeading(new Pose2d(49.14, -58.97, Math.toRadians(0.00)), Math.toRadians(0.00))
                .build();

        TrajectorySequence blueboardsideright = drive.trajectorySequenceBuilder(new Pose2d(13.49, 62.17, Math.toRadians(-90.00)))
                .lineTo(new Vector2d(24.00, 60.23))
                .lineTo(new Vector2d(23.70, 31.70))
                .splineTo(new Vector2d(8.45, 33.66), Math.toRadians(178.59))
                .addDisplacementMarker(() -> {
                    pusherarm.setPosition(1);
                })
                .waitSeconds(0.5)
                .lineTo(new Vector2d(41.66, 33.51))
                .lineToLinearHeading(new Pose2d(48.00, 35.89, Math.toRadians(0.00)))
                .addDisplacementMarker(() -> {
                    outtakeUp();
                })
                .waitSeconds(6)
                .addDisplacementMarker(() -> {
                    outtakeDown();
                })
                .waitSeconds(1)
                .lineTo(new Vector2d(34.06, 52.80))
                .splineToLinearHeading(new Pose2d(48.23, 59.43, Math.toRadians(0.00)), Math.toRadians(0.00))
                .build();

        TrajectorySequence blueboardsidemiddle = drive.trajectorySequenceBuilder(new Pose2d(13.49, 62.17, Math.toRadians(-90.00)))
                .lineTo(new Vector2d(11.92, 32.75))
                .addDisplacementMarker(() -> {
                    pusherarm.setPosition(1);
                })
                .waitSeconds(0.5)
                .lineTo(new Vector2d(24.45, 50.11))
                .lineTo(new Vector2d(35.62, 40.00))
                .lineToLinearHeading(new Pose2d(48.00, 35.89, Math.toRadians(0.00)))
                .addDisplacementMarker(() -> {
                    outtakeUp();
                })
                .waitSeconds(6)
                .addDisplacementMarker(() -> {
                    outtakeDown();
                })
                .waitSeconds(1)
                .lineTo(new Vector2d(34.06, 52.80))
                .splineToLinearHeading(new Pose2d(48.23, 59.43, Math.toRadians(0.00)), Math.toRadians(0.00))
                .build();

        TrajectorySequence blueboardsideleft = drive.trajectorySequenceBuilder(new Pose2d(13.49, 62.17, Math.toRadians(-90.00)))
                .lineTo(new Vector2d(24.00, 60.83))
                .lineTo(new Vector2d(23.70, 40.91))
                .addDisplacementMarker(() -> {
                    pusherarm.setPosition(1);
                })
                .waitSeconds(0.5)
                .lineTo(new Vector2d(23.70, 54.34))
                .lineTo(new Vector2d(38.79, 40.91))
                .lineToLinearHeading(new Pose2d(48.00, 35.89, Math.toRadians(0.00)))
                .addDisplacementMarker(() -> {
                    outtakeUp();
                })
                .waitSeconds(6)
                .addDisplacementMarker(() -> {
                    outtakeDown();
                })
                .waitSeconds(1)
                .lineTo(new Vector2d(34.06, 52.80))
                .splineToLinearHeading(new Pose2d(48.23, 59.43, Math.toRadians(0.00)), Math.toRadians(0.00))
                .build();

        TrajectorySequence blueaudienceright = drive.trajectorySequenceBuilder(new Pose2d(-37.94, 60.80, Math.toRadians(-90.00)))
                .lineTo(new Vector2d(-48.15, 59.92))
                .lineTo(new Vector2d(-47.70, 40.75))
                .addDisplacementMarker(() -> {
                    pusherarm.setPosition(1);
                })
                .waitSeconds(0.5)
                .lineTo(new Vector2d(-38.04, 52.98))
                .lineTo(new Vector2d(-35.17, 28.38))
                .lineTo(new Vector2d(-34.87, 12.38))
                .splineTo(new Vector2d(1.21, 3.87), Math.toRadians(0.81))
                .lineTo(new Vector2d(35.02, 11.02))
                .lineTo(new Vector2d(36.08, 43.62))
                .lineToLinearHeading(new Pose2d(48.00, 35.89, Math.toRadians(0.00)))
                .addDisplacementMarker(() -> {
                    outtakeUp();
                })
                .waitSeconds(6)
                .addDisplacementMarker(() -> {
                    outtakeDown();
                })
                .waitSeconds(1)
                .lineTo(new Vector2d(34.06, 52.80))
                .splineToLinearHeading(new Pose2d(48.23, 59.43, Math.toRadians(0.00)), Math.toRadians(0.00))

                .build();

        TrajectorySequence blueaudiencemiddle = drive.trajectorySequenceBuilder(new Pose2d(-37.94, 60.80, Math.toRadians(-90.00)))
                .lineTo(new Vector2d(-35.92, 33.21))
                .addDisplacementMarker(() -> {
                    pusherarm.setPosition(1);
                })
                .waitSeconds(0.5)
                .lineTo(new Vector2d(-56.91, 58.11))
                .lineTo(new Vector2d(-52.08, 12.38))
                .splineTo(new Vector2d(-21.43, 5.72), Math.toRadians(-3.10))
                .lineTo(new Vector2d(11.77, 11.92))
                .lineTo(new Vector2d(35.62, 11.17))
                .lineTo(new Vector2d(35.77, 49.21))
                .lineToLinearHeading(new Pose2d(48.00, 35.89, Math.toRadians(0.00)))
                .addDisplacementMarker(() -> {
                    outtakeUp();
                })
                .waitSeconds(6)
                .addDisplacementMarker(() -> {
                    outtakeDown();
                })
                .waitSeconds(1)
                .lineTo(new Vector2d(34.06, 52.80))
                .splineToLinearHeading(new Pose2d(48.23, 59.43, Math.toRadians(0.00)), Math.toRadians(0.00))
                .build();

        TrajectorySequence blueaudienceleft = drive.trajectorySequenceBuilder(new Pose2d(-37.94, 60.80, Math.toRadians(-90.00)))
                .lineTo(new Vector2d(-48.15, 61.13))
                .lineTo(new Vector2d(-47.85, 33.96))
                .splineTo(new Vector2d(-34.65, 34.26), Math.toRadians(-1.19))
                .addDisplacementMarker(() -> {
                    pusherarm.setPosition(1);
                })
                .waitSeconds(0.5)
                .lineTo(new Vector2d(-51.02, 32.60))
                .lineTo(new Vector2d(-41.66, 5.89))
                .lineTo(new Vector2d(11.62, 1.98))
                .lineTo(new Vector2d(32.60, 4.98))
                .lineTo(new Vector2d(35.32, 32.15))
                .lineToLinearHeading(new Pose2d(48.00, 35.89, Math.toRadians(0.00)))
                .addDisplacementMarker(() -> {
                    outtakeUp();
                })
                .waitSeconds(6)
                .addDisplacementMarker(() -> {
                    outtakeDown();
                })
                .waitSeconds(1)
                .lineTo(new Vector2d(34.06, 52.80))
                .splineToLinearHeading(new Pose2d(48.23, 59.43, Math.toRadians(0.00)), Math.toRadians(0.00))
                .build();

        Servo outtake = hardwareMap.get(Servo.class, "outtake");
        outtake.setDirection(Servo.Direction.REVERSE);
        outtake.setPosition(0.3);
        pusherarm.setPosition(0);
        holder.setPosition(0.04);
        launcher.setPosition(0.7);
        waitForStart();
        double rightDistance = right.getDistance(DistanceUnit.CM);
        //double middleDistance = middle.getDistance(DistanceUnit.CM);
        double leftDistance = left.getDistance(DistanceUnit.CM);

        isRightObjectDetected = (rightDistance >= 36 && rightDistance <= 64);
        isLeftObjectDetected = (leftDistance >= 36 && leftDistance <= 64);
        //isMiddleObjectDetected = ((!isRightObjectDetected && !isLeftObjectDetected)&&((middleDistance >= 36 && middleDistance <= 100)));
        isMiddleObjectDetected = ((!isRightObjectDetected && !isLeftObjectDetected));

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