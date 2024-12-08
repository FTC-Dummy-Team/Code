package org.firstinspires.ftc.teamcode.opmodes.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.MecanumDrive;

@TeleOp()
public class SimpleMecanumDriveOpMode extends OpMode {
    MecanumDrive drive = new MecanumDrive();
    Extensions extensions = new Extensions();

    @Override
    public void init() {
        drive.init(hardwareMap);
        extensions.init(hardwareMap);
    }

    @Override
    public void loop() {
        //driving
        double forward = -gamepad1.right_stick_y;
        double right = gamepad1.right_stick_x;
        double rotate = gamepad1.left_stick_x;
        drive.drive(forward, right, rotate);
        //claw
        if (gamepad1.left_bumper) {
            extensions.controlClaw(0.0);  // Open claw
        } else if (gamepad1.right_bumper) {
            extensions.controlClaw(1.0);  // Close claw
        }
        //pivot
        if (gamepad1.left_trigger > 0.1) {
            extensions.controlWristPivot(1.0); // Vertical position (positive power)
        } else if (gamepad1.right_trigger > 0.1) {
            extensions.controlWristPivot(-1.0); // Horizontal position (negative power)
        } else {
            extensions.controlWristPivot(0); // Stop the motor (no power)
        }

    }
}