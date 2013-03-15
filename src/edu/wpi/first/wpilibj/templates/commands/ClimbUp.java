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
public class ClimbUp extends CommandGroup
{
    public ClimbUp()
    {
        // Add Commands here:
        addSequential(new DeployShortArms());
        addSequential(new WaitCommand(0.5));
        addSequential(new PullDownShortArmHooks());

        addSequential(new DeployLongArms());
        addSequential(new PullDownLongArmHooks(1.0)); // Pull for 1 sec
        addSequential(new RetractShortArms());
        addSequential(new PullDownLongArmHooks());

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

    }
}
