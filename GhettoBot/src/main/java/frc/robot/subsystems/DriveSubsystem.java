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
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Timer;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class DriveSubsystem extends SubsystemBase {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
public CANSparkMax motorController4;
private CANSparkMax motorController5;
private CANSparkMax motorController6;
private CANSparkMax motorController7;
private SparkMaxPIDController m_pidrightController;
private SparkMaxPIDController m_pidleftController;
private DifferentialDrive differentialDrive1;

private double lastDashboardUpdateTime = Timer.getFPGATimestamp();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    /**
    *
    */
    public DriveSubsystem() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

motorController4 = new CANSparkMax(10,MotorType.kBrushless);
 //addChild("Motor Controller 4",motorController4);
 motorController4.setInverted(false);
 motorController4.setOpenLoopRampRate(0.5);
 motorController4.setClosedLoopRampRate(0.5);
 m_pidleftController = motorController4.getPIDController();
//wheel circumference: 18.84
//-8.5 positions per rev
 // ~2.21 inches per revolution
 motorController4.getEncoder().setPositionConversionFactor(2.216470588235294);

motorController5 = new CANSparkMax(11,MotorType.kBrushless);
 //addChild("Motor Controller 5",motorController5);
 motorController5.setInverted(false);
 motorController5.setOpenLoopRampRate(0.5);
 motorController5.setClosedLoopRampRate(0.5);
motorController5.follow(motorController4);
 //addChild("Motor Controller Group 1",leftMotorControllerGroup);
 

motorController6 = new CANSparkMax(12,MotorType.kBrushless);
 //addChild("Motor Controller 6",motorController6);
 motorController6.setInverted(true);
 motorController6.setOpenLoopRampRate(0.5);
 motorController6.setClosedLoopRampRate(0.5);
 m_pidrightController = motorController6.getPIDController();

motorController7 = new CANSparkMax(13,MotorType.kBrushless);
 //addChild("Motor Controller 7",motorController7);
 motorController7.setInverted(true);
 motorController7.setOpenLoopRampRate(0.5);
 motorController7.setClosedLoopRampRate(0.5);
 motorController7.follow(motorController6);


 //addChild("Motor Controller Group 2",rightMotorControllerGroup);
 

differentialDrive1 = new DifferentialDrive(motorController4, motorController6);
 addChild("Differential Drive 1",differentialDrive1);
 differentialDrive1.setSafetyEnabled(true);
differentialDrive1.setExpiration(0.5);
differentialDrive1.setMaxOutput(1.0);

motorController4.getEncoder().setPosition(0);



    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        
        if (Timer.getFPGATimestamp() - lastDashboardUpdateTime > 1)
        {
            SmartDashboard.putNumber("Drive Position", motorController4.getEncoder().getPosition());

            lastDashboardUpdateTime = Timer.getFPGATimestamp();
        }
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    public void arcadeDrive(double speed, double direction){
        differentialDrive1.arcadeDrive(speed, direction - 0.05, true);
        

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}

