package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
@TeleOp
public class OuttakeServo extends LinearOpMode {
    private DcMotor geckomotor = null;
    private DcMotor bootmotor = null;

    @Override
    public void runOpMode() {
        geckomotor = hardwareMap.get(DcMotor.class, "geckomotor");
        bootmotor = hardwareMap.get(DcMotor.class, "bootmotor");
        Servo top = hardwareMap.get(Servo.class, "topservo");
        top.setDirection(Servo.Direction.REVERSE);
        Servo bottom = hardwareMap.get(Servo.class, "bottomservo");
        Servo door = hardwareMap.get(Servo.class, "doorservo");
        door.setDirection(Servo.Direction.REVERSE);
        top.setDirection(Servo.Direction.REVERSE);


        double initialtopservoposition = 0;
        double initialbottomservoposition = 0;
        waitForStart();
        top.setPosition(initialtopservoposition);
        bottom.setPosition(initialbottomservoposition);
        while (opModeIsActive()) {
            if (gamepad2.dpad_down) {
                top.setPosition(0);
                bottom.setPosition(0);
                telemetry.addData("Top Servo Position:", top.getPosition());
            }
            if (gamepad2.dpad_up) {
                top.setPosition(0.23);
                bottom.setPosition(0.4);
                telemetry.addData("Top Servo Position:", top.getPosition());

            }
            if (gamepad2.dpad_left) {
                top.setPosition(0.35);
                bottom.setPosition(0.8);
                telemetry.addData("Bottom Servo Position:", bottom.getPosition());
            }

            if (gamepad2.y) {
                door.setPosition(0.01);
                telemetry.addData("door Servo Position:", top.getPosition());
            }
            if (gamepad2.x) {
                bottom.setPosition(0.08);
                telemetry.addData("door Position:", top.getPosition());

            }
            if (gamepad2.a) {
                door.setPosition(0.27);
                telemetry.addData("door Position:", top.getPosition());

            }
            telemetry.update();
            waitForStart();
            if (isStopRequested()) {
                return;
            }

            if (gamepad2.b) {
                if (gamepad2.right_trigger > 0) {
                    geckomotor.setDirection(DcMotorSimple.Direction.FORWARD);
                    geckomotor.setPower(gamepad2.right_trigger);
                    bootmotor.setDirection(DcMotorSimple.Direction.FORWARD);
                    bootmotor.setPower(gamepad2.right_trigger);
                    telemetry.addData("Power", gamepad2.right_trigger);
                } else {
                    geckomotor.setPower(0);
                    bootmotor.setPower(0);
                }
                if (gamepad2.left_trigger > 0) {
                    geckomotor.setDirection(DcMotorSimple.Direction.REVERSE);
                    geckomotor.setPower(gamepad2.left_trigger);
                    bootmotor.setDirection(DcMotorSimple.Direction.REVERSE);
                    bootmotor.setPower(gamepad2.left_trigger);
                    telemetry.addData("Power", gamepad2.left_trigger);

                } else {
                    geckomotor.setPower(0);
                    bootmotor.setPower(0);
                }
            }
            }
        }
    }

