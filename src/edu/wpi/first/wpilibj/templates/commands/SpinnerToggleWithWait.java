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
public class SpinnerToggleWithWait extends CommandGroup
{
    public SpinnerToggleWithWait()
    {
        addSequential(new SpinnerToggle());
        addSequential(new WaitCommand(1.5));
    }
}
