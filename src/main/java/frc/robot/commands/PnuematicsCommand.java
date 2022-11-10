// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.PneumaticsSubsystem;

import javax.management.openmbean.CompositeDataSupport;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class PnuematicsCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final PneumaticsSubsystem m_subsystem;
  Joystick joystick;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public PnuematicsCommand(PneumaticsSubsystem subsystem) {
    m_subsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
    joystick = new Joystick(0);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
      m_subsystem.compStart();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      if (joystick.getRawButton(1)) {
        m_subsystem.sol1Open();
      } else if (joystick.getRawButton(2)) {
        m_subsystem.sol1Close();
      }
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
