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
public class ShootFour extends CommandGroup {

    public ShootFour() {
        addSequential(new Shoot());
        addSequential(new WaitCommand(0.5));
        addSequential(new Shoot());
        addSequential(new WaitCommand(0.5));
        addSequential(new Shoot());
        addSequential(new WaitCommand(0.5));
        addSequential(new Shoot());
    }
}
