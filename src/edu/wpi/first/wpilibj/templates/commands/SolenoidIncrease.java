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
public class SolenoidIncrease extends CommandBase{
    
    public SolenoidIncrease(){
    
    }

    protected void initialize() {
    }

    protected void execute() {
        int module = RobotMap.gateSolenoidUpPort;
        module ++;
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}
