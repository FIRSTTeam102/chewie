/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Admin
 */
public class StopClimb extends CommandBase
{
    public StopClimb()
    {
        // Use requires() here to declare subsystem dependencies
        requires(climber);
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
        climber.rightLongMotor.set(0.0);
        climber.leftLongMotor.set(0.0);
        climber.rightShortMotor.set(0.0);
        climber.leftShortMotor.set(0.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
        return true;
    }

    // Called once after isFinished returns true
    protected void end()
    {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted()
    {
    }
}
