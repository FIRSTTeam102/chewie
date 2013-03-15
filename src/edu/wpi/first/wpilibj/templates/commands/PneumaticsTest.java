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
public class PneumaticsTest extends CommandBase {
    
    public PneumaticsTest() {
        // Use requires() here to declare subsystem dependencies
        requires(shooter);
        requires(climber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        shooter.forceGateDown();
        MessageLogger.LogMessage("Gate Down");
        Timer.delay(0.5);
        shooter.forceGateUp();
        MessageLogger.LogMessage("Gate Up");
        Timer.delay(0.5);
        shooter.forceLoaderout();
        MessageLogger.LogMessage("Loader Out");
        Timer.delay(0.5);
        shooter.forceLoaderin();
        MessageLogger.LogMessage("Loader In");
        Timer.delay(0.5);
        climber.deployShortArms();
        MessageLogger.LogMessage("Short Arms Deployed");
        Timer.delay(5);
        climber.retractShortArms();
        MessageLogger.LogMessage("Short Arms Retracted");
        Timer.delay(5);
        climber.deployLongArms();
        MessageLogger.LogMessage("Long Arms Deployed");
        Timer.delay(5);
        climber.retractLongArms();
        MessageLogger.LogMessage("Long Arms Retracted");
        
    }
    

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
