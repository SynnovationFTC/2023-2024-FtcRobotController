package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

import java.util.Objects;

@Autonomous
public class RobotFullAutonomous extends LinearOpMode {

    static void pixelOnBoard() {
        //outtake a pixel on the board
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
        waitForStart();
        double rightDistance = right.getDistance(DistanceUnit.CM);
        double middleDistance = middle.getDistance(DistanceUnit.CM);
        double leftDistance = left.getDistance(DistanceUnit.CM);

        isRightObjectDetected = (rightDistance >= 36 && rightDistance <= 64);
        isMiddleObjectDetected = (middleDistance >= 36 && middleDistance <= 100);
        isLeftObjectDetected = (leftDistance >= 36 && leftDistance <= 64);


        while (opModeIsActive()) {
            if (runCount < 1) {
                if (Objects.equals(side, "board")) {
                    if (Objects.equals(colorvalue, "red")) {
                        if (isRightObjectDetected) {
                            //run red boardside right
                            pixelOnBoard();
                            runCount = runCount + 1;

                        } else if (isMiddleObjectDetected) {
                            //run red boardside middle
                            pixelOnBoard();
                            runCount = runCount + 1;
                        } else if (isLeftObjectDetected) {
                            //run red boardside left
                            pixelOnBoard();
                            runCount = runCount + 1;
                        }
                    } else if (Objects.equals(colorvalue, "blue")) {
                        if (isRightObjectDetected) {
                            //run blue boardside right
                            pixelOnBoard();
                            runCount = runCount + 1;
                        } else if (isMiddleObjectDetected) {
                            //run blue boardside middle
                            pixelOnBoard();
                            runCount = runCount + 1;
                        } else if (isLeftObjectDetected) {
                            //run blue boardside left
                            pixelOnBoard();
                            runCount = runCount + 1;
                        }
                    }
                } else if (Objects.equals(side, "audience")) {
                    if (Objects.equals(colorvalue, "red")) {
                        if (isRightObjectDetected) {
                            //run red audience right
                            pixelOnBoard();
                            runCount = runCount + 1;

                        } else if (isMiddleObjectDetected) {
                            //run red audience middle
                            pixelOnBoard();
                            runCount = runCount + 1;
                        } else if (isLeftObjectDetected) {
                            //run red audience left
                            pixelOnBoard();
                            runCount = runCount + 1;
                        }
                    } else if (Objects.equals(colorvalue, "blue")) {
                        if (isRightObjectDetected) {
                            //run blue audience right
                            pixelOnBoard();
                            runCount = runCount + 1;
                        } else if (isMiddleObjectDetected) {
                            //run blue audience middle
                            pixelOnBoard();
                            runCount = runCount + 1;
                        } else if (isLeftObjectDetected) {
                            //run blue audience left
                            pixelOnBoard();
                            runCount = runCount + 1;
                        }
                    }
                }
            }
        }
    }
}