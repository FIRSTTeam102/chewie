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
public class ClimbContinue extends CommandGroup
{
    public ClimbContinue()
    {
        // Add Commands here:
        addSequential(new DeployLongArms());
        addSequential(new WaitCommand(1.5));
        addSequential(new PullDownLongArmHooks(1.0)); // Pull for 1 sec
        addSequential(new RetractShortArms());
        addSequential(new PullDownLongArmHooks());
        addSequential(new PushUpShortArmHooks());

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

    }
}
