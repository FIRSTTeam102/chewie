package edu.wpi.first.wpilibj.templates;

import Team102Lib.MessageLogger;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.ClimbUp;
import edu.wpi.first.wpilibj.templates.commands.CompressorOn;
import edu.wpi.first.wpilibj.templates.commands.DeployShortArms;
import edu.wpi.first.wpilibj.templates.commands.GateDown;
import edu.wpi.first.wpilibj.templates.commands.GateUp;
import edu.wpi.first.wpilibj.templates.commands.GetSensors;
import edu.wpi.first.wpilibj.templates.commands.MotorTest;
import edu.wpi.first.wpilibj.templates.commands.PneumaticsTest;
import edu.wpi.first.wpilibj.templates.commands.PullDownLongArmHooks;
import edu.wpi.first.wpilibj.templates.commands.PullDownShortArmHooks;
import edu.wpi.first.wpilibj.templates.commands.PushUpLongArmHooks;
import edu.wpi.first.wpilibj.templates.commands.PushUpShortArmHooks;
import edu.wpi.first.wpilibj.templates.commands.RetractShortArms;
import edu.wpi.first.wpilibj.templates.commands.Shoot;
import edu.wpi.first.wpilibj.templates.commands.ShootFour;
import edu.wpi.first.wpilibj.templates.commands.ShootTest;
import edu.wpi.first.wpilibj.templates.commands.SpinnerOn;
import edu.wpi.first.wpilibj.templates.commands.SpinnerToggle;
import edu.wpi.first.wpilibj.templates.commands.StopClimb;
import edu.wpi.first.wpilibj.templates.commands.Turn130;
import edu.wpi.first.wpilibj.templates.subsystems.Shooter;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI
{
    private Joystick xBoxDriver;
    private JoystickButton xBoxDriverA;
    private JoystickButton xBoxDriverB;
    private JoystickButton xBoxDriverStart;
    private JoystickButton xBoxDriverRightBumper;
    private JoystickButton xBoxDriverLeftBumper;

    private Joystick xBoxOperator;
    private JoystickButton xBoxOperatorA;
    private JoystickButton xBoxOperatorB;
    private JoystickButton xBoxOperatorX;
    private JoystickButton xBoxOperatorY;
    private JoystickButton xBoxOperatorStart;
    private JoystickButton xBoxOperatorRightBumper;
    private JoystickButton xBoxOperatorLeftBumper;
    
    private Joystick xBoxTest;
    private JoystickButton xBoxTestA;
    private JoystickButton xBoxTestB;
    private JoystickButton xBoxTestX;
    private JoystickButton xBoxTestY;
    private JoystickButton xBoxTestStart;
    private JoystickButton xBoxTestRightBumper;
    private JoystickButton xBoxTestLeftBumper;

    public OI()
    {
        String context = "";
        try
        {
            context = "creating Joysticks.";
            xBoxDriver = new Joystick(1);
            xBoxOperator = new Joystick(2);
            xBoxTest = new Joystick(3);

            context = "creating driver buttons.";
            xBoxDriverA = new JoystickButton(xBoxDriver, RobotMap.xBoxAIndex);
            xBoxDriverB = new JoystickButton(xBoxDriver, RobotMap.xBoxBIndex);
            xBoxDriverStart = new JoystickButton(xBoxDriver, RobotMap.xBoxStartButtonIndex);
            xBoxDriverRightBumper = new JoystickButton(xBoxDriver, RobotMap.xBoxRightBumperIndex);
            xBoxDriverLeftBumper = new JoystickButton(xBoxDriver, RobotMap.xBoxLeftBumperIndex);

            context = "creating operator buttons.";
            xBoxOperatorA = new JoystickButton(xBoxOperator, RobotMap.xBoxAIndex);
            xBoxOperatorB = new JoystickButton(xBoxOperator, RobotMap.xBoxBIndex);
            xBoxOperatorX = new JoystickButton(xBoxOperator, RobotMap.xBoxXIndex);
            xBoxOperatorY = new JoystickButton(xBoxOperator, RobotMap.xBoxYIndex);
            xBoxOperatorStart = new JoystickButton(xBoxOperator, RobotMap.xBoxStartButtonIndex);
            xBoxOperatorRightBumper = new JoystickButton(xBoxOperator, RobotMap.xBoxRightBumperIndex);
            xBoxOperatorLeftBumper = new JoystickButton(xBoxOperator, RobotMap.xBoxLeftBumperIndex);

            context = "creating test buttons.";
            xBoxTestA = new JoystickButton(xBoxTest, RobotMap.xBoxAIndex);
            xBoxTestB = new JoystickButton(xBoxTest, RobotMap.xBoxBIndex);
            xBoxTestX = new JoystickButton(xBoxTest, RobotMap.xBoxXIndex);
            xBoxTestY = new JoystickButton(xBoxTest, RobotMap.xBoxYIndex);

            // Driver Controls
            // Operator Controls

            context = "xBoxOperatorStart.whenPressed(new SpinnerToggle())";
            xBoxOperatorStart.whenPressed(new SpinnerToggle());
            context = "xBoxOperatorA.whenPressed(new Shoot())";
            xBoxOperatorA.whenPressed(new Shoot()); 
            context = "xBoxOperatorX.whenPressed(new ShootFour())";
            xBoxOperatorX.whenPressed(new ShootFour());
            
            context = "xBoxOperatorRightBumper.whenPressed(new ClimbUp())";
            xBoxOperatorRightBumper.whenPressed(new ClimbUp());
            context = "xBoxOperatorRightBumper.whenReleased(new StopClimb())";
            xBoxOperatorRightBumper.whenReleased(new StopClimb());
            
            //Test Controls
            context  = "xBoxTestY.whenPressed(new PneumaticsTest())";
            xBoxTestY.whenPressed(new PneumaticsTest());
            context  = "xBoxTestX.whenPressed(new ShootTest())";
            xBoxTestX.whenPressed(new ShootTest());
            context  = "xBoxTestA.whenPressed(new MotorTest() )";
            xBoxTestA.whenPressed(new MotorTest() );
            context  = "xBoxTestB.whenPressed(new Turn130())";
            xBoxTestB.whenPressed(new Turn130());
            context  = "xBoxTestLeftBumper.whenPressed(new GateDown())";
//            xBoxTestLeftBumper.whenPressed(new GateDown());   // was throwing exception.
            context  = "xBoxTestRightBumper.whenPressed(new GateUp())";
//            xBoxTestRightBumper.whenPressed(new GateUp());    // was throwing exception.
            context  = " xBoxTestRightBumper.whenPressed(new GetSensors())";
            xBoxTestRightBumper.whenPressed(new GetSensors());   

        } catch (Exception ex1)
        {
            MessageLogger.LogError("Unhandled Exception in OI constructor while " + context);
            MessageLogger.LogError(ex1.toString());
        }
    }

    public Joystick getXBoxDriver()
    {
        return xBoxDriver;
    }
}
