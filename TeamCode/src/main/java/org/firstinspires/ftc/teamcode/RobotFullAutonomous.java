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

    void initOuttake() {
        Servo top = hardwareMap.get(Servo.class, "topservo");
        Servo bottom = hardwareMap.get(Servo.class, "bottomservo");
        Servo door = hardwareMap.get(Servo.class, "doorservo");
        door.setDirection(Servo.Direction.REVERSE);
        top.setDirection(Servo.Direction.REVERSE);
        door.setPosition(0.01);
        bottom.setPosition(0.08);
        sleep(550);
        top.setPosition(0.23);
        bottom.setPosition(0.4);
        sleep(50);
        top.setPosition(0.35);
        bottom.setPosition(0.74);
    }

    void releaseOuttake() {
        Servo top = hardwareMap.get(Servo.class, "topservo");
        Servo bottom = hardwareMap.get(Servo.class, "bottomservo");
        Servo door = hardwareMap.get(Servo.class, "doorservo");
        door.setDirection(Servo.Direction.REVERSE);
        top.setDirection(Servo.Direction.REVERSE);
        door.setPosition(0.27);
    }

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
        //DistanceSensor middle;
        DistanceSensor right;
        left = hardwareMap.get(DistanceSensor.class, "distanceleft");
        //middle = hardwareMap.get(DistanceSensor.class, "distancemiddle");
        right = hardwareMap.get(DistanceSensor.class, "distanceright");
        Servo top = hardwareMap.get(Servo.class, "topservo");
        Servo bottom = hardwareMap.get(Servo.class, "bottomservo");
        Servo door = hardwareMap.get(Servo.class, "doorservo");
        door.setDirection(Servo.Direction.REVERSE);
        top.setDirection(Servo.Direction.REVERSE);

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
        TrajectorySequence redboardsideright = drive.trajectorySequenceBuilder(new Pose2d(12.50, -61.50, Math.toRadians(90.00))).lineToLinearHeading(new Pose2d(22.63, -57.60, Math.toRadians(90.00))).lineToLinearHeading(new Pose2d(23.31, -41.14, Math.toRadians(90.00))).lineToLinearHeading(new Pose2d(23.09, -57.60, Math.toRadians(90.00))).splineTo(new Vector2d(38.63, -57.37), Math.toRadians(0.84)).addDisplacementMarker(() -> {
            initOuttake();
        }).splineToLinearHeading(new Pose2d(48.91, -39.77, Math.toRadians(0.00)), Math.toRadians(0.00)).waitSeconds(0.5).addDisplacementMarker(() -> {
            releaseOuttake();
        }).build();
        TrajectorySequence redboardsidemiddle = drive.trajectorySequenceBuilder(new Pose2d(12.50, -61.50, Math.toRadians(90.00))).lineToLinearHeading(new Pose2d(12.34, -33.83, Math.toRadians(90.00))).lineTo(new Vector2d(14.17, -52.11)).splineTo(new Vector2d(35.89, -52.57), Math.toRadians(-1.21)).addDisplacementMarker(() -> {
            initOuttake();
        }).splineTo(new Vector2d(39.09, -38.63), Math.toRadians(77.07)).splineToLinearHeading(new Pose2d(48.6, -32.23, Math.toRadians(0.00)), Math.toRadians(0.00)).addDisplacementMarker(() -> {
            releaseOuttake();
        }).build();
        TrajectorySequence redboardsideleft = drive.trajectorySequenceBuilder(new Pose2d(12.50, -61.50, Math.toRadians(90.00))).splineTo(new Vector2d(30.86, -37.03), Math.toRadians(53.12)).splineTo(new Vector2d(9.37, -30.63), Math.toRadians(180.00)).lineToLinearHeading(new Pose2d(33.14, -32.00, Math.toRadians(180.00))).addDisplacementMarker(() -> {
            initOuttake();
        }).lineToLinearHeading(new Pose2d(48.60, -27.20, Math.toRadians(0.00))).addDisplacementMarker(() -> {
            releaseOuttake();
        }).build();
        TrajectorySequence redaudiencesideright = drive.trajectorySequenceBuilder(new Pose2d(-36.00, -61.50, Math.toRadians(90.00))).lineTo(new Vector2d(-51.20, -34.74)).lineToLinearHeading(new Pose2d(-34.06, -30.40, Math.toRadians(0.00))).lineTo(new Vector2d(-51.89, -30.63)).splineTo(new Vector2d(-51.43, -11.89), Math.toRadians(90.00)).splineTo(new Vector2d(-31.31, -10.00), Math.toRadians(0.00)).splineTo(new Vector2d(18.29, -10.00), Math.toRadians(0.00)).addDisplacementMarker(() -> {
            initOuttake();
        }).splineTo(new Vector2d(38.86, -16.91), Math.toRadians(-43.94)).splineToLinearHeading(new Pose2d(49.00, -39.50, Math.toRadians(0.00)), Math.toRadians(0.00)).addDisplacementMarker(() -> {
            releaseOuttake();
        }).build();
        


        waitForStart();
        double rightDistance = right.getDistance(DistanceUnit.CM);
        //double middleDistance = middle.getDistance(DistanceUnit.CM);
        double leftDistance = left.getDistance(DistanceUnit.CM);

        isRightObjectDetected = (rightDistance >= 36 && rightDistance <= 64);
        //isMiddleObjectDetected = (middleDistance >= 36 && middleDistance <= 100);
        //isMiddleObjectDetected =
        isLeftObjectDetected = (leftDistance >= 36 && leftDistance <= 64);


        while (opModeIsActive()) {
            if (Objects.equals(side, "board")) {

                if (Objects.equals(colorvalue, "red")) {
                    if (isRightObjectDetected) {
                        drive.setPoseEstimate(redboardsideright.start());
                        //run red boardside right
                        drive.followTrajectorySequence(redboardsideright);
                        break;
                    } else if (!isRightObjectDetected && isLeftObjectDetected) {
                        //run red boardside middle
                        //pause in the middle of the path
                        initOuttake();
                        //continue path
                        //after path is complete
                        releaseOuttake();
                        runCount = runCount + 1;
                        break;
                    } else if (isLeftObjectDetected) {
                        //run red boardside left
                        //pause in the middle of the path
                        initOuttake();
                        //continue path
                        //after path is complete
                        //releaseOuttake();
                        //runCount = runCount + 1;
                        //break;
                        //}
                    } else if (Objects.equals(colorvalue, "blue")) {
                        if (isRightObjectDetected) {
                            //run blue boardside right
                            //pause in the middle of the path
                            initOuttake();
                            //continue path
                            //after path is complete
                            releaseOuttake();
                            runCount = runCount + 1;
                            break;
                        } else if (!isRightObjectDetected && isLeftObjectDetected) {
                            //run blue boardside middle
                            //pause in the middle of the path
                            initOuttake();
                            //continue path
                            //after path is complete
                            releaseOuttake();
                            runCount = runCount + 1;
                            break;
                        } else if (isLeftObjectDetected) {
                            //run blue boardside left
                            //pause in the middle of the path
                            initOuttake();
                            //continue path
                            //after path is complete
                            releaseOuttake();
                            //runCount = runCount + 1;
                            break;
                            //}
                        }
                    } else if (Objects.equals(side, "audience")) {
                        if (Objects.equals(colorvalue, "red")) {
                            if (isRightObjectDetected) {
                                //run red audience right
                                //pause in the middle of the path
                                initOuttake();
                                //continue path
                                //after path is complete
                                releaseOuttake();
                                runCount = runCount + 1;
                                break;
                            } else if (!isRightObjectDetected && isLeftObjectDetected) {
                                //run red audience middle
                                //pause in the middle of the path
                                initOuttake();
                                //continue path
                                //after path is complete
                                releaseOuttake();
                                runCount = runCount + 1;
                                break;
                            } else if (isLeftObjectDetected) {
                                //run red audience left
                                //pause in the middle of the path
                                initOuttake();
                                //continue path
                                //after path is complete
                                releaseOuttake();
                                runCount = runCount + 1;
                                break;
                            }
                        } else if (Objects.equals(colorvalue, "blue")) {
                            if (isRightObjectDetected) {
                                //run blue audience right
                                //pause in the middle of the path
                                initOuttake();
                                //continue path
                                //after path is complete
                                releaseOuttake();
                                runCount = runCount + 1;
                                break;
                            } else if (!isRightObjectDetected && isLeftObjectDetected) {
                                //run blue audience middle
                                //pause in the middle of the path
                                initOuttake();
                                //continue path
                                //after path is complete
                                releaseOuttake();
                                runCount = runCount + 1;
                                break;
                            } else if (isLeftObjectDetected) {
                                //run blue audience left
                                //TODO pause in the middle of the path
                                initOuttake();
                                //TODO continue path
                                //TODO after path is complete
                                releaseOuttake();
                                runCount = runCount + 1;
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
}