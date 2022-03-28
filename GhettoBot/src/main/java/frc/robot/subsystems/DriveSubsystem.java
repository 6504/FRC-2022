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
public CANSparkMax leftMotorControllerLeader;
private CANSparkMax leftFollowerMotorController;
private CANSparkMax rightMotorControllerLeader;
private CANSparkMax rightFollowerMotorController;
private SparkMaxPIDController m_pidrightController;
private SparkMaxPIDController m_pidleftController;
private DifferentialDrive differentialDrive1;
public double kP, kI, kD, kIz, kFF, kMaxOutput, kMinOutput;
private double lastDashboardUpdateTime = Timer.getFPGATimestamp();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    /**
    *
    */
    public DriveSubsystem() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        kP = 0.1; 
        kI = 1e-4;
        kD = 1; 
        kIz = 0; 
        kFF = 0; 
        kMaxOutput = .4; 
        kMinOutput = -.4;
leftMotorControllerLeader = new CANSparkMax(10,MotorType.kBrushless);
 //addChild("Motor Controller 4",motorController4);
 leftMotorControllerLeader.setInverted(false);
 leftMotorControllerLeader.setOpenLoopRampRate(0.5);
 leftMotorControllerLeader.setClosedLoopRampRate(0.5);
 m_pidleftController = leftMotorControllerLeader.getPIDController();
//wheel circumference: 18.84
//-8.5 positions per rev
 // ~2.21 inches per revolution
 leftMotorControllerLeader.getEncoder().setPositionConversionFactor(1.45);

leftFollowerMotorController = new CANSparkMax(11,MotorType.kBrushless);
 //addChild("Motor Controller 5",motorController5);
 leftFollowerMotorController.setInverted(false);
 leftFollowerMotorController.setOpenLoopRampRate(0.5);
 leftFollowerMotorController.setClosedLoopRampRate(0.5);
leftFollowerMotorController.follow(leftMotorControllerLeader);
 //addChild("Motor Controller Group 1",leftMotorControllerGroup);
 m_pidleftController.setP(kP);
 m_pidleftController.setI(kI);   
 m_pidleftController.setD(kD);
 m_pidleftController.setIZone(kIz);
 m_pidleftController.setFF(kFF);
 m_pidleftController.setOutputRange(kMinOutput, kMaxOutput);

rightMotorControllerLeader = new CANSparkMax(12,MotorType.kBrushless);
 //addChild("Motor Controller 6",motorController6);
 rightMotorControllerLeader.setInverted(true);
 rightMotorControllerLeader.setOpenLoopRampRate(0.5);
 rightMotorControllerLeader.setClosedLoopRampRate(0.5);
 m_pidrightController = rightMotorControllerLeader.getPIDController();

rightFollowerMotorController = new CANSparkMax(13,MotorType.kBrushless);
 //addChild("Motor Controller 7",motorController7);
 rightFollowerMotorController.setInverted(true);
 rightFollowerMotorController.setOpenLoopRampRate(0.5);
 rightFollowerMotorController.setClosedLoopRampRate(0.5);
 rightFollowerMotorController.follow(rightMotorControllerLeader);
 m_pidrightController.setP(kP);
 m_pidrightController.setI(kI);   
 m_pidrightController.setD(kD);
 m_pidrightController.setIZone(kIz);
 m_pidrightController.setFF(kFF);
 m_pidrightController.setOutputRange(kMinOutput, kMaxOutput);

 //addChild("Motor Controller Group 2",rightMotorControllerGroup);
 

differentialDrive1 = new DifferentialDrive(leftMotorControllerLeader, rightMotorControllerLeader);
 addChild("Differential Drive 1",differentialDrive1);
 differentialDrive1.setSafetyEnabled(true);
differentialDrive1.setExpiration(0.5);
differentialDrive1.setMaxOutput(1.0);

leftMotorControllerLeader.getEncoder().setPosition(0);



    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        
        if (Timer.getFPGATimestamp() - lastDashboardUpdateTime > 1)
        {
            SmartDashboard.putNumber("Drive Position", leftMotorControllerLeader.getEncoder().getPosition());
            SmartDashboard.putNumber("Fault", rightMotorControllerLeader.getFaults());
            SmartDashboard.putNumber("Sticky Fault", rightMotorControllerLeader.getStickyFaults());

            lastDashboardUpdateTime = Timer.getFPGATimestamp();
        }
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

