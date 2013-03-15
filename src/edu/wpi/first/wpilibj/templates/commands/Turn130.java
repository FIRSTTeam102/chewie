/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author Admin
 */
public class Turn130 extends CommandBase {
    double initialTime;
    
    public Turn130() {
        requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        initialTime = Timer.getFPGATimestamp();
       
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
         driveTrain.tankDrive(1.0,-1.0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Timer.getFPGATimestamp() - initialTime > 0.9);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        driveTrain.tankDrive(0.0,0.0);
    }
}
