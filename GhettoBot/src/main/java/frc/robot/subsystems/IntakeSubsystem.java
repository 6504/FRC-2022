// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;

public class IntakeSubsystem extends SubsystemBase {
  private CANSparkMax linkageMotor;
  private VictorSP intake;
  private MotorControllerGroup liftMotorControllerGroup;
  private DigitalInput intakeLowerLimit;
  private DigitalInput intakeUpperLimit;

  //pid controller stuff
  private SparkMaxPIDController m_pidController;
  public double kP, kI, kD, kIz, kFF, kMaxOutput, kMinOutput;


  public IntakeSubsystem() {
    linkageMotor = new CANSparkMax(15, MotorType.kBrushless);
    linkageMotor.setInverted(false);
    linkageMotor.setIdleMode(IdleMode.kBrake);

    intakeLowerLimit = new DigitalInput(1);
    intakeUpperLimit = new DigitalInput(2);

    // liftMotorRight = new CANSparkMax(16, MotorType.kBrushless);
    // liftMotorRight.setInverted(false);

    // liftMotorControllerGroup = new MotorControllerGroup(liftMotorLeft, liftMotorRight);
    
    intake = new VictorSP(0);
    intake.setInverted(false);


    //pid controller stuff
    m_pidController = linkageMotor.getPIDController();

    // PID coefficients
    kP = 0.1; 
    kI = 1e-4;
    kD = 1; 
    kIz = 0; 
    kFF = 0; 
    kMaxOutput = 1; 
    kMinOutput = -1;

    // set PID coefficients
    m_pidController.setP(kP);
    m_pidController.setI(kI);
    m_pidController.setD(kD);
    m_pidController.setIZone(kIz);
    m_pidController.setFF(kFF);
    m_pidController.setOutputRange(kMinOutput, kMaxOutput);

    // display PID coefficients on SmartDashboard
    SmartDashboard.putNumber("P Gain", kP);
    SmartDashboard.putNumber("I Gain", kI);
    SmartDashboard.putNumber("D Gain", kD);
    SmartDashboard.putNumber("I Zone", kIz);
    SmartDashboard.putNumber("Feed Forward", kFF);
    SmartDashboard.putNumber("Max Output", kMaxOutput);
    SmartDashboard.putNumber("Min Output", kMinOutput);
    SmartDashboard.putNumber("Set Rotations", 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    // read PID coefficients from SmartDashboard
    double p = SmartDashboard.getNumber("P Gain", 0);
    double i = SmartDashboard.getNumber("I Gain", 0);
    double d = SmartDashboard.getNumber("D Gain", 0);
    double iz = SmartDashboard.getNumber("I Zone", 0);
    double ff = SmartDashboard.getNumber("Feed Forward", 0);
    double max = SmartDashboard.getNumber("Max Output", 0);
    double min = SmartDashboard.getNumber("Min Output", 0);
    double rotations = SmartDashboard.getNumber("Set Rotations", 0);

    // if PID coefficients on SmartDashboard have changed, write new values to controller
    if((p != kP)) { m_pidController.setP(p); kP = p; }
    if((i != kI)) { m_pidController.setI(i); kI = i; }
    if((d != kD)) { m_pidController.setD(d); kD = d; }
    if((iz != kIz)) { m_pidController.setIZone(iz); kIz = iz; }
    if((ff != kFF)) { m_pidController.setFF(ff); kFF = ff; }
    if((max != kMaxOutput) || (min != kMinOutput)) { 
      m_pidController.setOutputRange(min, max); 
      kMinOutput = min; kMaxOutput = max; 
    }

    //PIDController objects are commanded to a set point using the SetReference() method.
    m_pidController.setReference(rotations, CANSparkMax.ControlType.kPosition);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  
  public void intakeIn(){
    intake.set(-.5);
  }
  
  public void intakeOff(){
    intake.set(0);
  }

  public void intakeOut(){
    intake.set(0.5);
  }

  public void liftOff(){
    linkageMotor.set(0);
  }

  public void liftDown(double power){
    linkageMotor.set(-power * power);
  }

  public void liftUp(double power){
    linkageMotor.set(power * power);
  }

  public void armDownAndIntakeOn(){
    // TODO use encoders to bring it down
    // TODO start intake
    intakeIn();
    if (!intakeLowerLimit.get()){
      linkageMotor.set(-0.5);
    } else {
      linkageMotor.set(0);
    }

  }

  public void armUpAndIntakeOff(){
    // TODO off intake
    // TODO use encoders to bring it up
    intakeOff();
    if (!intakeUpperLimit.get()){
      linkageMotor.set(0.5);
    } else {
      linkageMotor.set(0);
    }

  }


}
