
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
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
    
    
    public OI() {
    xBox = new Joystick(1);
    xBoxA = new JoystickButton(xBox,1);
    xBoxA.whenPressed(new GateUp());
    xBoxA.whenPressed(new SolenoidIncrease());
    xBoxA.whenReleased(new GateDown());
}
    public Joystick getXBox()
    {
        return xBox;
    }
}


