/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.subsystems.Shooter;

/**
 *
 * @author Admin
 */
public class GateDown extends CommandBase {
    
    public GateDown() {
        requires(shooter);
    }
     protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
      shooter.gateDown();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }

    private void requires(Shooter shooter) {
    }
}
