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

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimbSubsystem extends SubsystemBase {
  private CANSparkMax climbArmLeft;
  private CANSparkMax climbArmRight;
  private CANSparkMax reachMotor;
  private MotorControllerGroup pivotArmMotorControllerGroup;
  
  public ClimbSubsystem() {
    climbArmLeft = new CANSparkMax(17, MotorType.kBrushless);
    climbArmLeft.setInverted(true);

    climbArmRight = new CANSparkMax(16, MotorType.kBrushless);
    climbArmRight.setInverted(false);

    pivotArmMotorControllerGroup = new MotorControllerGroup(climbArmLeft, climbArmRight);

    // We don't have an ID 19
    //reachMotor = new CANSparkMax(19, MotorType.kBrushless);
    //reachMotor.setInverted(false);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public void reachUp() {
    //reachMotor.set(0.2);
  }
  public void reachDown() {
    //reachMotor.set(-0.2);
  }
  public void armForward() {
    pivotArmMotorControllerGroup.set(0.2);
  }
  public void armBackward() {
    pivotArmMotorControllerGroup.set(-0.2);
  }

  public void resetArms() {
    pivotArmMotorControllerGroup.set(0);
  }

}
