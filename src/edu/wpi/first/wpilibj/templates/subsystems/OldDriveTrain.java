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
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.DriveWithXBox;
/**
 *
 * @author Administrator
 */
public class OldDriveTrain extends Subsystem{
    SpeedController leftMotor;
    SpeedController leftRear;
    SpeedController rightMotor;
    SpeedController rightRear;
    RobotDrive drive;
    double rightJoyY;
    double leftJoyY;

    // Initialize your subsystem here
    public OldDriveTrain() {
        leftMotor = new Victor(RobotMap.leftMotor);
        rightMotor = new Victor(RobotMap.rightMotor);
        leftRear = new Victor(RobotMap.leftRear);
        rightRear = new Talon(RobotMap.rightRear);
        
        drive = new RobotDrive(leftMotor, rightMotor, leftRear, rightRear);
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

    public void drive(double speed)
    {
        drive.tankDrive(-speed, speed);
    }

    protected double returnPIDInput() {
        return 0.0;
    }

    protected void usePIDOutput(double d) {
    }

}
