package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class WinchTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        DcMotor winch = hardwareMap.get(DcMotor.class, "winch");
        waitForStart();
        if (isStopRequested()) return;
        while (opModeIsActive()) {
            if (gamepad1.a) {
                if (gamepad1.right_trigger > 0) {
                    winch.setDirection(DcMotorSimple.Direction.REVERSE);
                    winch.setPower(gamepad1.right_trigger);
                } else if (gamepad1.left_trigger > 0) {
                    winch.setDirection(DcMotorSimple.Direction.FORWARD);
                    winch.setPower(gamepad1.left_trigger);
                } else {
                    winch.setPower(0);
                }
            }
        }
    }
}
