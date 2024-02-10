package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;


public class MeepMeepTestingRight {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(600);
        RoadRunnerBotEntity redboardside = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(48.969740383576614, 48.969740383576614, Math.toRadians(196.3634311566834), Math.toRadians(196.3634311566834), 12.23)
                .setDimensions(16.25,16)
                .followTrajectorySequence(drive -> drive.trajectorySequenceBuilder(new Pose2d(13.94, -62.17, Math.toRadians(90.00)))
                        .lineTo(new Vector2d(24.00, -62.19))
                        .lineTo(new Vector2d(23.55, -39.70))
                        .addDisplacementMarker(() -> {
                            //pusherarm.setPosition(1);
                        })
                        .waitSeconds(1)
                        .lineTo(new Vector2d(35.62, -59.77))
                        .lineTo(new Vector2d(36.08, -38.19))
                        .addDisplacementMarker(() -> {
                            //outtakeUp();
                        })
                        .waitSeconds(1)
                        .lineToLinearHeading(new Pose2d(48.23, -36.57, Math.toRadians(0.00)))
                        .addDisplacementMarker(() -> {
                            //outtakeDown();
                        })
                        .lineTo(new Vector2d(35.43, -51.66))
                        .splineToLinearHeading(new Pose2d(49.14, -58.97, Math.toRadians(0.00)), Math.toRadians(0.00))
                        .build());

        RoadRunnerBotEntity redaudienceside = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(39, 39, Math.toRadians(180), Math.toRadians(180), 12.23)
                .setDimensions(16.25,16)
                .followTrajectorySequence(drive -> drive.trajectorySequenceBuilder(new Pose2d(-36.83, -62.19, Math.toRadians(90.00)))
                        .lineTo(new Vector2d(-48.15, -61.89))
                        .lineTo(new Vector2d(-46.19, -43.62))
                        .splineToLinearHeading(new Pose2d(-32.75, -30.00, Math.toRadians(0.00)), Math.toRadians(0.00))
                        .addDisplacementMarker(() -> {
                            //pusherarm.setPosition(1);
                        })
                        .waitSeconds(1)
                        .lineTo(new Vector2d(-52.08, -9.21))
                        .lineTo(new Vector2d(10.72, -3.17))
                        .lineTo(new Vector2d(40.00, -12.00))
                        .lineToLinearHeading(new Pose2d(40.00, -35.00, 0))
                        .addDisplacementMarker(() -> {
                            //outtakeUp();
                        })
                        .waitSeconds(1)
                        .lineToLinearHeading(new Pose2d(48.25, -36.00, Math.toRadians(0.00)))
                        .addDisplacementMarker(() -> {
                            //outtakeDown();
                        })
                        .lineTo(new Vector2d(40.00, -60.00))
                        .lineTo(new Vector2d(54.00, -60.00))
                        .build());
        RoadRunnerBotEntity blueboardside = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(48.969740383576614, 48.969740383576614, Math.toRadians(196.3634311566834), Math.toRadians(196.3634311566834), 12.23)
                .setDimensions(16.25,16)
                .followTrajectorySequence(drive -> drive.trajectorySequenceBuilder(new Pose2d(13.49, 62.17, Math.toRadians(-90.00)))
                        .lineTo(new Vector2d(24.00, 60.23))
                        .lineTo(new Vector2d(23.70, 31.70))
                        .splineTo(new Vector2d(8.45, 33.66), Math.toRadians(178.59))
                        .addDisplacementMarker(() -> {
                            //pusherarm.setPosition(1);
                        })
                        .waitSeconds(0.5)

                        .addDisplacementMarker(() -> {
                            //outtakeUp();
                        })
                        .waitSeconds(1)
                        .lineToLinearHeading(new Pose2d(48.35, 35.50, Math.toRadians(360.00)))
                        .addDisplacementMarker(() -> {
                            //outtakeDown();
                        })
                        .lineToLinearHeading(new Pose2d(45.50, 60.00, Math.toRadians(360.00)))

                        .build());
        RoadRunnerBotEntity blueaudienceside = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(48.969740383576614, 48.969740383576614, Math.toRadians(196.3634311566834), Math.toRadians(196.3634311566834), 12.23)
                .setDimensions(16.25,16)
                .followTrajectorySequence(drive -> drive.trajectorySequenceBuilder(new Pose2d(-37.94, 60.80, Math.toRadians(-90.00)))
                        .lineTo(new Vector2d(-48.15, 59.92))
                        .lineTo(new Vector2d(-47.70, 40.75))
                        .addDisplacementMarker(() -> {
                            //pusherarm.setPosition(1);
                        })
                        .waitSeconds(0.5)
                        .lineTo(new Vector2d(-38.04, 52.98))
                        .lineTo(new Vector2d(-35.17, 28.38))
                        .lineTo(new Vector2d(-34.87, 12.38))
                        .splineTo(new Vector2d(1.21, 3.87), Math.toRadians(0.81))
                        .lineTo(new Vector2d(35.02, 11.02))
                        .lineTo(new Vector2d(42.87, 35.77))
                        .lineTo(new Vector2d(41.81, 58.87))
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