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
public class ResetClimb extends CommandGroup
{
    public ResetClimb()
    {
        addSequential(new PushUpLongArmHooks());
        addSequential(new PushUpShortArmHooks());
        addSequential(new RetractShortArms());
        addSequential(new WaitCommand(0.5));
        addSequential(new RetractLongArms());
    }
}
