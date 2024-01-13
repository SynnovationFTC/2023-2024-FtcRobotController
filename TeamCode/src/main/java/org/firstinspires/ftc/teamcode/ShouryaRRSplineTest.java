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
            isLeftObjectDetected = (leftdistance >= 36 && leftdistance <= 64);
            if (isLeftObjectDetected) {
                TrajectorySequence trajleft = drive.trajectorySequenceBuilder(new Pose2d(-37.94, -60.34, Math.toRadians(90.00)))
                        .splineTo(new Vector2d(-48.23, -46.40), Math.toRadians(126.42))
                        .splineTo(new Vector2d(-48.00, -37.03), Math.toRadians(87.75))
                        .lineTo(new Vector2d(-58.74, -61.26))
                        .splineTo(new Vector2d(-24.23, -59.89), Math.toRadians(2.28))
                        .splineTo(new Vector2d(-3.66, -60.80), Math.toRadians(-2.54))
                        .splineTo(new Vector2d(7.54, -59.89), Math.toRadians(4.67))
                        .splineTo(new Vector2d(21.26, -53.49), Math.toRadians(25.02))
                        .splineTo(new Vector2d(33.60, -40.00), Math.toRadians(16.56))
                        .splineTo(new Vector2d(48.69, -36.34), Math.toRadians(13.63))
                        .build();
                drive.setPoseEstimate(trajleft.start());
                drive.followTrajectorySequence(trajleft);
            }



            double rightdistance = right.getDistance(DistanceUnit.CM);
            telemetry.addData("deviceName", right.getDeviceName());
            telemetry.addData("right", String.format("%.01f cm", rightdistance));
            isRightObjectDetected = (rightdistance >= 36 && rightdistance <= 64);
            if (isRightObjectDetected) {
                TrajectorySequence trajright = drive.trajectorySequenceBuilder(new Pose2d(-36.57, -60.11, Math.toRadians(90.00)))
                        .splineTo(new Vector2d(-53.49, -52.57), Math.toRadians(155.97))
                        .splineTo(new Vector2d(-43.66, -36.11), Math.toRadians(0.00))
                        .splineTo(new Vector2d(-31.09, -34.97), Math.toRadians(10.49))
                        .lineTo(new Vector2d(-58.97, -61.03))
                        .splineTo(new Vector2d(-17.60, -59.43), Math.toRadians(2.21))
                        .splineTo(new Vector2d(13.26, -58.97), Math.toRadians(3.12))
                        .splineTo(new Vector2d(34.29, -38.40), Math.toRadians(9.21))
                        .splineTo(new Vector2d(49.14, -36.57), Math.toRadians(6.84))
                        .build();
                drive.setPoseEstimate(trajright.start());
                drive.followTrajectorySequence(trajright);
            double middledistance = middle.getDistance(DistanceUnit.CM);
            telemetry.addData("deviceName", middle.getDeviceName());
            telemetry.addData("middle", String.format("%.01f cm", middledistance));
            isMiddleObjectDetected = (middledistance >= 36 && middledistance <= 7000);
            if (isMiddleObjectDetected){
                TrajectorySequence trajmiddle = drive.trajectorySequenceBuilder(new Pose2d(-36.57, -60.34, Math.toRadians(90.00)))
                        .splineTo(new Vector2d(-36.34, -32.91), Math.toRadians(90.40))
                        .lineTo(new Vector2d(-48.91, -48.46))
                        .lineTo(new Vector2d(-56.00, -24.46))
                        .splineTo(new Vector2d(22.17, -5.94), Math.toRadians(6.18))
                        .splineTo(new Vector2d(48.46, -36.34), Math.toRadians(2.54))
                        .build();
                drive.setPoseEstimate(trajmiddle.start());
                drive.followTrajectorySequence(trajmiddle);}
                break;
            }
            telemetry.addData("Object Detected (Left)", isLeftObjectDetected);
            telemetry.addData("Object Detected (Middle)", isMiddleObjectDetected);
            telemetry.addData("Object Detected (Right)", isRightObjectDetected);

            telemetry.update();

        }
    }

}
