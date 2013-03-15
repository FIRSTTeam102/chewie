/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 * @author Admin
 */
public class ShooterReset extends CommandGroup
{
    public ShooterReset()
    {
        // This assumes the gate is down.
        
        addSequential(new LoaderOut());
        addSequential(new WaitCommand(0.3));
        addSequential(new LoaderIn());
        addSequential(new WaitCommand(0.3));

        // This assumes there will be a subsequent command to put the gate up.
    }
}
