/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import Team102Lib.MessageLogger;

/**
 *
 * @author Admin
 */
public class ClimbSucessfulCheck extends CommandBase
{
    public ClimbSucessfulCheck()
    {
        requires(climber);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
        if (climber.climbLevel == 1)
        {
            CommandBase.oi.xBoxOperatorRightBumper.whenPressed(new ClimbToSecondLevel());
            climber.climbLevel = 2;
            MessageLogger.LogMessage("Current Climb Level is " + climber.climbLevel);
        } else
        {
            CommandBase.oi.xBoxOperatorRightBumper.whenPressed(new ClimbToFirstLevel());
            climber.climbLevel = 1;
            MessageLogger.LogMessage("Current Climb Level is " + climber.climbLevel);
        }
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
