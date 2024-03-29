/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import Team102Lib.MathLib;
import Team102Lib.MessageLogger;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.SpinnerOn;

/**
 *
 * @author Admin
 */
public class Shooter extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    Solenoid gateSolenoid = new Solenoid(RobotMap.solenoidModule, RobotMap.gateSolenoidUpPort);
    Solenoid loaderInSolenoid = new Solenoid(RobotMap.solenoidModule, RobotMap.loaderInSolenoidPort);
    Solenoid loaderOutSolenoid = new Solenoid(RobotMap.solenoidModule, RobotMap.loaderOutSolenoidPort);
    public Victor spinner = new Victor(RobotMap.spinnerMotor);

    public void initDefaultCommand() {
    }

    public void forceGateUp() {
        gateSolenoid.set(false);
    }

    public void gateUp() {
        if (isSpinnerOn()) {
            forceGateUp();
        }
    }
    public void forceGateDown() {
        gateSolenoid.set(true);
    }   
    public void gateDown() {
        if (isSpinnerOn()) {
           forceGateDown();
            
        }
    }
    public void forceLoaderin() {
         loaderInSolenoid.set(true);
         loaderOutSolenoid.set(false);
    }
    public void loaderIn() {
        if (isSpinnerOn()) {
           forceLoaderin();
        }
    }
    public void forceLoaderout() {
         loaderInSolenoid.set(false);
         loaderOutSolenoid.set(true);
        
    }
    
    public void loaderOut() {
        if (isSpinnerOn()) {
           forceLoaderout();
        }

    }

    public boolean isSpinnerOn() {
        double spinnerValue = spinner.get();
        MessageLogger.LogMessage("Spinner: " + spinnerValue);
        boolean spinnerOn;
        if (RobotMap.spinnerMotorDirection > 0) {
            spinnerOn = (spinnerValue > .98);
        } else {
            spinnerOn = (spinnerValue < -.98);
        }
        return spinnerOn;
    }

    public void turnSpinnerOn() {
        MessageLogger.LogMessage("Turning Spinner On");
        spinner.set(RobotMap.spinnerMotorDirection);
        updateDriverStation();

    }

    public void turnSpinnerOff() {
        MessageLogger.LogMessage("Turning Spinner Off");
        spinner.set(0.0);
        updateDriverStation();

    }

    public void updateDriverStation() {
        if (!isSpinnerOn()) {
            DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser3, 1, "                     ");
            DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser3, 1, "MOTOR IS NOT ON!&#*&$");
        } else {
            DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser3, 1, "                     ");
            DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser3, 1, "Motor is ON!!!!");
        }
        DriverStationLCD.getInstance().updateLCD();
    }
}
