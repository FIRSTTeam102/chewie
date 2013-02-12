/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import Team102Lib.MathLib;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Admin
 */
public class Shooter extends Subsystem
{
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Solenoid gateSolenoid = new Solenoid(RobotMap.solenoidModule, RobotMap.gateSolenoidUpPort);
    Solenoid loaderInSolenoid = new Solenoid(RobotMap.solenoidModule, RobotMap.loaderInSolenoidPort);
    Solenoid loaderOutSolenoid = new Solenoid(RobotMap.solenoidModule, RobotMap.loaderOutSolenoidPort);
    public Talon spinner = new Talon(RobotMap.spinnerMotor);

    public void initDefaultCommand()
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void gateUp()
    {
        if (isSpinnerOn())
        {
            gateSolenoid.set(true);
        }
    }

    public void gateDown()
    {
        if (isSpinnerOn())
        {
            gateSolenoid.set(false);
        }
    }

    public void loaderIn()
    {
        if (isSpinnerOn())
        {
            loaderInSolenoid.set(true);
            loaderOutSolenoid.set(false);
        }
    }

    public void loaderOut()
    {
        if (isSpinnerOn())
        {
            loaderInSolenoid.set(false);
            loaderOutSolenoid.set(true);
        }

    }

    public boolean isSpinnerOn()
    {
        double spinnerValue = spinner.get();
        boolean spinnerOn;
        if (RobotMap.invertSpinnerMotor > 0)
        {
            spinnerOn = (spinnerValue > .98);
        } else
        {
            spinnerOn = (spinnerValue < -.98);
        }

        if (!spinnerOn)
        {
            DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser3, 1, "                     ");
            DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser3, 1, "MOTOR IS NOT ON!&#*&$");
            DriverStationLCD.getInstance().updateLCD();  
        }
        else {
          DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser3, 1, "                     ");
          DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser3, 1, "Motor is ON!!!!");
        }
       return spinnerOn;
    }
}