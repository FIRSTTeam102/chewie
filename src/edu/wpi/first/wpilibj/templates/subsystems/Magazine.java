/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import Team102Lib.MessageLogger;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.templates.RobotMap;

   

public class Magazine {
    Solenoid gateSolenoid = new Solenoid(RobotMap.solenoidModule, RobotMap.gateSolenoidUpPort);
    Solenoid loaderUpSolenoid = new Solenoid(RobotMap.solenoidModule, RobotMap.loadersolenoidUpPort);
    Solenoid loaderDownSolenoid = new Solenoid(RobotMap.solenoidModule, RobotMap.loadersolenoidDownPort);
    Solenoid armOneSolenoid = new Solenoid(RobotMap.solenoidModule, RobotMap.armOnePort);
    Solenoid armTwoSolenoid = new Solenoid(RobotMap.solenoidModule, RobotMap.armTwoPort);
    Solenoid armThreeSolenoid = new Solenoid(RobotMap.solenoidModule, RobotMap.armThreePort);
    Solenoid armFourSolenoid = new Solenoid(RobotMap.solenoidModule, RobotMap.armFourPort);

    
    int solenoidPort = RobotMap.gateSolenoidUpPort;
    
    public Magazine() {
    
        
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
        switch(solenoidPort)
        {
            case RobotMap.gateSolenoidUpPort:
            {
                theSolenoid = gateSolenoid;
                break;
            }
            case RobotMap.loadersolenoidUpPort:
            {
                theSolenoid = loaderUpSolenoid;
                secondSolenoid = loaderDownSolenoid;
                if(!setValue)
                    solenoidPort++;
                break;
            }
            case RobotMap.armOnePort:
            {
                theSolenoid = armOneSolenoid;
                break;
            }
            case RobotMap.armTwoPort:
            {
                theSolenoid = armTwoSolenoid;
                break;
            }
            case RobotMap.armThreePort:
            {
                theSolenoid = armThreeSolenoid;
                break;
            }
            case RobotMap.armFourPort:
            {
                theSolenoid = armFourSolenoid;
                break;
            }
      
        }
     
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
