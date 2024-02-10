package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class OuttakeServo extends LinearOpMode {
    @Override
    public void runOpMode() {
        Servo outtake = hardwareMap.get(Servo.class, "outtake");
        outtake.setDirection(Servo.Direction.REVERSE);
        waitForStart();
        while (opModeIsActive()) {
            if (gamepad1.dpad_up) {
                double upservoIncrement = 0.00075;
                double upnewservoposition = 0.0875;
                while (upnewservoposition < 0.845) {
                    upnewservoposition = (upnewservoposition + upservoIncrement);
                    outtake.setPosition(upnewservoposition);
                    //sleep(50);
                }
            }
            if (gamepad1.dpad_down) {
                double downservoIncrement = 0.01;
                double downnewservoposition = 0.845;
                while (downnewservoposition > 0.0875) {
                    downnewservoposition = (downnewservoposition - downservoIncrement);
                    outtake.setPosition(downnewservoposition);
                    //sleep(25);
                }
            }
            if (gamepad1.dpad_right){
                outtake.setPosition(gamepad1.right_trigger);
            }
            //outtake.setPosition(gamepad1.right_trigger);
            telemetry.addLine(String.valueOf(outtake.getPosition()));
            telemetry.update();
        }

    }
}


