/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Admin
 */
public class PushUpShortArmHooks extends CommandBase
{
    double initialTime;

    public PushUpShortArmHooks()
    {
        requires(climber);

    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
        climber.rightShortMotor.set(-RobotMap.climberArmPushSpeed);
        climber.leftShortMotor.set(-RobotMap.climberArmPushSpeed);
        initialTime = Timer.getFPGATimestamp();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
        if (climber.isRightShortMaxSensorOn())
        {
            climber.rightLongMotor.set(0.0);
        }

        if (climber.isLeftShortMaxSensorOn())
        {
            climber.leftLongMotor.set(0.0);
        }

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {

        return ((climber.isRightShortMaxSensorOn() && climber.isLeftShortMaxSensorOn())
                || (Timer.getFPGATimestamp() - initialTime) > RobotMap.climberPushTimeOut);
    }

    // Called once after isFinished returns true
    protected void end()
    {
        climber.leftShortMotor.set(0.0);
        climber.rightShortMotor.set(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted()
    {
        climber.leftShortMotor.set(0.0);
        climber.rightShortMotor.set(0.0);
    }
}