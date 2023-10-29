package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class MotorTests extends LinearOpMode {
    private DcMotor testmotor = null;


    public void runOpMode() throws InterruptedException{
        testmotor = hardwareMap.get(DcMotor.class, "testmotor");

        waitForStart();
        if (isStopRequested())
            return;
        while (opModeIsActive()) {
            if (gamepad1.b) {
                testmotor.setDirection(DcMotorSimple.Direction.FORWARD);

                testmotor.setPower(gamepad1.left_stick_y);
            }
        }



        }
    }
