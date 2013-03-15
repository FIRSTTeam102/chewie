/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Admin
 */
public class ClimbToSecondLevel extends CommandGroup
{
    public ClimbToSecondLevel()
    {
        addSequential(new ClimbToFirstLevel());
        addSequential(new ClimbContinue());
    }
}
