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
public class ClimbToFirstLevel extends CommandGroup
{
    public ClimbToFirstLevel()
    {
        // Add Commands here:
        addSequential(new DeployShortArms());
        addSequential(new WaitCommand(1.5));
        addSequential(new PullDownShortArmHooks());

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

    }
}
