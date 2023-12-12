package org.firstinspires.ftc.teamcode;


import com.qualcomm.hardware.dfrobot.HuskyLens;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class HuskyLensTest extends LinearOpMode {

    @Override
    public void runOpMode() {
        DigitalChannel color = hardwareMap.get(DigitalChannel.class, "color");
        HuskyLens huskyLens = hardwareMap.get(HuskyLens.class, "huskylens");

        if (!huskyLens.knock()) {
            telemetry.addData(">>", "Problem communicating with " + huskyLens.getDeviceName());
        } else {
            telemetry.addData(">>", "Press start to continue");
        }

        huskyLens.selectAlgorithm(HuskyLens.Algorithm.COLOR_RECOGNITION);

        int DESIRED_COLOR_ID;
        String propPos = null;
        boolean propFound = false;
        telemetry.update();
        waitForStart();

        while (opModeIsActive()) {
            // Clear telemetry data
            telemetry.clear();

            // Give switch input data
            if (color.getState()) {
                telemetry.addData("Color", "Red");
                DESIRED_COLOR_ID = 2;
            } else {
                telemetry.addData("Color", "Blue");
                DESIRED_COLOR_ID = 1;
            }

            // Detect blocks and perform actions based on the color ID
            HuskyLens.Block[] blocks = huskyLens.blocks();
            for (HuskyLens.Block block : blocks) {
                if (block.id == DESIRED_COLOR_ID) {
                    telemetry.addData("Detected", "Color ID: " + block.id);
                    telemetry.addData("CenterXY Location", "X: " + block.x + ", Y: " + block.y);
                    telemetry.addData("Bounding Box Height and Width", "Height: " + block.height + ", Width: " + block.width);
                    if (block.height > 11) {
                        propFound = true;
                        if (block.x < 175) {
                            propPos = "center";
                        } else if (block.x > 180) {
                            propPos = "right";
                        }
                    } else {
                        propFound = false;
                    }
                    telemetry.addData("Prop Found: ", propFound);
                    telemetry.addData("Prop Position: ", propPos);
                }
            }

            telemetry.update(); // Update telemetry outside the loop
        }
    }
}
