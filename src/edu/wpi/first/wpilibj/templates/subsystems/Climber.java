/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

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
    
    Talon leftLongMotor = new Talon(RobotMap.leftLongMotorPort);
    Talon leftShortMotor = new Talon(RobotMap.leftShortMotorPort);
    Talon rightLongMotor = new Talon(RobotMap.rightLongMotorPort);
    Talon rightShortMotor = new Talon(RobotMap.rightShortMotorPort);
    
    DigitalInput leftLongMaxSensor = new DigitalInput(RobotMap.leftLongMaxSensorPort);
    DigitalInput leftLongMinSensor = new DigitalInput(RobotMap.leftLongMinSensorPort);
    DigitalInput leftShortMaxSensor = new DigitalInput(RobotMap.leftShortMaxSensorPort);
    DigitalInput leftShortMinSensor = new DigitalInput(RobotMap.leftShortMinSensorPort);
    DigitalInput rightLongMaxSensor = new DigitalInput(RobotMap.rightLongMaxSensorPort);
    DigitalInput rightLongMinSensor = new DigitalInput(RobotMap.rightLongMinSensorPort);
    DigitalInput rightShortMaxSensor = new DigitalInput(RobotMap.rightShortMaxSensorPort);
    DigitalInput rightShortMinSensor = new DigitalInput(RobotMap.rightShortMinSensorPort);

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand()
    {
        // Set the default command for a subsystem here.
        setDefaultCommand(new GetSensors());
    }

    
    // NOTE: these sensors return true when there are NOT sensing anything.  So we negate the get() so that the
    // meaning of "SensorOn" is correct.
    public boolean isLeftLongMaxSensorOn()
    {
        return !leftLongMaxSensor.get();
    }

    public boolean isLeftLongMinSensorOn()
    {
        return !leftLongMinSensor.get();
    }

    public boolean isLeftShortMaxSensorOn()
    {
        return !leftShortMaxSensor.get();
    }

    public boolean isLeftShortMinSensorOn()
    {
        return !leftShortMinSensor.get();
    }

    public boolean isRightLongMaxSensorOn()
    {
        return !rightLongMaxSensor.get();
    }

    public boolean isRightLongMinSensorOn()
    {
        return !rightLongMinSensor.get();
    }

    public boolean isRightShortMaxSensorOn()
    {
        return !rightShortMaxSensor.get();
    }

    public boolean isRightShortMinSensorOn()
    {
        return !rightShortMinSensor.get();
    }
}
