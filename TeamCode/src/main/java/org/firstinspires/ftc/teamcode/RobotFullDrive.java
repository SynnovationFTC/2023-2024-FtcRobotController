/* Copyright (c) 2023 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp()
public class RobotFullDrive extends LinearOpMode {

    private DcMotor leftFrontDrive = null;  //  Used to control the left front drive wheel
    private DcMotor rightFrontDrive = null;  //  Used to control the right front drive wheel
    private DcMotor leftBackDrive = null;  //  Used to control the left back drive wheel
    private DcMotor rightBackDrive = null;  //  Used to control the right back drive wheel

    @Override
    public void runOpMode() {
        double drive = 0;        // Desired forward power/speed (-1 to +1)
        double strafe = 0;        // Desired strafe power/speed (-1 to +1)
        double turn = 0;        // Desired turning power/speed (-1 to +1)


        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must match the names assigned during the robot configuration.
        // step (using the FTC Robot Controller app on the phone).
        leftFrontDrive = hardwareMap.get(DcMotor.class, "frontleft");
        rightFrontDrive = hardwareMap.get(DcMotor.class, "frontright");
        leftBackDrive = hardwareMap.get(DcMotor.class, "backleft");
        rightBackDrive = hardwareMap.get(DcMotor.class, "backright");
        leftFrontDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFrontDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftBackDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFrontDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        DigitalChannel color = hardwareMap.get(DigitalChannel.class, "color");
        DigitalChannel boardside = hardwareMap.get(DigitalChannel.class, "boardside");

        color.setMode(DigitalChannel.Mode.INPUT);
        boardside.setMode(DigitalChannel.Mode.INPUT);

        // To drive forward, most robots need the motor on one side to be reversed, because the axles point in opposite directions.
        // When run, this OpMode should start both motors driving forward. So adjust these two lines based on your first test drive.
        // Note: The settings here assume direct drive on left and right wheels.  Gear Reduction or 90 Deg drives may require direction flips
        leftFrontDrive.setDirection(DcMotor.Direction.REVERSE);
        leftBackDrive.setDirection(DcMotor.Direction.REVERSE);
        rightFrontDrive.setDirection(DcMotor.Direction.FORWARD);
        rightBackDrive.setDirection(DcMotor.Direction.FORWARD);


        // Wait for driver to press start
        telemetry.addData(">", "Touch Play to start OpMode");
        telemetry.update();
        Servo holder = hardwareMap.get(Servo.class, "holder");
        Servo launcher = hardwareMap.get(Servo.class, "launcher");
        holder.setDirection(Servo.Direction.REVERSE);
        holder.setPosition(0.04);
        launcher.setPosition(0.7);
        waitForStart();

        while (opModeIsActive()) {
            // Step through the list of detected tags and look for a matching tag


            // Tell the driver what we see, and what to do.
            telemetry.addData("\n>", "Drive using joysticks\n");
            // Give switch input data
            if (color.getState()) {
                telemetry.addData("Color", "Red");
                String colorvalue = "red";
            }
            if (!color.getState()) {
                telemetry.addData("Color", "Blue");
                String colorvalue = "blue";
            }
            if (boardside.getState()) {
                telemetry.addData("Side", "Board");
                String side = "board";

            }
            if (!boardside.getState()) {
                telemetry.addData("Side", "Audience");
                String side = "audience";
            }

            // drive using manual POV Joystick mode.  Slow things down to make the robot more controllable.
            double o_drive_multiplier = 0.60;
            double o_strafe_multiplier = 0.60;
            double o_turn_multiplier = (double) 5 / 12;
            double n_drive_multiplier = o_drive_multiplier;
            double n_strafe_multiplier = o_strafe_multiplier;
            double n_turn_multiplier = o_turn_multiplier;
            if (gamepad1.right_bumper || gamepad1.left_bumper) {
                n_drive_multiplier = 1;
                n_strafe_multiplier = 1;
                n_turn_multiplier = .89;
            } else {
                n_drive_multiplier = o_drive_multiplier;
                n_strafe_multiplier = o_strafe_multiplier;
                n_turn_multiplier = o_turn_multiplier;

            }
            drive = -gamepad1.left_stick_y * n_drive_multiplier;  // Reduce drive rate to 75%.
            strafe = -gamepad1.left_stick_x * n_strafe_multiplier;  // Reduce strafe rate to 75%.
            //turn = -gamepad1.right_stick_x / 3.0
            turn = gamepad1.right_stick_x * n_turn_multiplier;  // Reduce turn rate to 66%.
            telemetry.addData("Details", "Drive %5.2f, Strafe %5.2f, Turn %5.2f ", drive, strafe, turn);

            // Update Telemetry (keep it at the end of the loop so there are no glitches)
            telemetry.update();
            // Apply desired axes motions to the drivetrain.
            //moveRobot(drive, turn, strafe);
            moveRobot(-turn, drive, strafe);
            sleep(10);
        }
    }


    /**
     * Move robot according to desired axes motions
     * <p>
     * Positive X is forward
     * <p>
     * Positive Y is strafe left
     * <p>
     * Positive Yaw is counter-clockwise
     */
    public void moveRobot(double x, double y, double yaw) {
        DcMotor leftlinearactuator = hardwareMap.get(DcMotor.class, "leftlinearactuator");
        DcMotor rightlinearactuator = hardwareMap.get(DcMotor.class, "rightlinearactuator");
        DcMotor bootwheel = hardwareMap.get(DcMotor.class, "bootmotor");
        Servo outtake = hardwareMap.get(Servo.class, "outtake");
        outtake.setDirection(Servo.Direction.REVERSE);
        // Calculate wheel powers.
        double leftFrontPower = x + y - yaw;
        double rightFrontPower = x - y + yaw;
        double leftBackPower = x - y - yaw;
        double rightBackPower = x + y + yaw;

        // Normalize wheel powers to be less than 1.0
        double max = Math.max(Math.abs(leftFrontPower), Math.abs(rightFrontPower));
        max = Math.max(max, Math.abs(leftBackPower));
        max = Math.max(max, Math.abs(rightBackPower));

        if (max > 1.0) {
            leftFrontPower /= max;
            rightFrontPower /= max;
            leftBackPower /= max;
            rightBackPower /= max;
        }
        // Send powers to the wheels.
        leftFrontDrive.setPower(leftFrontPower);
        rightFrontDrive.setPower(rightFrontPower);
        leftBackDrive.setPower(leftBackPower);
        rightBackDrive.setPower(rightBackPower);
        telemetry.addData("Motor Powers", "LF: %.2f, RF: %.2f, LB: %.2f, RB: %.2f", leftFrontPower, rightFrontPower, leftBackPower, rightBackPower);

        telemetry.addData("Linear Actuator Positions", "Left: %.2f, Right: %.2f", leftlinearactuator.getPower(), rightlinearactuator.getPower());

        telemetry.addData("Bootwheel Power", "Bootwheel: %.2f", bootwheel.getPower());

        telemetry.update();
        if (gamepad2.b) {
            if (gamepad2.right_trigger > 0) {
                leftlinearactuator.setDirection(DcMotorSimple.Direction.FORWARD);
                rightlinearactuator.setDirection(DcMotorSimple.Direction.FORWARD);
                leftlinearactuator.setPower(gamepad2.right_trigger);
                rightlinearactuator.setPower(gamepad2.right_trigger);
            } else {
                leftlinearactuator.setPower(0);
                rightlinearactuator.setPower(0);
            }
            if (gamepad2.left_trigger > 0) {
                leftlinearactuator.setDirection(DcMotorSimple.Direction.REVERSE);
                rightlinearactuator.setDirection(DcMotorSimple.Direction.REVERSE);
                leftlinearactuator.setPower(gamepad2.left_trigger);
                rightlinearactuator.setPower(gamepad2.left_trigger);

            } else {
                leftlinearactuator.setPower(0);
                rightlinearactuator.setPower(0);
            }
        }
        if (gamepad2.a) {
            if (gamepad2.right_trigger > 0) {
                bootwheel.setDirection(DcMotorSimple.Direction.FORWARD);
                bootwheel.setPower(gamepad2.right_trigger);

            } else {
                bootwheel.setPower(0);
            }
            if (gamepad2.left_trigger > 0) {
                bootwheel.setDirection(DcMotorSimple.Direction.REVERSE);
                bootwheel.setPower(gamepad2.left_trigger);
            } else {
                bootwheel.setPower(0);
            }
        }
        boolean outtakedown = ((leftFrontPower <= 0 && rightFrontPower <= 0 && leftBackPower <= 0 && rightBackPower <= 0) && (bootwheel.getPower() > 0));
        if (outtakedown && !gamepad2.dpad_up) {
            outtake.setPosition(0.15);
        } else if (!gamepad2.dpad_up) {
            outtake.setPosition(0.3);
        }
        double servoIncrement = 0.0075;
        if (gamepad2.dpad_up) {
            double newservoposition = (outtake.getPosition() + servoIncrement);
            outtake.setPosition(newservoposition);
            sleep(5);
        }
        Servo holder = hardwareMap.get(Servo.class, "holder");
        Servo launcher = hardwareMap.get(Servo.class, "launcher");
        holder.setDirection(Servo.Direction.REVERSE);

        if (gamepad1.dpad_down) {
            holder.setPosition(0.04);
            sleep(250);
            launcher.setPosition(0.7);
        }
        if (gamepad1.dpad_up) {
            holder.setPosition(0.5);
            sleep(250);
            launcher.setPosition(0);
        }

    }
}


