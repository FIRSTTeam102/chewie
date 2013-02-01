/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;


import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.templates.commands.DriveWithXBox;
/**
 *
 * @author Administrator
 */
public class DriveTrain extends PIDSubsystem {
    private static final double Kp = -.05;
    private static final double Ki = 20.0;
    private static final double Kd = 0.0;
    SpeedController leftMotor;
    SpeedController leftRear;
    SpeedController rightMotor;
    SpeedController rightRear;
    RobotDrive drive;
    double rightJoyY;
    double leftJoyY;

    // Initialize your subsystem here
    public DriveTrain() {
        super("DriveTrain", Kp, Ki, Kd);
        leftMotor = new Talon(RobotMap.leftMotor);
        rightMotor = new Talon(RobotMap.rightMotor);
        drive = new RobotDrive(leftMotor, rightMotor);
        drive.setSafetyEnabled(false);
/*        drive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        drive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        drive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
*/

    }

    public void disablePIDMovement() {
        disable();
    }
    
    public void initDefaultCommand() {
         setDefaultCommand(new DriveWithXBox());
    }

    public void driveWithXBox(Joystick xBox) {

        leftJoyY = xBox.getRawAxis(2);
        rightJoyY = xBox.getRawAxis(5);

//        System.out.println("Left Joy: " + -leftJoyY);
//        System.out.println("Right Joy: " + rightJoyY);
        drive.setLeftRightMotorOutputs((-leftJoyY), (rightJoyY));
    }

    public void updateStatus() {
//        SmartDashboard.putDouble("Gyro: ", gyro.getAngle());
//        ADXL345_I2C.AllAxes accs = accelerometer.getAccelerations();
//        SmartDashboard.putDouble("AcclX: ", accs.XAxis);
//        SmartDashboard.putDouble("AcclY: ", accs.YAxis);
//        SmartDashboard.putDouble("AcclZ: ", accs.ZAxis);
//        SmartDashboard.putDouble("P: ", this.getPIDController().getP());
//        SmartDashboard.putDouble("I: ", this.getPIDController().getI());
//        SmartDashboard.putDouble("D: ", this.getPIDController().getD());
//        SmartDashboard.putDouble("PID Error: ", this.getPIDController().getError());
//        SmartDashboard.putDouble("leftDriveMotor: ", leftMotor.get());
//        SmartDashboard.putDouble("rightDriveMotor: ", rightMotor.get());
//        SmartDashboard.putDouble("rightJoyY: ", rightJoyY);
//        SmartDashboard.putDouble("leftJoyY: ", -leftJoyY);
     }

    protected void usePIDOutput(double output) {
        leftRear.set(output);
        leftMotor.set(output);
        rightRear.set(-output);
        rightMotor.set(-output);
    }
    public void drive(double speed)
    {
        drive.tankDrive(-speed, speed);
    }

    protected double returnPIDInput() {
        return 0.0;
    }
}
