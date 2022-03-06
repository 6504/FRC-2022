// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.EncoderType;
import com.revrobotics.SparkMaxRelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimbSubsystem extends SubsystemBase {
  private CANSparkMax climbArmLeft;
  private CANSparkMax climbArmRight;
  private CANSparkMax reachMotor;
  private MotorControllerGroup pivotArmMotorControllerGroup;
  private DigitalInput reachLowerLimit;
  private double lastDashboardUpdateTime = Timer.getFPGATimestamp();
  
  public ClimbSubsystem() {
    /*climbArmLeft = new CANSparkMax(17, MotorType.kBrushless);
    climbArmLeft.setInverted(true);
    climbArmLeft.setIdleMode(IdleMode.kBrake);
*/
    climbArmRight = new CANSparkMax(16, MotorType.kBrushless);
    climbArmRight.setInverted(false);
    climbArmRight.setIdleMode(IdleMode.kBrake);

    pivotArmMotorControllerGroup = new MotorControllerGroup(climbArmRight);

    reachMotor = new CANSparkMax(14, MotorType.kBrushed);
    reachMotor.setInverted(true);
    reachMotor.setIdleMode(IdleMode.kBrake);

    reachLowerLimit = new DigitalInput(0);
  }

  @Override
  public void periodic() {
    if (Timer.getFPGATimestamp() - lastDashboardUpdateTime > 1)
    {
      SmartDashboard.putBoolean("Climb at lower limit", reachLowerLimit.get());
      //SmartDashboard.putNumber("Climb Position", reachMotor.getEncoder().getPosition());
      
      lastDashboardUpdateTime = Timer.getFPGATimestamp();
    }
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public void reachUp() {
    reachMotor.set(1);
  }
  public void reachDown() {
    // Go down unless lower limit is hit
    if (!reachLowerLimit.get())
    {
      reachMotor.set(-1);
    }
    else
    {
      stopReach();
    }
  }

  public void stopReach()
  {
    reachMotor.set(0);
  }

  public void armForward() {
    pivotArmMotorControllerGroup.set(0.2);
  }
  public void armBackward() {
    pivotArmMotorControllerGroup.set(-0.2);
  }

  public void stopArms() {
    pivotArmMotorControllerGroup.set(0);
  }

}
