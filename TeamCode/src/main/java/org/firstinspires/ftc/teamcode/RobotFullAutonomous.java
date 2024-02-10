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
    public void outtakeUp() {
        Servo outtake = hardwareMap.get(Servo.class, "outtake");
        outtake.setDirection(Servo.Direction.REVERSE);
        double upservoIncrement = 0.00075;
        double upnewservoposition = 0.3;
        while (upnewservoposition < 0.845) {
            upnewservoposition = (upnewservoposition + upservoIncrement);
            outtake.setPosition(upnewservoposition);
            //sleep(50);
        }

    }

    public void outtakeDown() {
        Servo outtake = hardwareMap.get(Servo.class, "outtake");
        outtake.setDirection(Servo.Direction.REVERSE);
        double downservoIncrement = 0.001;
        double downnewservoposition = 0.845;
        while (downnewservoposition > 0.0875) {
            downnewservoposition = (downnewservoposition - downservoIncrement);
            outtake.setPosition(downnewservoposition);
            //sleep(25);
        }
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
        Servo outtake = hardwareMap.get(Servo.class, "outtake");
        outtake.setDirection(Servo.Direction.REVERSE);
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
        //TODO: Add outtake to all paths
        //TODO: Fix blueaudience parking
        TrajectorySequence redboardsideright = drive.trajectorySequenceBuilder(new Pose2d(13.94, -62.17, Math.toRadians(90.00)))
                .lineTo(new Vector2d(24.00, -62.19))
                .lineTo(new Vector2d(23.55, -39.70))
                .addDisplacementMarker(() -> {
                    pusherarm.setPosition(1);
                })
                .waitSeconds(0.5)
                .lineTo(new Vector2d(35.62, -59.77))
                .lineTo(new Vector2d(36.08, -38.19))
                .addDisplacementMarker(() -> {
                    outtakeUp();
                })
                .waitSeconds(0.5)
                .lineToLinearHeading(new Pose2d(48.23, -36.57, Math.toRadians(0.00)))
                .addDisplacementMarker(() -> {
                    outtakeDown();
                })
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
                .lineTo(new Vector2d(35.43, -51.66))
                .splineToLinearHeading(new Pose2d(49.14, -58.97, Math.toRadians(0.00)), Math.toRadians(0.00))
                .build();

        TrajectorySequence redboardsideleft = drive.trajectorySequenceBuilder(new Pose2d(13.94, -62.17, Math.toRadians(90.00)))
                .lineTo(new Vector2d(23.25, -60.83))
                .lineTo(new Vector2d(23.25, -35.62))
                .splineTo(new Vector2d(11.125, -31.5), Math.toRadians(180.00))
                .addDisplacementMarker(() -> {
                    pusherarm.setPosition(1);
                })
                .waitSeconds(0.5)
                .lineTo(new Vector2d(31.09, -34.42))
                .lineToLinearHeading(new Pose2d(48.23, -36.57, Math.toRadians(0.00)))
                .lineTo(new Vector2d(35.43, -51.66))
                .splineToLinearHeading(new Pose2d(49.14, -58.97, Math.toRadians(0.00)), Math.toRadians(0.00))
                .build();

        TrajectorySequence redaudienceright = drive.trajectorySequenceBuilder(new Pose2d(-36.83, -62.19, Math.toRadians(90.00)))
                //TODO: Pixel placement point isn't right
                .lineTo(new Vector2d(-48.15, -61.89))
                .lineTo(new Vector2d(-46.19, -43.62))
                .splineTo(new Vector2d(-32.91, -36.08), Math.toRadians(0.00))
                .addDisplacementMarker(() -> {
                    pusherarm.setPosition(1);
                })
                .lineTo(new Vector2d(-52.08, -9.21))
                .lineTo(new Vector2d(10.72, -3.17))
                .lineTo(new Vector2d(40.00, -12.00))
                .lineToLinearHeading(new Pose2d(40.00, -35.00, 0))
                .lineTo(new Vector2d(40.00, -60.00))
                .lineTo(new Vector2d(54.00, -60.00))
                .build();

        TrajectorySequence redaudiencemiddle = drive.trajectorySequenceBuilder(new Pose2d(-36.98, -62.04, Math.toRadians(90.00)))
                .lineTo(new Vector2d(-36.68, -32.91))
                .addDisplacementMarker(() -> {
                    pusherarm.setPosition(1);
                })
                .lineTo(new Vector2d(-56.15, -50.42))
                .lineTo(new Vector2d(-52.23, -9.06))
                .splineTo(new Vector2d(-12.68, -6.49), Math.toRadians(1.39))
                .lineTo(new Vector2d(27.02, -7.25))
                .lineTo(new Vector2d(36.38, -26.57))
                .lineTo(new Vector2d(42.87, -35.77))
                .lineTo(new Vector2d(43.32, -58.87))
                .build();
        TrajectorySequence redaudienceleft = drive.trajectorySequenceBuilder(new Pose2d(-36.83, -62.19, Math.toRadians(90.00)))
                .lineTo(new Vector2d(-48.15, -61.89))
                .lineTo(new Vector2d(-47.40, -40.75))
                .addDisplacementMarker(() -> {
                    pusherarm.setPosition(1);
                })
                .lineTo(new Vector2d(-35.43, -52.11))
                .lineTo(new Vector2d(-34.06, -24.46))
                .splineTo(new Vector2d(-29.49, -11.43), Math.toRadians(-6.29))
                .splineTo(new Vector2d(12.34, -11.89), Math.toRadians(0.00))
                .lineTo(new Vector2d(40.00, -12.00))
                .lineTo(new Vector2d(40.00, -35.00))
                .lineTo(new Vector2d(40.00, -60.00))
                .lineTo(new Vector2d(54.00, -60.00))
                .build();

        TrajectorySequence blueboardsideright = drive.trajectorySequenceBuilder(new Pose2d(13.49, 62.17, Math.toRadians(-90.00)))
                //TODO: Change Parking Location
                .lineTo(new Vector2d(24.00, 60.23))
                .lineTo(new Vector2d(23.70, 31.70))
                .splineTo(new Vector2d(8.45, 33.66), Math.toRadians(178.59))
                .addDisplacementMarker(() -> {
                    pusherarm.setPosition(1);
                })
                .waitSeconds(0.5)
                .lineTo(new Vector2d(47.09, 32.75))
                .lineTo(new Vector2d(45.13, 57.36))
                .lineTo(new Vector2d(50.72, 58.57))

                .build();

        TrajectorySequence blueboardsidemiddle = drive.trajectorySequenceBuilder(new Pose2d(13.49, 62.17, Math.toRadians(-90.00)))
                //TODO: Change Parking Location
                .lineTo(new Vector2d(11.92, 32.75))
                .addDisplacementMarker(() -> {
                    pusherarm.setPosition(1);
                })
                .waitSeconds(0.5)
                .lineTo(new Vector2d(24.45, 50.11))
                .lineTo(new Vector2d(35.62, 40.00))
                .lineTo(new Vector2d(47.09, 32.75))
                .lineTo(new Vector2d(45.13, 57.36))
                .splineToLinearHeading(new Pose2d(50.72, 58.57, Math.toRadians(0.00)), Math.toRadians(0.00))

                .build();

        TrajectorySequence blueboardsideleft = drive.trajectorySequenceBuilder(new Pose2d(13.49, 62.17, Math.toRadians(-90.00)))
                //TODO: Change Parking Location
                .lineTo(new Vector2d(24.00, 60.83))
                .lineTo(new Vector2d(23.70, 40.91))
                .addDisplacementMarker(() -> {
                    pusherarm.setPosition(1);
                })
                .waitSeconds(0.5)
                .lineTo(new Vector2d(23.70, 54.34))
                .lineTo(new Vector2d(38.79, 40.91))
                .lineTo(new Vector2d(47.09, 32.75))
                .lineTo(new Vector2d(45.13, 57.36))
                .splineToLinearHeading(new Pose2d(50.72, 58.57, Math.toRadians(0.00)), Math.toRadians(0.00))

                .build();

        TrajectorySequence blueaudienceright = drive.trajectorySequenceBuilder(new Pose2d(-37.94, 60.80, Math.toRadians(-90.00)))
                //TODO: Change Parking Location
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
                .lineTo(new Vector2d(42.87, 35.77))
                .lineTo(new Vector2d(41.81, 58.87))


                .build();

        TrajectorySequence blueaudiencemiddle = drive.trajectorySequenceBuilder(new Pose2d(-37.94, 60.80, Math.toRadians(-90.00)))
                //TODO: Change Parking Location
                .lineTo(new Vector2d(-35.92, 33.21))
                .addDisplacementMarker(() -> {
                    pusherarm.setPosition(1);
                })
                .waitSeconds(0.5)
                .lineTo(new Vector2d(-56.91, 51.11))
                .lineTo(new Vector2d(-52.08, 12.38))
                .splineTo(new Vector2d(-21.43, 5.72), Math.toRadians(-3.10))
                .lineTo(new Vector2d(11.77, 11.92))
                .lineTo(new Vector2d(35.62, 11.17))
                .lineTo(new Vector2d(35.77, 49.21))
                .lineTo(new Vector2d(42.87, 35.77))
                .lineTo(new Vector2d(41.81, 58.87))

                .build();

        TrajectorySequence blueaudienceleft = drive.trajectorySequenceBuilder(new Pose2d(-37.94, 60.80, Math.toRadians(-90.00)))
                //TODO: Change Parking Location
                // TODO: When it is placing the pixel on the mark, it isn't going far enough
                .lineTo(new Vector2d(-48.15, 61.13))
                .lineTo(new Vector2d(-47.85, 33.96))
                .splineTo(new Vector2d(-32.15, 35.62), Math.toRadians(0.00))
                .addDisplacementMarker(() -> {
                    pusherarm.setPosition(1);
                })
                .waitSeconds(0.5)
                .lineTo(new Vector2d(-51.02, 32.60))
                .lineTo(new Vector2d(-41.66, 5.89))
                .lineTo(new Vector2d(11.62, 1.98))
                .lineTo(new Vector2d(32.60, 4.98))
                .lineTo(new Vector2d(42.87, 35.77))
                .lineTo(new Vector2d(41.81, 58.87))

                .build();

        outtake.setPosition(0.3);
        pusherarm.setPosition(0);
        holder.setPosition(0.04);
        launcher.setPosition(0.7);
        waitForStart();
        double rightDistance = right.getDistance(DistanceUnit.CM);
        //double middleDistance = middle.getDistance(DistanceUnit.CM);
        double leftDistance = left.getDistance(DistanceUnit.CM);

        isRightObjectDetected = (rightDistance >= 43 && rightDistance <= 59);
        isLeftObjectDetected = (leftDistance >= 45 && leftDistance <= 59);
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
                    if (isRightObjectDetected || gamepad1.b) {
                        telemetry.addData("Object Detected:", "Right");
                        telemetry.update();
                        drive.setPoseEstimate(redboardsideright.start());
                        drive.followTrajectorySequence(redboardsideright);
                        break;
                    } else if (isMiddleObjectDetected || gamepad1.y) {
                        telemetry.addData("Object Detected:", "Middle");
                        telemetry.update();
                        drive.setPoseEstimate(redboardsidemiddle.start());
                        drive.followTrajectorySequence(redboardsidemiddle);
                        break;
                    } else if (isLeftObjectDetected || gamepad1.x) {
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
                    if (isRightObjectDetected || gamepad1.b) {
                        telemetry.addData("Object Detected:", "Right");
                        telemetry.update();
                        drive.setPoseEstimate(blueboardsideright.start());
                        drive.followTrajectorySequence(blueboardsideright);
                        break;
                    } else if (isMiddleObjectDetected || gamepad1.y) {
                        telemetry.addData("Object Detected:", "Middle");
                        telemetry.update();
                        drive.setPoseEstimate(blueboardsidemiddle.start());
                        drive.followTrajectorySequence(blueboardsidemiddle);
                        break;
                    } else if (isLeftObjectDetected || gamepad1.x) {
                        telemetry.addData("Object Detected:", "Left");
                        telemetry.update();
                        drive.setPoseEstimate(blueboardsideleft.start());
                        drive.followTrajectorySequence(blueboardsideleft);
                        break;
                    }
                }
            } else if (Objects.equals(side, "audience")) {
                if (Objects.equals(colorvalue, "red")) {
                    if (isRightObjectDetected || gamepad1.b) {
                        telemetry.addData("Object Detected:", "Right");
                        telemetry.update();
                        drive.setPoseEstimate(redaudienceright.start());
                        drive.followTrajectorySequence(redaudienceright);
                        break;
                    } else if (isMiddleObjectDetected || gamepad1.y) {
                        telemetry.addData("Object Detected:", "Middle");
                        telemetry.update();
                        drive.setPoseEstimate(redaudiencemiddle.start());
                        drive.followTrajectorySequence(redaudiencemiddle);
                        break;
                    } else if (isLeftObjectDetected || gamepad1.x) {
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
                    if (isRightObjectDetected || gamepad1.b) {
                        telemetry.addData("Object Detected:", "Right");
                        telemetry.update();
                        drive.setPoseEstimate(blueaudienceright.start());
                        drive.followTrajectorySequence(blueaudienceright);
                        break;
                    } else if (isMiddleObjectDetected || gamepad1.y) {
                        telemetry.addData("Object Detected:", "Middle");
                        telemetry.update();
                        drive.setPoseEstimate(blueaudiencemiddle.start());
                        drive.followTrajectorySequence(blueaudiencemiddle);
                        break;
                    } else if (isLeftObjectDetected || gamepad1.x) {
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