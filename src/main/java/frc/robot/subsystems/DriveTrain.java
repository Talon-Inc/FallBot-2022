// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.security.acl.Group;

import com.ctre.phoenix.motorcontrol.GroupMotorControllers;
import com.ctre.phoenix.motorcontrol.IMotorController;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  /** Creates a DriveTrain. */
  IMotorController LFMOTOR = null;
  IMotorController LBMOTOR = null;
  IMotorController RFMOTOR = null;
  IMotorController RBMOTOR = null;

  GroupMotorControllers leftMotors = null;
  GroupMotorControllers rightMotors = null;

  DifferentialDrive differentialDrive = null;

  public DriveTrain() {
    LFMOTOR = new TalonSRX(Constants.DRIVETRAIN_LFMOTOR);
    LBMOTOR = new TalonSRX(Constants.DRIVETRAIN_LBMOTOR);
    RFMOTOR = new TalonSRX(Constants.DRIVETRAIN_RFMOTOR);
    RBMOTOR = new TalonSRX(Constants.DRIVETRAIN_RBMOTOR);

    TalonSRXConfiguration config = new TalonSRXConfiguration();
    config.peakCurrentLimit = 40; // the peak current, in amps
    config.peakCurrentDuration = 1500; // the time at the peak current before the limit triggers, in ms
    config.continuousCurrentLimit = 30; // the current to maintain if the peak limit is triggered
    LFMOTOR.configAllSettings(config); // apply the config settings; this selects the quadrature encoder
    LBMOTOR.configAllSettings(config); // apply the config settings; this selects the quadrature encoder
    RFMOTOR.configAllSettings(config); // apply the config settings; this selects the quadrature encoder
    RBMOTOR.configAllSettings(config); // apply the config settings; this selects the quadrature encoder

    
    leftMotors = new GroupMotorControllers();
    GroupMotorControllers.register(LFMOTOR);
    
    rightMotors = new GroupMotorControllers();


    rightMotors.setInverted(true);
    
    differentialDrive = new DifferentialDrive(leftMotors, rightMotors);
  }

  public void arcadeDrive(double moveSpeed, double rotateSpeed) {
    differentialDrive.arcadeDrive(moveSpeed, rotateSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
