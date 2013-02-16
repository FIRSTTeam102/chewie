package edu.wpi.first.wpilibj.templates;

import Team102Lib.MessageLogger;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.CompressorOn;
import edu.wpi.first.wpilibj.templates.commands.DeployShortArms;
import edu.wpi.first.wpilibj.templates.commands.GateDown;
import edu.wpi.first.wpilibj.templates.commands.GateUp;
import edu.wpi.first.wpilibj.templates.commands.PullDownLongArmHooks;
import edu.wpi.first.wpilibj.templates.commands.PullDownShortArmHooks;
import edu.wpi.first.wpilibj.templates.commands.PushUpLongArmHooks;
import edu.wpi.first.wpilibj.templates.commands.PushUpShortArmHooks;
import edu.wpi.first.wpilibj.templates.commands.RetractShortArms;
import edu.wpi.first.wpilibj.templates.commands.Shoot;
import edu.wpi.first.wpilibj.templates.commands.SpinnerOn;
import edu.wpi.first.wpilibj.templates.commands.SpinnerToggle;
import edu.wpi.first.wpilibj.templates.subsystems.Shooter;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI
{
    private Joystick xBoxDriver;
    private Joystick xBoxOperator;
    private JoystickButton xBoxDriverA;
    private JoystickButton xBoxDriverStart;
    private JoystickButton xBoxDriverB;
    private JoystickButton xBoxDriverRightBumper;
    private JoystickButton xBoxDriverLeftBumper;
    private JoystickButton xBoxOperatorA;
    private JoystickButton xBoxOperatorB;
    private JoystickButton xBoxOperatorX;
    private JoystickButton xBoxOperatorY;

    public OI()
    {
        try
        {
            xBoxDriver = new Joystick(1);
            xBoxOperator = new Joystick(2);

            xBoxDriverA = new JoystickButton(xBoxDriver, RobotMap.xBoxAIndex);
            xBoxDriverB = new JoystickButton(xBoxDriver, RobotMap.xBoxBIndex);
            xBoxDriverStart = new JoystickButton(xBoxDriver, RobotMap.xBoxStartButtonIndex);
            xBoxDriverRightBumper = new JoystickButton(xBoxDriver, RobotMap.xBoxRightBumperIndex);
            xBoxDriverLeftBumper = new JoystickButton(xBoxDriver, RobotMap.xBoxLeftBumperIndex);
            xBoxOperatorA = new JoystickButton(xBoxOperator, RobotMap.xBoxAIndex);
            xBoxOperatorB = new JoystickButton(xBoxOperator, RobotMap.xBoxBIndex);
            xBoxOperatorX = new JoystickButton(xBoxOperator, RobotMap.xBoxXIndex);
            xBoxOperatorY = new JoystickButton(xBoxOperator, RobotMap.xBoxYIndex);



            xBoxDriverA.whenPressed(new Shoot());
            xBoxDriverStart.whenPressed(new SpinnerToggle());
            xBoxDriverRightBumper.whenPressed(new DeployShortArms());
            xBoxDriverLeftBumper.whenPressed(new RetractShortArms());
            
            xBoxOperatorB.whenPressed(new PushUpShortArmHooks());
            xBoxOperatorA.whenPressed(new PullDownShortArmHooks());
            xBoxOperatorY.whenPressed(new PushUpLongArmHooks());
            xBoxOperatorX.whenPressed(new PullDownLongArmHooks());

        } catch (Exception ex1)
        {
            MessageLogger.LogError("Unhandled Exception in OI constructor.");
            MessageLogger.LogError(ex1.toString());
        }
    }

    public Joystick getXBox()
    {
        return xBoxDriver;
    }
}
