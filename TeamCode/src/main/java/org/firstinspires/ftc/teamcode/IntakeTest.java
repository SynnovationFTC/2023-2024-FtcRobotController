package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class IntakeTest extends LinearOpMode {
    private DcMotor intake = null;

    @Override
    public void runOpMode() throws InterruptedException {
        intake = hardwareMap.get(DcMotor.class, "intake");
        waitForStart();
        if (isStopRequested()) {
            return;
        }
        while (opModeIsActive()) {
            if (gamepad1.b) {
                if (gamepad1.right_trigger > 0) {
                    intake.setDirection(DcMotorSimple.Direction.FORWARD);
                    intake.setPower(gamepad1.right_trigger);
                    telemetry.addData("Power", gamepad1.right_trigger);
                } else {
                    intake.setPower(0);
                }
                if (gamepad1.left_trigger > 0) {
                    intake.setDirection(DcMotorSimple.Direction.REVERSE);
                    intake.setPower(gamepad1.left_trigger);
                    telemetry.addData("Power", gamepad1.left_trigger);

                } else {
                    intake.setPower(0);
                }
            }
            telemetry.update();
        }
    }
}
