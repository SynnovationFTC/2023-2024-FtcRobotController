package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;

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
        Servo top = hardwareMap.get(Servo.class, "topservo");
        top.setDirection(Servo.Direction.REVERSE);
        Servo bottom = hardwareMap.get(Servo.class, "bottomservo");
        Servo door = hardwareMap.get(Servo.class, "doorservo");
        door.setDirection(Servo.Direction.REVERSE);
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
        double i = 1;

        while (opModeIsActive()) {
             i += 1;
            if (i==1) {
                telemetry.addData("Status", "Running");

                double leftdistance = left.getDistance(DistanceUnit.CM);
                telemetry.addData("deviceName", left.getDeviceName());
                telemetry.addData("left", String.format("%.01f cm", leftdistance));
                isLeftObjectDetected = (leftdistance >= 36 && leftdistance <= 64);
                if (isLeftObjectDetected) {
                    TrajectorySequence trajleft = drive.trajectorySequenceBuilder(new Pose2d(-36.98, -62.34, Math.toRadians(90.00)))
                            .splineTo(new Vector2d(-47.40, -38.04), Math.toRadians(90.00))
                            .lineTo(new Vector2d(-35.02, -61.89))
                            .splineTo(new Vector2d(-35.02, -23.70), Math.toRadians(91.46))
                            .splineTo(new Vector2d(-27.92, -11.32), Math.toRadians(-2.73))
                            .splineTo(new Vector2d(10.11, -11.62), Math.toRadians(-0.45))
                            .splineTo(new Vector2d(33.21, -14.94), Math.toRadians(-8.18))
                            .splineTo(new Vector2d(35.02, -35.92), Math.toRadians(-85.07))
                            .splineTo(new Vector2d(49.51, -30.79), Math.toRadians(1.68))
                            .build();
                    drive.setPoseEstimate(trajleft.start());
                    drive.followTrajectorySequence(trajleft);
                }


                double rightdistance = right.getDistance(DistanceUnit.CM);
                telemetry.addData("deviceName", right.getDeviceName());
                telemetry.addData("right", String.format("%.01f cm", rightdistance));
                isRightObjectDetected = (rightdistance >= 36 && rightdistance <= 64);
                if (isRightObjectDetected) {
                    TrajectorySequence trajright = drive.trajectorySequenceBuilder(new Pose2d(-36.38, -59.32, Math.toRadians(90.00)))
                            .splineTo(new Vector2d(-56.60, -48.45), Math.toRadians(151.75))
                            .splineTo(new Vector2d(-47.40, -35.92), Math.toRadians(6.17))
                            .splineTo(new Vector2d(-30.49, -36.08), Math.toRadians(0.00))
                            .lineToLinearHeading(new Pose2d(-53.43, -12.68, Math.toRadians(0.00)))
                            .splineTo(new Vector2d(-16.75, -12.08), Math.toRadians(6.61))
                            .splineTo(new Vector2d(13.13, -15.55), Math.toRadians(-6.63))
                            .splineTo(new Vector2d(28.98, -30.19), Math.toRadians(-42.73))
                            .splineTo(new Vector2d(47.85, -31.40), Math.toRadians(0.00))
                            .build();
                    drive.setPoseEstimate(trajright.start());
                    drive.followTrajectorySequence(trajright);
                double middledistance = middle.getDistance(DistanceUnit.CM);
                telemetry.addData("deviceName", middle.getDeviceName());
                telemetry.addData("middle", String.format("%.01f cm", middledistance));
                isMiddleObjectDetected = (middledistance >= 36 && middledistance <= 7000);
                if (isMiddleObjectDetected) {
                    TrajectorySequence trajmiddle = drive.trajectorySequenceBuilder(new Pose2d(-36.08, -62.79, Math.toRadians(90.00)))
                            .splineTo(new Vector2d(-35.92, -32.75), Math.toRadians(90.00))

                            .lineTo(new Vector2d(-48.91, -48.46))
                            .lineTo(new Vector2d(-56.00, -24.46))
                            .splineTo(new Vector2d(22.17, -5.94), Math.toRadians(6.18))
                            .splineTo(new Vector2d(49.21, -30.64), Math.toRadians(0.00))
                            .build();
                    drive.setPoseEstimate(trajmiddle.start());
                    drive.followTrajectorySequence(trajmiddle);
                }

                }
                telemetry.addData("Object Detected (Left)", isLeftObjectDetected);
                telemetry.addData("Object Detected (Middle)", isMiddleObjectDetected);
                telemetry.addData("Object Detected (Right)", isRightObjectDetected);

                telemetry.update();
            };

        }
    }

}
