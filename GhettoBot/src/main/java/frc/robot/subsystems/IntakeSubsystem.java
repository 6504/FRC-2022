// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

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

public class IntakeSubsystem extends SubsystemBase {
  private CANSparkMax liftMotorLeft;
  private CANSparkMax liftMotorRight;
  private CANSparkMax intake;
  private MotorControllerGroup liftMotorControllerGroup;


  public IntakeSubsystem() {
    liftMotorLeft = new CANSparkMax(14, MotorType.kBrushless);
    liftMotorLeft.setInverted(false);

    liftMotorRight = new CANSparkMax(15, MotorType.kBrushless);
    liftMotorRight.setInverted(false);

    liftMotorControllerGroup = new MotorControllerGroup(liftMotorLeft, liftMotorRight);

    intake = new CANSparkMax(16, MotorType.kBrushless);
    intake.setInverted(false);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  
  public void intakeIn(){
    intake.set(1);
  }
  
  public void intakeOff(){
    intake.set(0);
  }

  public void intakeOut(){
    intake.set(-1);
  }

  public void liftOff(){
    liftMotorControllerGroup.set(0);
  }

  public void liftDown(double power){
    liftMotorControllerGroup.set(-power);
  }

  public void liftUp(double power){
    liftMotorControllerGroup.set(power);
  }

}
