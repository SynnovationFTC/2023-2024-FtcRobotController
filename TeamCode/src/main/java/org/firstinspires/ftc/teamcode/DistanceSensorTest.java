package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
@TeleOp

public class DistanceSensorTest extends LinearOpMode{


    @Override
    public void runOpMode() {
        //sides are when you are looking at the front of the robot
        DistanceSensor left;
        DistanceSensor middle;
        DistanceSensor right;
        left = hardwareMap.get(DistanceSensor.class, "distanceleft");
        middle = hardwareMap.get(DistanceSensor.class, "distancemiddle");
        right = hardwareMap.get(DistanceSensor.class, "distanceright");
        Rev2mDistanceSensor leftTOF = (Rev2mDistanceSensor)left;
        Rev2mDistanceSensor middleTOF = (Rev2mDistanceSensor)middle;
        Rev2mDistanceSensor rightTOF = (Rev2mDistanceSensor)right;


        waitForStart();
        while(opModeIsActive()){
            telemetry.addData("Status", "Running");
        }
        double leftdistance = left.getDistance(DistanceUnit.CM);
        telemetry.addData("deviceName",left.getDeviceName() );
        telemetry.addData("left", String.format("%.01f cm", left.getDistance(DistanceUnit.CM)));
        double middledistance = middle.getDistance(DistanceUnit.CM);
        telemetry.addData("deviceName",middle.getDeviceName() );
        telemetry.addData("middle", String.format("%.01f cm", middle.getDistance(DistanceUnit.CM)));
        double rightdistance = right.getDistance(DistanceUnit.CM);
        telemetry.addData("deviceName",right.getDeviceName() );
        telemetry.addData("right", String.format("%.01f cm", right.getDistance(DistanceUnit.CM)));


        telemetry.update();

    }


}
