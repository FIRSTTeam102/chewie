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
public class Autonomous extends CommandGroup
{
    public Autonomous()
    {
        addSequential(new SpinnerToggle()); // Turn motor on
        addSequential(new WaitCommand(3.0)); //This is how long we're waiting for pneumatics to get to pressure
        addSequential(new Shoot());
        addSequential(new WaitCommand(0.5));
        addSequential(new Shoot());
        addSequential(new WaitCommand(0.5));
        addSequential(new Shoot());
        addSequential(new SpinnerToggle()); // Turn motor off
        
    }
}
