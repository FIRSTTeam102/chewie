/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import Team102Lib.MessageLogger;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 * @author Admin
 */
public class ResetFirstLevelClimb extends CommandGroup
{
    public ResetFirstLevelClimb()
    {
        addSequential(new PushUpShortArmHooks(3.0));
        addSequential(new RetractShortArms());
    }
}
