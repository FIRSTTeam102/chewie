/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import Team102Lib.MessageLogger;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.DriveWithXBox;

/**
 *
 * @author Admin
 */
public class DriveTrain extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public SpeedController leftFrontMotor;
    public SpeedController leftRearMotor;
    public SpeedController rightFrontMotor;
    public SpeedController rightRearMotor;
    RobotDrive drive;
    double rightJoyY;
    double leftJoyY;

    public DriveTrain() {
        leftFrontMotor = new Talon (RobotMap.leftFrontMotorPort);
        rightFrontMotor = new Talon (RobotMap.rightFrontMotorPort);
        // Talons have a built in deadband
        leftRearMotor = new Talon (RobotMap.leftRearMotorPort);
        rightRearMotor = new Talon (RobotMap.rightRearMotorPort);

        drive = new RobotDrive(leftFrontMotor, leftRearMotor, rightFrontMotor, rightRearMotor);
    }

    public void driveWithXBox(Joystick xBox) {

        leftJoyY = xBox.getRawAxis(RobotMap.xBoxLeftYAxis);
        rightJoyY = xBox.getRawAxis(RobotMap.xBoxRightYAxis);

//        MessageLogger.LogMessage("Joysticks: " + -leftJoyY + ", " + rightJoyY);
        drive.tankDrive(leftJoyY, -rightJoyY);

    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveWithXBox());
    }
    
    public void tankDrive(double leftValue, double rightValue) {
        drive.tankDrive(leftValue, -rightValue);
    }
}
