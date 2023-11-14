package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class WinchTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        DcMotor testmotor = hardwareMap.get(DcMotor.class, "testmotor");
        waitForStart();
        if (isStopRequested()) return;
        while (opModeIsActive()) {
            if (gamepad1.b) {
                if (gamepad1.right_trigger > 0) {
                    testmotor.setDirection(DcMotorSimple.Direction.REVERSE);
                    testmotor.setPower(gamepad1.right_trigger);
                } else if (gamepad1.left_trigger > 0) {
                    testmotor.setDirection(DcMotorSimple.Direction.FORWARD);
                    testmotor.setPower(gamepad1.left_trigger);
                } else {
                    testmotor.setPower(0);
                }
            }
        }
    }
}
