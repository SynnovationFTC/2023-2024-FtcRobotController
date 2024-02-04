package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;


public class MeepMeepTestingMiddle {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(600);

        RoadRunnerBotEntity redboardside = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(48.969740383576614, 48.969740383576614, Math.toRadians(196.3634311566834), Math.toRadians(196.3634311566834), 12.23)
                .setDimensions(16.25,16)
                .followTrajectorySequence(drive -> drive.trajectorySequenceBuilder(new Pose2d(13.94, -62.17, Math.toRadians(90.00)))
                        .lineTo(new Vector2d(11.77, -33.06))
                        .addDisplacementMarker(() -> {
                            //pusherarm.setPosition(1);
                        })
                        .waitSeconds(0.5)
                        .lineTo(new Vector2d(24.30, -50.57))
                        .lineTo(new Vector2d(37.74, -35.17))
                        .lineToLinearHeading(new Pose2d(48.23, -36.57, Math.toRadians(0.00)))
                        .lineTo(new Vector2d(35.43, -51.66))
                        .splineToLinearHeading(new Pose2d(49.14, -58.97, Math.toRadians(0.00)), Math.toRadians(0.00))
                        .build());
        RoadRunnerBotEntity redaudienceside = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(48.969740383576614, 48.969740383576614, Math.toRadians(196.3634311566834), Math.toRadians(196.3634311566834), 12.23)
                .setDimensions(16.25,16)
                .followTrajectorySequence(drive -> drive.trajectorySequenceBuilder(new Pose2d(-37.71, -61.94, Math.toRadians(90.00)))
                        .lineTo(new Vector2d(-36.38, -33.21))
                        .addDisplacementMarker(() -> {
                            //pusherarm.setPosition(1);
                        })
                        .waitSeconds(0.5)
                        .lineTo(new Vector2d(-57.36, -52.98))
                        .lineTo(new Vector2d(-51.62, -13.13))
                        .splineTo(new Vector2d(-32.60, -11.17), Math.toRadians(8.39))
                        .lineTo(new Vector2d(-19.32, -10.11))
                        .lineTo(new Vector2d(37.43, -12.08))
                        .lineTo(new Vector2d(36.38, -51.62))
                        .lineToLinearHeading(new Pose2d(48.23, -36.57, Math.toRadians(0.00)))
                        .lineTo(new Vector2d(35.43, -51.66))
                        .splineToLinearHeading(new Pose2d(49.14, -58.97, Math.toRadians(0.00)), Math.toRadians(0.00))
                        .build());
        RoadRunnerBotEntity blueboardside = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(48.969740383576614, 48.969740383576614, Math.toRadians(196.3634311566834), Math.toRadians(196.3634311566834), 12.23)
                .setDimensions(16.25,16)
                .followTrajectorySequence(drive -> drive.trajectorySequenceBuilder(new Pose2d(13.49, 62.17, Math.toRadians(-90.00)))
                        .lineTo(new Vector2d(11.92, 32.75))
                        .addDisplacementMarker(() -> {
                            //pusherarm.setPosition(1);
                        })
                        .waitSeconds(0.5)
                        .lineTo(new Vector2d(24.45, 50.11))
                        .lineTo(new Vector2d(35.62, 40.00))
                        .lineToLinearHeading(new Pose2d(48.00, 35.89, Math.toRadians(0.00)))
                        .lineTo(new Vector2d(34.06, 52.80))
                        .splineToLinearHeading(new Pose2d(50.00, 12.50, Math.toRadians(0.00)), Math.toRadians(0.00))
                        .build());
        RoadRunnerBotEntity blueaudienceside = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(48.969740383576614, 48.969740383576614, Math.toRadians(196.3634311566834), Math.toRadians(196.3634311566834), 12.23)
                .setDimensions(16.25,16)
                .followTrajectorySequence(drive -> drive.trajectorySequenceBuilder(new Pose2d(-37.94, 60.80, Math.toRadians(-90.00)))
                        .lineTo(new Vector2d(-35.92, 33.21))
                        .addDisplacementMarker(() -> {
                            //pusherarm.setPosition(1);
                        })
                        .waitSeconds(0.5)
                        .lineTo(new Vector2d(-56.91, 58.11))
                        .lineTo(new Vector2d(-52.08, 12.38))
                        .splineTo(new Vector2d(-21.43, 5.72), Math.toRadians(-3.10))
                        .lineTo(new Vector2d(11.77, 11.92))
                        .lineTo(new Vector2d(35.62, 11.17))
                        .lineTo(new Vector2d(35.77, 49.21))
                        .lineToLinearHeading(new Pose2d(48.00, 35.89, Math.toRadians(0.00)))
                        .lineTo(new Vector2d(34.06, 52.80))
                        .splineToLinearHeading(new Pose2d(50.00, 12.50, Math.toRadians(0.00)), Math.toRadians(0.00))
                        .build());


        meepMeep.setBackground(MeepMeep.Background.FIELD_CENTERSTAGE_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(redboardside)
                .addEntity(redaudienceside)
                .addEntity(blueboardside)
                .addEntity(blueaudienceside)
                .start();
    }
}