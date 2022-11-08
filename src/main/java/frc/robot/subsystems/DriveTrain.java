// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.GroupMotorControllers;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
// import com.ctre.phoenix.motorcontrol.can.TalonSRX;
// import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  /** Creates a DriveTrain. */
  WPI_TalonSRX leftFrontMotor = null;
  WPI_TalonSRX leftBackMotor = null;
  WPI_TalonSRX rightFrontMotor = null;
  WPI_TalonSRX rightBackMotor = null;

  GroupMotorControllers leftMotors = null;
  GroupMotorControllers rightMotors = null;

  DifferentialDrive differentialDrive = null;

  public DriveTrain() {
    leftFrontMotor = new WPI_TalonSRX(Constants.DRIVETRAIN_LFMOTOR);
    leftBackMotor = new WPI_TalonSRX(Constants.DRIVETRAIN_LBMOTOR);
    rightFrontMotor = new WPI_TalonSRX(Constants.DRIVETRAIN_RFMOTOR);
    rightBackMotor = new WPI_TalonSRX(Constants.DRIVETRAIN_RBMOTOR);

    // TalonSRXConfiguration config = new TalonSRXConfiguration();
    // config.peakCurrentLimit = 40; // the peak current, in amps
    // config.peakCurrentDuration = 1500; // the time at the peak current before the limit triggers, in ms
    // config.continuousCurrentLimit = 30; // the current to maintain if the peak limit is triggered
    // LFMOTOR.configAllSettings(config); // apply the config settings; this selects the quadrature encoder
    // LBMOTOR.configAllSettings(config); // apply the config settings; this selects the quadrature encoder
    // RFMOTOR.configAllSettings(config); // apply the config settings; this selects the quadrature encoder
    // RBMOTOR.configAllSettings(config); // apply the config settings; this selects the quadrature encoder
    double power = 0.5;
    leftFrontMotor.set(TalonSRXControlMode.PercentOutput, power); // runs the motor at 50% power
    leftBackMotor.set(TalonSRXControlMode.PercentOutput, power); // runs the motor at 50% power
    rightFrontMotor.set(TalonSRXControlMode.PercentOutput, power); // runs the motor at 50% power
    rightBackMotor.set(TalonSRXControlMode.PercentOutput, power); // runs the motor at 50% power

    /* factory default values */
    leftFrontMotor.configFactoryDefault();
    leftBackMotor.configFactoryDefault();
    rightFrontMotor.configFactoryDefault();
    rightBackMotor.configFactoryDefault();

    /* set up followers */
    leftBackMotor.follow(leftFrontMotor);
    rightBackMotor.follow(rightFrontMotor);

    /* [3] flip values so robot moves forward when stick-forward/LEDs-green */
    boolean leftInverted = false; // !< Update this
    leftFrontMotor.setInverted(leftInverted);
    rightFrontMotor.setInverted(!leftInverted);

    /* set the invert of the followers to match their respective master controllers */
    leftBackMotor.setInverted(InvertType.FollowMaster);
    rightBackMotor.setInverted(InvertType.FollowMaster);
    
    /*
     * [4] adjust sensor phase so sensor moves positive when Talon LEDs are green
     */
    leftFrontMotor.setSensorPhase(true);
    rightFrontMotor.setSensorPhase(true);

    // leftMotors = new GroupMotorControllers();
    // GroupMotorControllers.register(leftFrontMotor);
    // rightMotors = new GroupMotorControllers();
    // rightMotors.setInverted(true);
    
    differentialDrive = new DifferentialDrive(leftFrontMotor, rightFrontMotor);
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
