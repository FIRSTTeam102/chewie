/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import Team102Lib.MessageLogger;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.GetSensors;

/**
 *
 * @author Admin
 */
public class Climber extends Subsystem
{
    Solenoid leftLongExtendSolenoid = new Solenoid(RobotMap.solenoidModule, RobotMap.leftLongExtendPort);
    Solenoid leftShortExtendSolenoid = new Solenoid(RobotMap.solenoidModule, RobotMap.leftShortExtendPort);
    Solenoid rightLongExtendSolenoid = new Solenoid(RobotMap.solenoidModule, RobotMap.rightLongExtendPort);
    Solenoid rightShortExtendSolenoid = new Solenoid(RobotMap.solenoidModule, RobotMap.rightShortExtendPort);
    
    public Talon leftLongMotor = new Talon(RobotMap.leftLongMotorPort);
    public Talon leftShortMotor = new Talon(RobotMap.leftShortMotorPort);
    public Talon rightLongMotor = new Talon(RobotMap.rightLongMotorPort);
    public Talon rightShortMotor = new Talon(RobotMap.rightShortMotorPort);
    
    //DigitalInput leftLongMaxSensor = new DigitalInput(RobotMap.leftLongMaxSensorPort);
    DigitalInput leftLongMinSensor = new DigitalInput(RobotMap.leftLongMinSensorPort);
    //DigitalInput leftShortMaxSensor = new DigitalInput(RobotMap.leftShortMaxSensorPort);
    DigitalInput leftShortMinSensor = new DigitalInput(RobotMap.leftShortMinSensorPort);
    //DigitalInput rightLongMaxSensor = new DigitalInput(RobotMap.rightLongMaxSensorPort);
    DigitalInput rightLongMinSensor = new DigitalInput(RobotMap.rightLongMinSensorPort);
    //DigitalInput rightShortMaxSensor = new DigitalInput(RobotMap.rightShortMaxSensorPort);
    DigitalInput rightShortMinSensor = new DigitalInput(RobotMap.rightShortMinSensorPort);

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand()
    {
        // Set the default command for a subsystem here.
//        setDefaultCommand(new GetSensors());
    }

    // NOTE: these sensors return true when there are NOT sensing anything.  So we negate the get() so that the
    // meaning of "SensorOn" is correct.
  

    public boolean isLeftLongMinSensorOn()
    {
        return !leftLongMinSensor.get();
    }

    

    public boolean isLeftShortMinSensorOn()
    {
        return !leftShortMinSensor.get();
    }

    
    public boolean isRightLongMinSensorOn()
    {
        return !rightLongMinSensor.get();
    }

    
    public boolean isRightShortMinSensorOn()
    {
        return !rightShortMinSensor.get();
    }

    public void deployShortArms()
    {
        MessageLogger.LogMessage("delpoyShortArms");
        leftShortExtendSolenoid.set(true);
        rightShortExtendSolenoid.set(true);
    }

    public void retractShortArms()
    {
        MessageLogger.LogMessage("retractShortArms");
        leftShortExtendSolenoid.set(false);
        rightShortExtendSolenoid.set(false);
    }

    public void deployLongArms()
    {
        leftLongExtendSolenoid.set(true);
        rightLongExtendSolenoid.set(true);

    }

    public void retractLongArms()
    {
        leftLongExtendSolenoid.set(false);
        rightLongExtendSolenoid.set(false);
    }
}
