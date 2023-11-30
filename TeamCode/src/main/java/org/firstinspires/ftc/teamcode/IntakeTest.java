package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class IntakeTest extends LinearOpMode {
    private DcMotor geckomotor = null;
    private DcMotor bootmotor = null;
    @Override
    public void runOpMode() throws InterruptedException {
        geckomotor = hardwareMap.get(DcMotor.class, "geckomotor");
        bootmotor = hardwareMap.get(DcMotor.class, "bootmotor");
        waitForStart();
        if (isStopRequested()) {
            return;
        }
        while (opModeIsActive()) {
            if (gamepad1.b) {
                if (gamepad1.right_trigger > 0) {
                    geckomotor.setDirection(DcMotorSimple.Direction.FORWARD);
                    geckomotor.setPower(gamepad1.right_trigger);
                    bootmotor.setDirection(DcMotorSimple.Direction.FORWARD);
                    bootmotor.setPower(gamepad1.right_trigger);
                    telemetry.addData("Power", gamepad1.right_trigger);
                } else {
                    geckomotor.setPower(0);
                    bootmotor.setPower(0);
                }
                if (gamepad1.left_trigger > 0) {
                    geckomotor.setDirection(DcMotorSimple.Direction.REVERSE);
                    geckomotor.setPower(gamepad1.left_trigger);
                    bootmotor.setDirection(DcMotorSimple.Direction.REVERSE);
                    bootmotor.setPower(gamepad1.left_trigger);
                    telemetry.addData("Power", gamepad1.left_trigger);

                } else {
                    geckomotor.setPower(0);
                    bootmotor.setPower(0);
                }
            }
            telemetry.update();
        }
    }
}
