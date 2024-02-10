package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;


public class MeepMeepTestingLeft {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(600);

        RoadRunnerBotEntity redboardside = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(48.969740383576614, 48.969740383576614, Math.toRadians(196.3634311566834), Math.toRadians(196.3634311566834), 12.23)
                .setDimensions(16.25,16)
                .followTrajectorySequence(drive -> drive.trajectorySequenceBuilder(new Pose2d(13.94, -62.17, Math.toRadians(90.00)))
                        .lineTo(new Vector2d(23.25, -60.83))
                        .lineTo(new Vector2d(23.25, -35.62))
                        .splineTo(new Vector2d(11.125, -31.5), Math.toRadians(180.00))
                        .addDisplacementMarker(() -> {
                            //pusherarm.setPosition(1);
                        })
                        .waitSeconds(0.5)
                        .lineTo(new Vector2d(31.09, -34.42))
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
                .setConstraints(48.969740383576614, 48.969740383576614, Math.toRadians(196.3634311566834), Math.toRadians(196.3634311566834), 12.23)
                .setDimensions(16.25,16)
                .followTrajectorySequence(drive -> drive.trajectorySequenceBuilder(new Pose2d(-36.83, -62.19, Math.toRadians(90.00)))
                        .lineTo(new Vector2d(-48.15, -61.89))
                        .lineTo(new Vector2d(-47.40, -40.75))
                        .addDisplacementMarker(() -> {
                            //pusherarm.setPosition(1);
                        })
                        .lineTo(new Vector2d(-35.43, -52.11))
                        .lineTo(new Vector2d(-34.06, -24.46))
                        .splineTo(new Vector2d(-29.49, -11.43), Math.toRadians(-6.29))
                        .splineTo(new Vector2d(12.34, -11.89), Math.toRadians(0.00))
                        .lineTo(new Vector2d(40.00, -12.00))
                        .lineTo(new Vector2d(40.00, -35.00))
                        .lineTo(new Vector2d(40.00, -60.00))
                        .lineTo(new Vector2d(54.00, -60.00))
                        .build());
        RoadRunnerBotEntity blueboardside = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(48.969740383576614, 48.969740383576614, Math.toRadians(196.3634311566834), Math.toRadians(196.3634311566834), 12.23)
                .setDimensions(16.25,16)
                .followTrajectorySequence(drive -> drive.trajectorySequenceBuilder(new Pose2d(13.49, 62.17, Math.toRadians(-90.00)))
                        //TODO: Change Parking Location
                        .lineTo(new Vector2d(24.00, 60.83))
                        .lineTo(new Vector2d(23.70, 40.91))
                        .addDisplacementMarker(() -> {
                            //pusherarm.setPosition(1);
                        })
                        .waitSeconds(0.5)
                        .lineTo(new Vector2d(23.70, 54.34))
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
                        //TODO: Change Parking Location
                        .lineTo(new Vector2d(-48.15, 61.13))
                        .lineTo(new Vector2d(-47.85, 33.96))
                        .splineToLinearHeading(new Pose2d(-33.25, 30.00, Math.toRadians(360.00)), Math.toRadians(360.00))
                        .addDisplacementMarker(() -> {
                            //pusherarm.setPosition(1);
                        })
                        .waitSeconds(0.5)
                        .lineTo(new Vector2d(-51.02, 32.60))
                        .lineTo(new Vector2d(-41.66, 5.89))
                        .lineTo(new Vector2d(11.62, 1.98))
                        .lineTo(new Vector2d(32.60, 4.98))
                        .lineTo(new Vector2d(42.87, 35.77))
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