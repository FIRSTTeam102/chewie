package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.subsystems.Climber;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.templates.subsystems.OldDriveTrain;
import edu.wpi.first.wpilibj.templates.subsystems.OldMagazine;
import edu.wpi.first.wpilibj.templates.subsystems.Pnuematics;
import edu.wpi.first.wpilibj.templates.subsystems.Shooter;


/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    // Create a single static instance of all of your subsystems
   public static Pnuematics pnuematics;
   public static DriveTrain driveTrain;
   public static Shooter shooter;
   public static Climber climber;
  

    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();

        pnuematics = new Pnuematics();
        driveTrain = new DriveTrain();
        shooter = new Shooter();
        climber = new Climber();
        
        // Show what command your subsystem is running on the SmartDashboard
        
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
