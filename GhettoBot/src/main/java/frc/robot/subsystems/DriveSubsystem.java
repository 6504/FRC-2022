// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: Subsystem.

package frc.robot.subsystems;


import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class DriveSubsystem extends SubsystemBase {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
private CANSparkMax motorController4;
private CANSparkMax motorController5;
private MotorControllerGroup leftMotorControllerGroup;
private CANSparkMax motorController6;
private CANSparkMax motorController7;
private MotorControllerGroup rightMotorControllerGroup;
private DifferentialDrive differentialDrive1;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    /**
    *
    */
    public DriveSubsystem() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
motorController4 = new CANSparkMax(10,MotorType.kBrushless);
 //addChild("Motor Controller 4",motorController4);
 motorController4.setInverted(true);

motorController5 = new CANSparkMax(11,MotorType.kBrushless);
 //addChild("Motor Controller 5",motorController5);
 motorController5.setInverted(true);

leftMotorControllerGroup = new MotorControllerGroup(motorController4, motorController5  );
 //addChild("Motor Controller Group 1",leftMotorControllerGroup);
 

motorController6 = new CANSparkMax(12,MotorType.kBrushless);
 //addChild("Motor Controller 6",motorController6);
 motorController6.setInverted(false);

motorController7 = new CANSparkMax(13,MotorType.kBrushless);
 //addChild("Motor Controller 7",motorController7);
 motorController7.setInverted(false);

rightMotorControllerGroup = new MotorControllerGroup(motorController6, motorController7  );
 //addChild("Motor Controller Group 2",rightMotorControllerGroup);
 

differentialDrive1 = new DifferentialDrive(leftMotorControllerGroup, rightMotorControllerGroup);
 addChild("Differential Drive 1",differentialDrive1);
 differentialDrive1.setSafetyEnabled(true);
differentialDrive1.setExpiration(0.1);
differentialDrive1.setMaxOutput(1.0);



    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run


    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    public void arcadeDrive(double speed, double direction){
        differentialDrive1.arcadeDrive(speed, direction, true);
        

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}

