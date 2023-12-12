package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
@Autonomous

public class DistanceSensorTest{


    @Override
    public void runOpMode() {
        DistanceSensor sensorRange;
        sensorRange = hardwareMap.get(DistanceSensor.class, "range1");
        Rev2mDistanceSensor sensorTimeOfFlight = (Rev2mDistanceSensor)sensorRange;
        DcMotor leftDrive = hardwareMap.get(DcMotor.class, "leftmotor");
        DcMotor rightDrive = hardwareMap.get(DcMotor.class, "rightmotor");

        leftDrive.setDirection(DcMotor.Direction.REVERSE);
        rightDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        waitForStart();
        while(opModeIsActive()){
            double distance = sensorRange.getDistance(DistanceUnit.CM);
            telemetry.addData("deviceName",sensorRange.getDeviceName() );
            telemetry.addData("range", String.format("%.01f cm", sensorRange.getDistance(DistanceUnit.CM)));

            if( distance < 0){

                leftDrive.setPower(0.3);
                rightDrive.setPower(0.2);

            }else if(distance > 12){

                leftDrive.setPower(0.2);
                rightDrive.setPower(0.3);


            }
            else{

                leftDrive.setPower(0.3);
                rightDrive.setPower(0.3);
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
