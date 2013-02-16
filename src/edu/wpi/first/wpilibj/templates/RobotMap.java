package edu.wpi.first.wpilibj.templates;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
    
    public static final int solenoidModule = 2; //4 port crio this is port 4, on 8 port crio this is port 7
    
    // Drive Motors
    public static final int leftFrontMotorPort = 1;
    public static final int rightFrontMotorPort = 9;
    public static final int leftRearMotorPort = 2;
    public static final int rightRearMotorPort = 10;
    
    //Digital Outputs
    public static final int compressorSwitchPort = 8;
    public static final int compressorSensorPort = 10;
    
    
    
    
    //Shooter *Formerly Magazine*
    
    //Motor Ports
    public static final int spinnerMotor = 6;
    
    //Solenoid Ports
    public static final int gateSolenoidUpPort = 7;
    public static final int loaderInSolenoidPort = 5;
    public static final int loaderOutSolenoidPort = 6;
    
    
    
    
    
    //Climbing
    
    //Motor Ports
    public static final int leftLongMotorPort = 3;
    public static final int leftShortMotorPort = 4;
    public static final int rightLongMotorPort = 8;
    public static final int rightShortMotorPort = 7;
    
    //Sensor Digital Input Port
    public static final int leftLongMaxSensorPort = 1;
    public static final int leftShortMaxSensorPort = 2;
    public static final int rightLongMaxSensorPort = 9;
    public static final int rightShortMaxSensorPort = 8;
    public static final int leftLongMinSensorPort = 3;
    public static final int leftShortMinSensorPort = 4;
    public static final int rightLongMinSensorPort = 7;
    public static final int rightShortMinSensorPort = 6;
    
    //Solenoid Ports
    public static final int leftLongExtendPort = 1;
    public static final int leftShortExtendPort = 2;
    public static final int rightLongExtendPort = 3;
    public static final int rightShortExtendPort = 4;
    
    public static final double spinnerMotorDirection = 1.0; //Make this -1.0 if Spinner motor needs to be inverted
    
    
     // XBox Controller Button Indexes
    public static final int xBoxAIndex = 1;
    public static final int xBoxBIndex = 2;
    public static final int xBoxXIndex = 3;
    public static final int xBoxYIndex = 4;
    public static final int xBoxLeftBumperIndex = 5;
    public static final int xBoxRightBumperIndex = 6;
    public static final int xBoxBackButtonIndex = 7;
    public static final int xBoxStartButtonIndex = 8;
    
    
    // XBox Controller Joystick Axis
    public static final int xBoxLeftXAxis = 1;
    public static final int xBoxLeftYAxis = 2;
    public static final int xBoxTriggerAxis = 3;  // Left trigger 0.0-0.5, right trigger 0.5-1.0
    public static final int xBoxRightXAxis = 4;    
    public static final int xBoxRightYAxis = 5;
    public static final int xBoxDPadHorizontalAxis = 6;
    
    public static final double climberArmPushSpeed = -0.50;
    public static final double climberArmPullSpeed = -1.0;
    public static final double climberPullTimeOut = 1.0;
    public static final double climberPushTimeOut = 2.0;
}
