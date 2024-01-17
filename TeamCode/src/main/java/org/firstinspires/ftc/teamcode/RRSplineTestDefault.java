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
            TrajectorySequence trajright = drive.trajectorySequenceBuilder(new Pose2d(-36.38, -59.32, Math.toRadians(90.00)))
                    .splineTo(new Vector2d(-56.60, -48.45), Math.toRadians(151.75))
                    .splineTo(new Vector2d(-47.40, -35.92), Math.toRadians(6.17))
                    .splineTo(new Vector2d(-30.49, -36.08), Math.toRadians(0.00))
                    .lineToLinearHeading(new Pose2d(-53.43, -12.68, Math.toRadians(0.00)))
                    .lineTo(new Vector2d(-16.75, -3.77))
                    .lineTo(new Vector2d(12.68, -5.58))
                    .splineTo(new Vector2d(28.83, -17.06), Math.toRadians(-42.73))
                    .splineTo(new Vector2d(48.75, -23.70), Math.toRadians(0.00))
                    .build();
            drive.setPoseEstimate(trajright.start());
            drive.followTrajectorySequence(trajright);

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
