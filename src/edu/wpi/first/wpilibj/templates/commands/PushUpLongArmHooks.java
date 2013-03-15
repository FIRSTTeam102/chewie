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
public class PushUpLongArmHooks extends CommandBase
{
    double initialTime;

    public PushUpLongArmHooks()
    {
        requires(climber);

    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
        MessageLogger.LogMessage("PullDownLongArmHooks()");
        climber.rightLongMotor.set(-RobotMap.climberArmPushSpeed);
        climber.leftLongMotor.set(-RobotMap.climberArmPushSpeed);
        initialTime = Timer.getFPGATimestamp();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
       

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
        return ((Timer.getFPGATimestamp() - initialTime) > RobotMap.climberPushTimeOut);
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
