package org.usfirst.frc4909.Bionics2016.commands;

import org.usfirst.frc4909.Bionics2016.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class autoCrossDefence extends CommandGroup {
    
    public autoCrossDefence() {
    	requires(Robot.drivetrain);
        
    	addSequential(new autoGoToDefence());
    	addSequential(new autoCrossDefenceAccel(false));
        addSequential(new autoMoveDistance(6));
        
        if(!Robot.drivetrain.accelFlat())
        {
        	addSequential(new autoMoveDistance(6));
        }
        
        if(!Robot.drivetrain.accelFlat())
        {
        	addSequential(new autoMoveDistance(12));
        }
    	
    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
