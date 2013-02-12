/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import Team102Lib.MessageLogger;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends IterativeRobot {

    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // instantiate the command used for the autonomous period
       
        // Initialize all subsystems
        try{
        CommandBase.init();
        }
        catch(Exception e){
            MessageLogger.LogError("Unhandled Exception in robotInit()");
            MessageLogger.LogError(e.toString());
            e.printStackTrace();
        }
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        try{
            autonomousCommand.start();
        }
        catch(Exception e){
            MessageLogger.LogError("Unhandled Exception in autonomousInit()");
            MessageLogger.LogError(e.toString());
            e.printStackTrace();
        }
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        try{
            Scheduler.getInstance().run();
        }
        catch(Exception e){
            MessageLogger.LogError("Unhandled Exception in autonomousPeriodic()");
            MessageLogger.LogError(e.toString());
            e.printStackTrace();
        }
    }

    public void teleopInit() {
	// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        try{
            if (autonomousCommand != null)
            autonomousCommand.cancel();
    }
        catch(Exception e){
            MessageLogger.LogError("Unhandled Exception in teleopInit()");
            MessageLogger.LogError(e.toString());
            e.printStackTrace();
        }
    }

    public void disabledInit() {
        try{
        
        }
        catch(Exception e){
            MessageLogger.LogError("Unhandled Exception in disabledInit()");
            MessageLogger.LogError(e.toString());
            e.printStackTrace();
        }
    }
    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        
        try{
            Scheduler.getInstance().run();
        }
        catch(Exception e){
            MessageLogger.LogError("Unhandled Exception in teleopPeriodic()");
            MessageLogger.LogError(e.toString());
            e.printStackTrace();
        }
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        
        try{
            LiveWindow.run();
        }
        catch(Exception e){
            MessageLogger.LogError("Unhandled Exception in testPeriodic()");
            MessageLogger.LogError(e.toString());
            e.printStackTrace();
        }
    }
}
