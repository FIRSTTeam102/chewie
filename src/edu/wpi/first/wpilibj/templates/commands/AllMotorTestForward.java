/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import Team102Lib.MessageLogger;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author Admin
 */
public class AllMotorTestForward extends CommandBase {
    double initialTime;
    
    public AllMotorTestForward() {
        // Use requires() here to declare subsystem dependencies
        requires(driveTrain);
        requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        shooter.spinner.set(0.2);
        initialTime = Timer.getFPGATimestamp();
        MessageLogger.LogMessage("Motors Full Forward");
        
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        driveTrain.tankDrive(0.3,0.3);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
       
        return ((Timer.getFPGATimestamp() - initialTime) > 3.0 );
    }

    // Called once after isFinished returns true
    protected void end() {
        driveTrain.tankDrive(0.0,0.0);
        shooter.spinner.set(0.0);
        MessageLogger.LogMessage("Forward Stopped");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
        MessageLogger.LogMessage("AllMotorTestForward Inturrupted");
    }
}
