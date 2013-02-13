/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import Team102Lib.MessageLogger;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Admin
 */
public class GetSensors extends CommandBase
{
    public GetSensors()
    {
        requires(climber);
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
        MessageLogger.LogMessage("Sensor 1: " + climber.isLeftLongMaxSensorOn() 
                + ", Sensor 2: " + climber.isLeftShortMaxSensorOn()
                + ", Sensor 3: " + climber.isLeftLongMinSensorOn()
                );
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
        return false;
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
