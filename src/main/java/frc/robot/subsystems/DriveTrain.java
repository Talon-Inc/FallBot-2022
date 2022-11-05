// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  /** Creates a DriveTrain. */
  public static MotorController LFMOTOR = null;
  public static MotorController LBMOTOR = null;
  public static MotorController RFMOTOR = null;
  public static MotorController RBMOTOR = null;

  MotorControllerGroup leftMotors = null;
  MotorControllerGroup rightMotors = null;

  DifferentialDrive differentialDrive = null;

  public DriveTrain() {
    LFMOTOR = new Talon(Constants.DRIVETRAIN_LFMOTOR);
    LBMOTOR = new Talon(Constants.DRIVETRAIN_LBOTOR);
    RFMOTOR = new Talon(Constants.DRIVETRAIN_RFMOTOR);
    RBMOTOR = new Talon(Constants.DRIVETRAIN_RBMOTOR);
    
    leftMotors = new MotorControllerGroup(LFMOTOR, LBMOTOR);
    rightMotors = new MotorControllerGroup(RFMOTOR, RBMOTOR);
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
