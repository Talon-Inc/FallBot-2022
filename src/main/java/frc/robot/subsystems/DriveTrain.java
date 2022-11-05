// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.security.acl.Group;

import com.ctre.phoenix.motorcontrol.GroupMotorControllers;
import com.ctre.phoenix.motorcontrol.IMotorController;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  /** Creates a DriveTrain. */
  WPI_TalonSRX LFMOTOR = null;
  WPI_TalonSRX LBMOTOR = null;
  WPI_TalonSRX RFMOTOR = null;
  WPI_TalonSRX RBMOTOR = null;

  GroupMotorControllers leftMotors = null;
  GroupMotorControllers rightMotors = null;

  DifferentialDrive differentialDrive = null;

  public DriveTrain() {
    LFMOTOR = new WPI_TalonSRX(Constants.DRIVETRAIN_LFMOTOR);
    LBMOTOR = new WPI_TalonSRX(Constants.DRIVETRAIN_LBMOTOR);
    RFMOTOR = new WPI_TalonSRX(Constants.DRIVETRAIN_RFMOTOR);
    RBMOTOR = new WPI_TalonSRX(Constants.DRIVETRAIN_RBMOTOR);

    TalonSRXConfiguration config = new TalonSRXConfiguration();
    config.peakCurrentLimit = 40; // the peak current, in amps
    config.peakCurrentDuration = 1500; // the time at the peak current before the limit triggers, in ms
    config.continuousCurrentLimit = 30; // the current to maintain if the peak limit is triggered
    LFMOTOR.configAllSettings(config); // apply the config settings; this selects the quadrature encoder
    LBMOTOR.configAllSettings(config); // apply the config settings; this selects the quadrature encoder
    RFMOTOR.configAllSettings(config); // apply the config settings; this selects the quadrature encoder
    RBMOTOR.configAllSettings(config); // apply the config settings; this selects the quadrature encoder

    LFMOTOR.set(TalonSRXControlMode.PercentOutput, 0.5); // runs the motor at 50% power
    LBMOTOR.set(TalonSRXControlMode.PercentOutput, 0.5); // runs the motor at 50% power
    RFMOTOR.set(TalonSRXControlMode.PercentOutput, 0.5); // runs the motor at 50% power
    RBMOTOR.set(TalonSRXControlMode.PercentOutput, 0.5); // runs the motor at 50% power

    /* factory default values */
    LFMOTOR.configFactoryDefault();
    LBMOTOR.configFactoryDefault();
    RFMOTOR.configFactoryDefault();
    RBMOTOR.configFactoryDefault();

    /* set up followers */
    LBMOTOR.follow(LFMOTOR);
    RBMOTOR.follow(RFMOTOR);

    /* [3] flip values so robot moves forward when stick-forward/LEDs-green */
    LFMOTOR.setInverted(false); // !< Update this
    RFMOTOR.setInverted(true); // !< Update this

    /*
     * set the invert of the followers to match their respective master controllers
     */
    LBMOTOR.setInverted(InvertType.FollowMaster);
    RBMOTOR.setInverted(InvertType.FollowMaster);
    
    /*
     * [4] adjust sensor phase so sensor moves positive when Talon LEDs are green
     */
    LFMOTOR.setSensorPhase(true);
    RFMOTOR.setSensorPhase(true);

    // leftMotors = new GroupMotorControllers();
    // GroupMotorControllers.register(LFMOTOR);
    // rightMotors = new GroupMotorControllers();
    // rightMotors.setInverted(true);
    
    differentialDrive = new DifferentialDrive(LFMOTOR, RFMOTOR);
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
