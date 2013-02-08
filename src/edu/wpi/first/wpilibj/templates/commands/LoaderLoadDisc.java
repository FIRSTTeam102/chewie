/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.subsystems.OldMagazine;

/**
 *
 * @author Admin
 */
public class LoaderLoadDisc extends CommandBase{
    
    public LoaderLoadDisc(){
        requires(magazine);
    }

    protected void initialize() {
    }

    protected void execute() {
        magazine.loaderUp();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
    private void requires(OldMagazine magazine) {
    }
    
}
