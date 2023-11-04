package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class ViperSlideTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException{
        DcMotor viperSlide = hardwareMap.get(DcMotor.class, "viperslide");
        waitForStart();
        if (isStopRequested())
            return;
        while (opModeIsActive()) {
            if (gamepad1.b) {
                if (gamepad1.right_trigger>0) {
                    viperSlide.setDirection(DcMotorSimple.Direction.REVERSE);
                    viperSlide.setPower(gamepad1.right_trigger);
                }
                else if (gamepad1.left_trigger>0) {
                    viperSlide.setDirection(DcMotorSimple.Direction.FORWARD);
                    viperSlide.setPower(gamepad1.left_trigger);
                }
                }
            }
        }
    }


