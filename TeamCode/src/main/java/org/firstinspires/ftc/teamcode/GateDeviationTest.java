package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

@Autonomous
public class GateDeviationTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
        TrajectorySequence traj = drive.trajectorySequenceBuilder(new Pose2d(-36.34, -37.03, Math.toRadians(88.96)))
                .splineTo(new Vector2d(-50.97, -17.14), Math.toRadians(40.91))
                .splineTo(new Vector2d(-26.29, -11.20), Math.toRadians(0.00))
                .lineTo(new Vector2d(27.43, -11.89))
                .lineTo(new Vector2d(27.66, -36.34))
                .lineTo(new Vector2d(-2.29, -36.11))
                .lineTo(new Vector2d(-27.66, -36.11))
                .build();
        drive.setPoseEstimate(traj.start());
        waitForStart();
        if (isStopRequested()) return;
        double times = 0;
        while (times <= 20) {
            drive.followTrajectorySequence(traj);
            times++;
        }
    }
}
