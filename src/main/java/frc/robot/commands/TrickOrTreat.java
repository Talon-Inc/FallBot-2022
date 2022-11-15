// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.Random;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.PneumaticsSubsystem;

public class TrickOrTreat extends CommandBase {
  private PneumaticsSubsystem pneumaticsSubsystem = null;
  private boolean finished;
  /** Creates a new TrickOrTreat. */
  public TrickOrTreat(PneumaticsSubsystem pneumaticsSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.pneumaticsSubsystem = pneumaticsSubsystem;
    addRequirements(pneumaticsSubsystem);

    finished = false;
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // set the long seed value using Random constructor
    Random random = new Random();

    // flag == true
    if (random.nextBoolean()) {
      // true block, drop egg

      pneumaticsSubsystem.pusherOpen();
      // wait for some time
      pneumaticsSubsystem.pusherClose();
    } else {
      // puff air
      pneumaticsSubsystem.pufferOpen();
      // wait 50 milliseconds
      // wait(50, 0);
      pneumaticsSubsystem.pufferClose();
    }

    finished = true;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finished;
  }
}
