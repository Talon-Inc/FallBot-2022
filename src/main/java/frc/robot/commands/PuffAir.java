// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.PneumaticsSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class PuffAir extends InstantCommand {
  private PneumaticsSubsystem pSubsystem = null;

  public PuffAir(PneumaticsSubsystem pSubsystem) {
    this.pSubsystem = pSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(pSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    pSubsystem.pufferOpen();
    //wait 
    // WaitCommand wait = null;
    new WaitCommand(.05); // probably wrong
    pSubsystem.pufferClose();
  }
}