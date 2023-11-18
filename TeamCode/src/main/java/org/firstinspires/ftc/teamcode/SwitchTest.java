package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DigitalChannel;

@TeleOp
public class SwitchTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        DigitalChannel color = hardwareMap.get(DigitalChannel.class, "color");
        DigitalChannel boardside = hardwareMap.get(DigitalChannel.class, "boardside");
        color.setMode(DigitalChannel.Mode.INPUT);
        boardside.setMode(DigitalChannel.Mode.INPUT);
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();
        if (isStopRequested()) {
            return;
        }
        while (opModeIsActive()) {
            telemetry.addData("Status", "TeleOp Running");
            if (color.getState()) {
                telemetry.addData("Color", "Red");
                String colorvalue = "red";
            }
            if (!color.getState()) {
                telemetry.addData("Color", "Blue");
                String colorvalue = "blue";
            }
            if (boardside.getState()) {
                telemetry.addData("Side", "Board");
                String side = "board";

            }
            if (!boardside.getState()) {
                telemetry.addData("Side", "Audience");
                String side = "audience";
            }
            telemetry.update();
        }

    }

}
