// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4909.Bionics2016;

import org.usfirst.frc4909.Bionics2016.commands.*;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;

import org.usfirst.frc4909.Bionics2016.subsystems.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	//Drivetrain
    public Joystick controlDrive;
    public Joystick operatorControl;
    public Joystick rightDrive;
    public Button testerButton;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    //Pivot
    public Button pivotUpButton;
    public Button pivotDownButton;
    
    //Shooter/Feeder
    public Button shootButton;
    public Button lowShotButton;
    public Button highShotButton;
    public Button intakeButton;
    public Button controlPivotButton;

    
    
    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    	//Joysticks/Gamepads
        rightDrive = new Joystick(2);
        operatorControl = new Joystick(1);
        controlDrive = new Joystick(0);
        
        // SmartDashboard Buttons
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        
        /*
        Gamepad Controls:
        Button 1-X
        Button 2-A
        Button 3-B
        Button 4-Y
        Button 5-Back Left Button
        Button 6-Back Right Button
        Button 7-Left Trigger
        Button 8-Right Trigger
        */
        
        //Pivot
        
       /* pivotUpButton = new JoystickButton(operatorControl, 6); //Right Bumper
        pivotUpButton.whenPressed(new PivotUp());

        pivotDownButton = new JoystickButton(operatorControl, 5); //Left Bumper
        pivotDownButton.whenPressed(new PivotDown());
        */
        
        controlPivotButton = new JoystickButton(operatorControl, 11);
        controlPivotButton.whenPressed(new ControlPivot());
        
        //Shooter/Feeder
        shootButton = new JoystickButton(operatorControl, 8); //Right Trigger
        shootButton.whenPressed(new Shoot());
        
        lowShotButton = new JoystickButton(operatorControl, 2); //A Button
        lowShotButton.whenPressed(new StartShooter(2000));
        
        highShotButton = new JoystickButton(operatorControl, 4); //Y Button
        highShotButton.whenPressed(new StartShooter(4000));
        
        intakeButton = new JoystickButton(operatorControl, 7); //Left Trigger        
        intakeButton.whenPressed(new Intake());
        
        /*testerButton = new JoystickButton(operatorControl, 1);
        testerButton.whenPressed(new autoTowerFromDefence());
       */
        
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getcontrolDrive() {
        return controlDrive;
    }

    public Joystick getoperatorControl() {
        return operatorControl;
    }

    public Joystick getrightDrive() {
        return rightDrive;
    }
    public double getLeft(){
    	if( Math.abs(controlDrive.getY())<.1)
    			return 0;
    	return controlDrive.getY();
    	
    }
    public double getRight(){
    	if( Math.abs(rightDrive.getY())<.1)
			return 0;
	return rightDrive.getY();
    }
    
    public double getLeftOperator(){
    	if( Math.abs(rightDrive.getY())<.1)
			return 0;
    	//if(operatorControl.getY()>0){
    		//return operatorControl.getY()/2;
    	//}
    	return operatorControl.getY();
    	
    }
}

