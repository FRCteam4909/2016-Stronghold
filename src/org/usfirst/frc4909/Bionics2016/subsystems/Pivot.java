// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4909.Bionics2016.subsystems;

import org.usfirst.frc4909.Bionics2016.RobotMap;
import org.usfirst.frc4909.Bionics2016.commands.*;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class Pivot extends PIDSubsystem {

    public Pivot(String name, double p, double i, double d) {
		super(name, p, i, d);
		this.setAbsoluteTolerance(10);
		getPIDController().setContinuous(false);
		LiveWindow.addActuator("Pivot", "PIDSubsystem Controller", getPIDController());
		
		//System.out.println(getPIDController());
		// TODO Auto-generated constructor stub
	}
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final SpeedController pivotControl = RobotMap.pivotpivotControl;
    //private final SpeedController pivotControlRight = RobotMap.pivotpivotControlRight;
    private final Encoder pivotEncoder = RobotMap.pivotpivotEncoder;
    //private final AnalogPotentiometer pot = RobotMap.pivotPot;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    private final DigitalInput pivotTopSwitch = RobotMap.pivotTopSwitch;
    private final DigitalInput pivotBottomSwitch = RobotMap.pivotBottomSwitch;


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() 
    {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    	setDefaultCommand(new ControlPivot());

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    
    public void setAngle(double angle)
    {
    	setSetpoint(90-angle);
    }
    
    public void pivotDown()
    {
    	pivotControl.set(-0.6);
    	//pivotControlRight.set(-0.25);
    }
    
    public void pivotUp()
    {
    	pivotControl.set(0.6);
    	//pivotControlRight.set(0.25);
    }
    
    public boolean getTopSwitch()
    {
    	return !pivotTopSwitch.get();
    }
    
    public boolean getBottomSwitch()
    {
    	return pivotBottomSwitch.get();
    }
    
    public void movePivot(double speed)
    {	
    	
    	//speed=-speed;
    	boolean disableLimitSwitches = SmartDashboard.getBoolean("DisableLimitSwitches", false);
    	if(! disableLimitSwitches)
    	{
	    	if(speed < 0 && getBottomSwitch()){
	//    		disable();
	    		speed=0;
	    	}
	    	
	    	if(speed > 0 && getTopSwitch()){
	    		disable();
	    		speed=0;
	    		pivotEncoder.reset();
	    	}
    	}
    	
    	//disable();
    	pivotControl.set(speed);
    	/*

    	*/
    	
    	/*if(speed==0){
    		enable();
    		setSetpoint(pivotEncoder.get());
    	}
    	*/

    	}
    	//pivotControlRight.set(speed);
    //}
    
    public void setPIDEnable(boolean isEnabled) {
    	if (isEnabled) {
    		enable();
    	} else {
    		disable();
    	}
    }
    
	@Override
	public double returnPIDInput() {
		// TODO Auto-generated method stub
		return pivotEncoder.getDistance();
	}
	
	@Override
	public void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		if((output < 0 && getBottomSwitch()) || this.onTarget() || (output > 0 && getTopSwitch()))
		{
			output = 0;
    	}
		
		pivotControl.pidWrite(output);
		//pivotControlRight.pidWrite(output);
	}
}

