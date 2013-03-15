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
public class ShooterResetPart2 extends CommandGroup
{
    public ShooterResetPart2()
    {
        // Add Commands here:
        addSequential(new LoaderIn());
        addSequential(new WaitCommand(0.3));
        addSequential(new GateUp());
    }
}
