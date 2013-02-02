
package edu.wpi.first.wpilibj.templates;

import Team102Lib.MessageLogger;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.ActivateSolenoid;
import edu.wpi.first.wpilibj.templates.commands.CompressorOn;
import edu.wpi.first.wpilibj.templates.commands.GateDown;
import edu.wpi.first.wpilibj.templates.commands.GateUp;
import edu.wpi.first.wpilibj.templates.commands.SolenoidIncrease;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    private Joystick xBox;
    private JoystickButton xBoxA;
    private JoystickButton xBoxB;
    
    
    public OI() {
        try
        {
            xBox = new Joystick(1);

            xBoxA = new JoystickButton(xBox, RobotMap.xBoxAIndex);
            xBoxB = new JoystickButton(xBox, RobotMap.xBoxBIndex);

            xBoxA.whenPressed(new GateUp());
            xBoxA.whenReleased(new GateDown());
            xBoxB.whenPressed(new ActivateSolenoid(true));
            xBoxB.whenReleased(new ActivateSolenoid(false));
        }
        catch(Exception ex1)
        {
            MessageLogger.LogError("Unhandled Exception in OI constructor.");
            MessageLogger.LogError(ex1.toString());
        }
}
    public Joystick getXBox()
    {
        return xBox;
    }
}


