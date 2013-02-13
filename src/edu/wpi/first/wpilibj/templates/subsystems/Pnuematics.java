/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import Team102Lib.MessageLogger;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.MaintainPressure;

/**
 *
 * @author pingas Administrator
 */
public class Pnuematics extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    Relay compressorSwitch;
    boolean relayOn;                //
    DigitalInput pressureSensor;

    public Pnuematics(){
        compressorSwitch = new Relay(RobotMap.compressorSwitchPort, Relay.Direction.kForward) ;
        pressureSensor = new DigitalInput(RobotMap.compressorSensorPort) ;
        relayOn = false;
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new MaintainPressure());
    }
    public void switchCompressor(boolean switchOn){
        if((switchOn && relayOn) || (!switchOn && !relayOn))
            return;
        if (switchOn && !relayOn)
        {
            compressorSwitch.set(Relay.Value.kOn);
            relayOn = true;
            MessageLogger.LogMessage("Compressor On");
        }
        else
        {
            compressorSwitch.set(Relay.Value.kOff);
            relayOn = false;
            MessageLogger.LogMessage("Compressor Off");
        }
    }
    public void maintainPressure()
    {
        if(pressureSensor.get())
            switchCompressor(false);
        else
            switchCompressor(true);
        
//        MessageLogger.LogMessage("compressor: " + pressureSensor.get());
        
    }
}