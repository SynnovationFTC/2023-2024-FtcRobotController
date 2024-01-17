package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

/*
 * This is an example of a more complex path to really test the tuning.
 */
@Autonomous(group = "drive")
public class RRSplineTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
        Pose2d startPose = new Pose2d(11.08, -61.62, Math.toRadians(90.00));
        TrajectorySequence traj = drive.trajectorySequenceBuilder(new Pose2d(11.66, -62.17, Math.toRadians(90.00)))
                .splineTo(new Vector2d(11.66, -32.91), Math.toRadians(90.00))
                .lineToLinearHeading(new Pose2d(25.60, -53.71, Math.toRadians(-27.91)))
                .splineTo(new Vector2d(50.51, -29.71), Math.toRadians(0.00))
                .build();
        drive.setPoseEstimate(traj.start());
        /*
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
