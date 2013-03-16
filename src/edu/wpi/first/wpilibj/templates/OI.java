package edu.wpi.first.wpilibj.templates;

import Team102Lib.MessageLogger;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.ClimbToFirstLevel;
import edu.wpi.first.wpilibj.templates.commands.ClimbToSecondLevel;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
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
import edu.wpi.first.wpilibj.templates.commands.ResetClimb;
import edu.wpi.first.wpilibj.templates.commands.ResetFirstLevelClimb;
import edu.wpi.first.wpilibj.templates.commands.RetractShortArms;
import edu.wpi.first.wpilibj.templates.commands.Shoot;
import edu.wpi.first.wpilibj.templates.commands.ShootFour;
import edu.wpi.first.wpilibj.templates.commands.ShootTest;
import edu.wpi.first.wpilibj.templates.commands.ShooterReset;
import edu.wpi.first.wpilibj.templates.commands.ShooterResetPart2;
import edu.wpi.first.wpilibj.templates.commands.SpinnerOn;
import edu.wpi.first.wpilibj.templates.commands.SpinnerToggle;
import edu.wpi.first.wpilibj.templates.commands.SpinnerToggleWithWait;
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
    public JoystickButton xBoxOperatorRightBumper;
    private JoystickButton xBoxOperatorLeftBumper;
    private JoystickButton xBoxOperatorBack;
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
            xBoxOperatorBack = new JoystickButton(xBoxOperator, RobotMap.xBoxBackButtonIndex);

            context = "creating test buttons.";
            xBoxTestA = new JoystickButton(xBoxTest, RobotMap.xBoxAIndex);
            xBoxTestB = new JoystickButton(xBoxTest, RobotMap.xBoxBIndex);
            xBoxTestX = new JoystickButton(xBoxTest, RobotMap.xBoxXIndex);
            xBoxTestY = new JoystickButton(xBoxTest, RobotMap.xBoxYIndex);
            xBoxTestStart = new JoystickButton(xBoxTest, RobotMap.xBoxStartButtonIndex);
            xBoxTestRightBumper = new JoystickButton(xBoxTest, RobotMap.xBoxRightBumperIndex);
            xBoxTestLeftBumper = new JoystickButton(xBoxTest, RobotMap.xBoxLeftBumperIndex);

            // Driver Controls
            // Operator Controls

            context = "xBoxOperatorStart.whenPressed(new SpinnerToggle())";
            xBoxOperatorStart.whenPressed(new SpinnerToggle());
            context = "xBoxOperatorA.whenPressed(new Shoot())";
            xBoxOperatorA.whenPressed(new Shoot());
            context = "xBoxOperatorX.whenPressed(new ShootFour())";
            xBoxOperatorX.whenPressed(new ShootFour());

            context = "xBoxOperatorRightBumper.whenPressed(new ClimbToSecondLevel())";
            xBoxOperatorRightBumper.whenPressed(new ClimbToSecondLevel());
//            context = "xBoxOperatorRightBumper.whenPressed(new RetractShortArms()";
//            xBoxOperatorRightBumper.whenPressed(new RetractShortArms());
            context = "xBoxOperatorRightBumper.whenReleased(new StopClimb())";
            xBoxOperatorRightBumper.whenReleased(new StopClimb());
            context = "xBoxOperatorLeftBumper.whenPressed(new ResetFirstLevelClimb())";
            xBoxOperatorLeftBumper.whenPressed(new ResetFirstLevelClimb());
//            context = "xBoxOperatorLeftBumper.whenPressed(new DeployShortArms())";
//            xBoxOperatorLeftBumper.whenPressed(new DeployShortArms());
//            context = "xBoxOperatorLeftBumper.whenPressed(new ResetClimb())";
//            xBoxOperatorBack.whenPressed(new GateDown());
//            xBoxOperatorBack.whileHeld(new ShooterReset());
//            xBoxOperatorBack.whenReleased(new ShooterResetPart2());

            //Test Controls
            DriverStation ds = DriverStation.getInstance();

            // context  = "xBoxTestA.whenPressed(new MotorTest() )";
            //xBoxTestA.whenPressed(new MotorTest() );
            context = "xBoxTestA.whenPressed(new ResetClimb() )";
            xBoxTestA.whenPressed(new ResetClimb());
            //context  = "xBoxTestB.whenPressed(new PushUpLongArmHooks()";
            //xBoxTestB.whenPressed(new PushUpLongArmHooks());
            context = "xBoxTestX.whenPressed(new ShootTest())";
            xBoxTestX.whenPressed(new ShootTest());
            // context = "xBoxTestY.whenPressed(new PushUpShortArmHooks()";
            // xBoxTestY.whenPressed(new PushUpShortArmHooks());
            //context  = "xBoxTestStart.whenPressed(new PneumaticsTest())";
            context = "xBoxTestY.whenPressed(new PneumaticsTest())";
            xBoxTestY.whenPressed(new PneumaticsTest());
            context = "xBoxB.whenPressed(new ClimbToSecondLevel())";
            xBoxTestB.whenPressed(new ClimbToSecondLevel());;
//            if(ds.getDigitalIn(1)) {
//                xBoxTestStart.whenPressed(new ClimbToFirstLevel());
//            }
//            else {
//                xBoxTestStart.whenPressed(new PneumaticsTest());
            //           }
            context = "xBoxTestLeftBumper.whenPressed(new GateDown())";
            xBoxTestLeftBumper.whenPressed(new GateDown());   // was throwing exception.
            context = "xBoxTestRightBumper.whenPressed(new GateUp())";
            xBoxTestRightBumper.whenPressed(new GateUp());    // was throwing exception.
            context = "xBoxTestRighBumper.whenPressed(new PullDownShortArmHooks()";
            // xBoxTestRightBumper.whenPressed(new PullDownShortArmHooks()); 
            context = "xBoxTestLeftBumper.whenPressed(new PullDownLongArmHooks()";
            //xBoxTestLeftBumper.whenPressed(new PullDownLongArmHooks());

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
