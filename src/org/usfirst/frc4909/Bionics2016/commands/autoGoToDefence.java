package org.usfirst.frc4909.Bionics2016.commands;

import org.usfirst.frc4909.Bionics2016.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class autoGoToDefence extends Command {
	
	private double Kp=0.03;
	
    public autoGoToDefence() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
       	Robot.drivetrain.resetGyro();
       	
        while (Robot.drivetrain.accelFlat()) {
            double angle = Robot.drivetrain.getGyroAngle(); // get current heading
            Robot.drivetrain.autoDrive(0.5, angle*Kp); // drive towards heading 0
            Timer.delay(0.004);
        }
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}