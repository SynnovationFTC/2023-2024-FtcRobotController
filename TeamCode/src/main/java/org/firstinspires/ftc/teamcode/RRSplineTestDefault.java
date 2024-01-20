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
public class RRSplineTestDefault extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
        Pose2d startPose = new Pose2d(11.08, -61.62, Math.toRadians(90.00));
        int x=0;
        x+=1;
        waitForStart();
        if (x==1){
            TrajectorySequence untitled0 = drive.trajectorySequenceBuilder(new Pose2d(11.02, -60.38, Math.toRadians(90.00)))
                    .lineTo(new Vector2d(23.09, -60.08))
                    .lineTo(new Vector2d(23.25, -36.38))
                    .lineTo(new Vector2d(37.43, -60.68))
                    .splineTo(new Vector2d(36.98, -39.25), Math.toRadians(91.21))
                    .splineTo(new Vector2d(47.85, -39.40), Math.toRadians(-0.90))
                    .build();
            drive.setPoseEstimate(untitled0.start());

            drive.followTrajectorySequence(untitled0);

            };


        /*
        TrajectorySequence traj = drive.trajectorySequenceBuilder(startPose)
                .splineTo(new Vector2d(11.08, -33.92), Math.toRadians(90.00))
                .splineTo(new Vector2d(10.85, -53.77), Math.toRadians(269.33))
                .splineTo(new Vector2d(37.38, -51.00), Math.toRadians(5.96))
                .splineTo(new Vector2d(48.46, -35.31), Math.toRadians(-2.91))
                .build();
 */

    }
}
