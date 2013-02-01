/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.templates.RobotMap;

   

public class Magazine {
    Solenoid gateSolenoid = new Solenoid(RobotMap.solenoidModule, RobotMap.gateSolenoidUpPort);
    Solenoid loaderUpSolenoid = new Solenoid(RobotMap.solenoidModule, RobotMap.loadersolenoidUpPort);
    Solenoid loaderDownSolenoid = new Solenoid(RobotMap.solenoidModule, RobotMap.loadersolenoidDownPort);
    
    public void gateUp () {
        gateSolenoid.set(true);
    }
    public void gateDown() {
        gateSolenoid.set(false);
    }
    public void loaderUp(){
        loaderUpSolenoid.set(true);
        loaderDownSolenoid.set(false);
    }
    public void loaderDown(){
        loaderUpSolenoid.set(false);
        loaderDownSolenoid.set(true);
    }
}
