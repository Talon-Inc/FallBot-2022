// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import static frc.robot.Constants.CONTROLLER_PORT;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.PneumaticsSubsystem;

/** An example command that uses an example subsystem. */
public class PnuematicsCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final PneumaticsSubsystem pneumaticsSubsystem;
  private XboxController controller = null;
  /**
   * Creates a new PneumaticsCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public PnuematicsCommand(PneumaticsSubsystem subsystem) {
    pneumaticsSubsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
    controller = new XboxController(CONTROLLER_PORT);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    pneumaticsSubsystem.pusherClose();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      if (controller.getRawButton(1)) {
        pneumaticsSubsystem.mouthOpen();
      } else if (controller.getRawButton(2)) {
        pneumaticsSubsystem.mouthClose();
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
