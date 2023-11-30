package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class LinearActuatorTest extends LinearOpMode {
    private DcMotor linearactuator = null;
    @Override
    public void runOpMode() throws InterruptedException {
        linearactuator = hardwareMap.get(DcMotor.class, "bootmotor");
        waitForStart();
        if (isStopRequested()) {
            return;
        }
        while (opModeIsActive()) {
            if (gamepad1.b) {
                if (gamepad1.right_trigger > 0) {
                    linearactuator.setDirection(DcMotorSimple.Direction.FORWARD);
                    linearactuator.setPower(gamepad1.right_trigger);
                    telemetry.addData("Power", gamepad1.right_trigger);
                } else {
                    linearactuator.setPower(0);
                }
                if (gamepad1.left_trigger > 0) {
                    linearactuator.setDirection(DcMotorSimple.Direction.REVERSE);
                    linearactuator.setPower(gamepad1.left_trigger);
                    telemetry.addData("Power", gamepad1.left_trigger);

                } else {
                    linearactuator.setPower(0);
                }
            }
            telemetry.update();
        }
    }
}
