package org.firstinspires.ftc.teamcode.mechanisms;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
public class Extensions {
    // Declare hardware components
    public DcMotor linearSlideMotor;
    public Servo clawServo;
    public Servo wristServo;
    public DcMotor pivotMotor;

    // Constructor to initialize hardware
    public void init(HardwareMap hardwareMap) {
        // Initialize hardware components
        linearSlideMotor = hardwareMap.get(DcMotor.class, "linear_slide_motor");
        clawServo = hardwareMap.get(Servo.class, "claw_servo");
        wristServo = hardwareMap.get(Servo.class, "wrist_servo");
        pivotMotor = hardwareMap.get(DcMotor.class, "pivot_motor");

        // Set motor directions if necessary
        linearSlideMotor.setDirection(DcMotor.Direction.FORWARD);
        pivotMotor.setDirection(DcMotor.Direction.FORWARD);
    }

    // Method to control the linear slide motor (with power)
    public void controlLinearSlide(double power) {
        linearSlideMotor.setPower(power);
    }

    // Method to control the claw servo (with position)
    public void controlClaw(double position) {
        clawServo.setPosition(position);  // position should be between 0.0 and 1.0
    }
    public void controlWrist(double position) {
        wristServo.setPosition(position);  // position should be between 0.0 and 1.0
    }

    // Method to control the wrist pivot motor (with power)
    public void controlWristPivot(double power) {
        pivotMotor.setPower(power);
    }



}
