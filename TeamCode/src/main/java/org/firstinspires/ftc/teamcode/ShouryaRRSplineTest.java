package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

/*
 * This is an example of a more complex path to really test the tuning.
 */
@Autonomous(group = "drive")
public class ShouryaRRSplineTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
        Pose2d startPose = new Pose2d(11.08, -61.62, Math.toRadians(90.00));
        TrajectorySequence traj = drive.trajectorySequenceBuilder(new Pose2d(-36.23, -61.85, Math.toRadians(90.00)))
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
        drive.setPoseEstimate(traj.start());       /*
        TrajectorySequence traj = drive.trajectorySequenceBuilder(startPose)
                .splineTo(new Vector2d(11.08, -33.92), Math.toRadians(90.00))
                .splineTo(new Vector2d(10.85, -53.77), Math.toRadians(269.33))
                .splineTo(new Vector2d(37.38, -51.00), Math.toRadians(5.96))
                .splineTo(new Vector2d(48.46, -35.31), Math.toRadians(-2.91))
                .build();
 */
        waitForStart();
        if (isStopRequested()) return;
        drive.followTrajectorySequence(traj);
    }
}
