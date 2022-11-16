// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import static frc.robot.Constants.*;

import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class DriveCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private DriveTrain driveTrain = null;
  private XboxController controller = null;

  /**
   * Creates a new DriveCommand.
   *
   * @param driveTrain The subsystem used by this command.
   * @param controller The controller.
   */
  public DriveCommand(DriveTrain driveTrain, XboxController controller) {
    this.driveTrain = driveTrain;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveTrain);
    this.controller = controller;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    /* get gamepad stick values */
    double forw = -1 * controller.getRawAxis(LEFT_STICK_Y); /* positive is forward */
    double turn = +1 * controller.getRawAxis(LEFT_STICK_X); /* positive is right */
    // boolean btn1 = joystick.getRawButton(1); /* is button is down, print joystick values */

    /* deadband gamepad 10% */
    if (Math.abs(forw) < 0.10) {
        forw = 0;
    }
    if (Math.abs(turn) < 0.10) {
        turn = 0;
    }

    /* drive robot */
    driveTrain.arcadeDrive(forw, turn);

    String work = "";
    /*
     * [2] Make sure Gamepad Forward is positive for FORWARD, and GZ is positive for
     * RIGHT
     */
    work += " GF:" + forw + " GT:" + turn;

    /* get sensor values */
    // double leftPos = driveTrain.getleftFrontMotor().GetSelectedSensorPosition(0);
    // double rghtPos = driveTrain.getRightFrontMotor().GetSelectedSensorPosition(0);
    // double leftVelUnitsPer100ms = _leftFront.getSelectedSensorVelocity(0);
    // double rghtVelUnitsPer100ms = _rghtFront.getSelectedSensorVelocity(0);

    // work += " L:" + leftVelUnitsPer100ms + " R:" + rghtVelUnitsPer100ms;

    /*
     * drive motor at least 25%, Talons will auto-detect if sensor is out of phase
     */
    // _leftFront.getFaults(_faults_L);
    // _rghtFront.getFaults(_faults_R);

    // if (_faults_L.SensorOutOfPhase) {
    //     work += " L sensor is out of phase";
    // }
    // if (_faults_R.SensorOutOfPhase) {
    //     work += " R sensor is out of phase";
    // }

    // /* print to console if btn1 is held down */
    // if (btn1) {
    //     System.out.println(work);
    System.out.println(work);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
