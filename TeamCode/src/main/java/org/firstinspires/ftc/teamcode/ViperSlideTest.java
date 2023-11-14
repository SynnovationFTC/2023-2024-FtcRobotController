package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class ViperSlideTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        DcMotor leftviperslide = hardwareMap.get(DcMotor.class, "leftviperslide");
        DcMotor rightviperslide = hardwareMap.get(DcMotor.class, "rightviperslide");
        waitForStart();
        if (isStopRequested()) return;
        while (opModeIsActive()) {
            if (gamepad1.b) {
                if (gamepad1.right_trigger > 0) {
                    leftviperslide.setDirection(DcMotorSimple.Direction.REVERSE);
                    rightviperslide.setDirection(DcMotorSimple.Direction.REVERSE);
                    leftviperslide.setPower(gamepad1.right_trigger);
                    rightviperslide.setPower(gamepad1.right_trigger);
                } else if (gamepad1.left_trigger > 0) {
                    leftviperslide.setDirection(DcMotorSimple.Direction.FORWARD);
                    rightviperslide.setDirection(DcMotorSimple.Direction.FORWARD);
                    leftviperslide.setPower(gamepad1.left_trigger);
                    rightviperslide.setPower(gamepad1.left_trigger);
                } else {
                    leftviperslide.setPower(0);
                    rightviperslide.setPower(0);
                }
            }
        }
    }
}



