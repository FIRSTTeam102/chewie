/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import Team102Lib.MessageLogger;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;

   

public class OldMagazine extends Subsystem{
    Solenoid gateSolenoid = new Solenoid(RobotMap.solenoidModule, RobotMap.gateSolenoidUpPort);
    Solenoid loaderUpSolenoid = new Solenoid(RobotMap.solenoidModule, RobotMap.loaderInSolenoidPort);
    Solenoid loaderDownSolenoid = new Solenoid(RobotMap.solenoidModule, RobotMap.loaderOutSolenoidPort);
    Solenoid armOneSolenoid = new Solenoid(RobotMap.solenoidModule, RobotMap.leftLongMotorPort);
    Solenoid armTwoSolenoid = new Solenoid(RobotMap.solenoidModule, RobotMap.leftShortMotorPort);
    Solenoid armThreeSolenoid = new Solenoid(RobotMap.solenoidModule, RobotMap.rightLongMotorPort);
    Solenoid armFourSolenoid = new Solenoid(RobotMap.solenoidModule, RobotMap.rightShortMotorPort);

    
    int solenoidPort = RobotMap.gateSolenoidUpPort;
    
    public OldMagazine() {
    
        
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        
    }
    
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
    public void solenoidIncrease() {
//        solenoidPort = ++solenoidPort % 6 + 1;
    }
    
    public void activateSolenoid(boolean setValue) {
        
        MessageLogger.LogMessage("solenoidPort: " + solenoidPort);
        Solenoid theSolenoid = null;
        Solenoid secondSolenoid = null;
     
        if(theSolenoid != null)
        {
            theSolenoid.set(setValue);

            if(secondSolenoid != null)
                secondSolenoid.set(!setValue);
        }
        if (!setValue)
            solenoidPort = ++solenoidPort % 6 + 1;
    }
    
   
    
    
    
}
