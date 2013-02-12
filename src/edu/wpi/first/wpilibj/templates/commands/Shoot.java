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
public class Shoot extends CommandGroup
{
    public Shoot()
    {

        addSequential(new LoaderOut());
        addSequential(new WaitCommand(1.0));
        addSequential(new GateDown());
        addSequential(new WaitCommand(1.0));
        addSequential(new LoaderIn());
        addSequential(new WaitCommand(1.0));
        addSequential(new GateUp());
    }
}
