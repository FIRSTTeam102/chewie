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
public class PullDownLongArmHooks extends CommandBase
{
    double initialTime;

    public PullDownLongArmHooks()
    {
        requires(climber);

    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
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

        return ((climber.isRightLongMinSensorOn() && climber.isLeftLongMinSensorOn())
                || (Timer.getFPGATimestamp() - initialTime) > RobotMap.climberPullTimeOut);
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
