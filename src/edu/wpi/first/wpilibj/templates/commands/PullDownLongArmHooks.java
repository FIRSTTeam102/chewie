/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
    package edu.wpi.first.wpilibj.templates.commands;

import Team102Lib.MessageLogger;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Admin
 */
public class PullDownLongArmHooks extends CommandBase
{
    double initialTime;
    double timeout;

    public PullDownLongArmHooks()
    {
        requires(climber);
        timeout = RobotMap.climberPullTimeOut;

    }
    public PullDownLongArmHooks(double overrideTimeout)
    {
        requires(climber);
        timeout = overrideTimeout;

    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
        MessageLogger.LogMessage("PullDownLongArmHooks(" + timeout + ")");
        climber.rightLongMotor.set(RobotMap.climberArmPullSpeed);
        climber.leftLongMotor.set(RobotMap.climberArmPullSpeed);
        initialTime = Timer.getFPGATimestamp();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
        if (climber.isRightLongMinSensorOn())
        {
            climber.rightLongMotor.set(0.0);
        }

        if (climber.isLeftLongMinSensorOn())
        {
            climber.leftLongMotor.set(0.0);
        }

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
        boolean finished = ((climber.isRightLongMinSensorOn() && climber.isLeftLongMinSensorOn())
                || (Timer.getFPGATimestamp() - initialTime) > timeout);
        
        if((Timer.getFPGATimestamp() - initialTime) > timeout)
            MessageLogger.LogMessage("PullDownLongArmHooks timed out.");
        
        return finished;
    }

    // Called once after isFinished returns true
    protected void end()
    {
        climber.leftLongMotor.set(0.0);
        climber.rightLongMotor.set(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted()
    {
        climber.leftLongMotor.set(0.0);
        climber.rightLongMotor.set(0.0);
    }
}
