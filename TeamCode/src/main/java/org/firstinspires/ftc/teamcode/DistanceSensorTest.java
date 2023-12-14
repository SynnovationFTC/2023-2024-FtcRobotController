package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
@Autonomous

public class DistanceSensorTest extends LinearOpMode{


    @Override
    public void runOpMode() {
        DistanceSensor sensorRange;
        sensorRange = hardwareMap.get(DistanceSensor.class, "range1");
        Rev2mDistanceSensor sensorTimeOfFlight = (Rev2mDistanceSensor)sensorRange;
        DcMotor right = hardwareMap.get(DcMotor.class, "right");
        DcMotor left = hardwareMap.get(DcMotor.class, "left");
        DcMotor up = hardwareMap.get(DcMotor.class, "up");
        DcMotor down = hardwareMap.get(DcMotor.class, "down");

        right.setDirection(DcMotor.Direction.REVERSE);
        left.setDirection(DcMotor.Direction.FORWARD);
        up.setDirection(DcMotor.Direction.REVERSE);
        down.setDirection(DcMotor.Direction.FORWARD);
        waitForStart();
        while(opModeIsActive()){
            double distance = sensorRange.getDistance(DistanceUnit.CM);
            telemetry.addData("deviceName",sensorRange.getDeviceName() );
            telemetry.addData("range", String.format("%.01f cm", sensorRange.getDistance(DistanceUnit.CM)));

            if( distance > 31 && distance < 40 ){

                boolean isteamprop = true;
                telemetry.addData("Is Team PROP in View:",isteamprop);

            }else if(distance > 40 && distance < 33){
                boolean isteamprop = false;
                telemetry.addData("Is Team PROP in View:",isteamprop);


            }
        }

        telemetry.addData("deviceName",sensorRange.getDeviceName() );
        telemetry.addData("range", String.format("%.01f mm", sensorRange.getDistance(DistanceUnit.MM)));
        telemetry.addData("range", String.format("%.01f cm", sensorRange.getDistance(DistanceUnit.CM)));
        telemetry.addData("range", String.format("%.01f m", sensorRange.getDistance(DistanceUnit.METER)));
        telemetry.addData("range", String.format("%.01f in", sensorRange.getDistance(DistanceUnit.INCH)));

        // Rev2mDistanceSensor specific methods.
        telemetry.addData("ID", String.format("%x", sensorTimeOfFlight.getModelID()));
        telemetry.addData("did time out", Boolean.toString(sensorTimeOfFlight.didTimeoutOccur()));

        telemetry.update();

    }


}
