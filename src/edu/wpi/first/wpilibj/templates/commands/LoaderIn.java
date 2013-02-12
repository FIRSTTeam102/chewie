/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.subsystems.OldMagazine;
import edu.wpi.first.wpilibj.templates.subsystems.Shooter;

/**
 *
 * @author Admin
 */
public class LoaderIn extends CommandBase{
    
    public LoaderIn(){
        requires(shooter);
    }

    protected void initialize() {
    }

    protected void execute() {
        shooter.loaderIn();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
    private void requires(Shooter shooter) {
    }
    
}
