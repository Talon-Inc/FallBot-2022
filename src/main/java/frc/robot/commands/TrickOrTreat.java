// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.Random;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.PneumaticsSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class TrickOrTreat extends InstantCommand {
  private PneumaticsSubsystem pSubsystem = null;
  private Timer timer = null;

  public TrickOrTreat(PneumaticsSubsystem pSubsystem) {
    this.pSubsystem = pSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(pSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    Random random = new Random();

    //flag == true
    if (random.nextBoolean()) {
      //true block, drop egg

      pSubsystem.pusherOpen();
      WaitCommand wait = new WaitCommand(1); // in seconds
      wait.initialize();
      pSubsystem.pusherClose();
    } else {
      //puff air
      pSubsystem.pufferOpen();
      //wait 50 milliseconds
      //wait(50,0)
      // timer.wait(50);
      WaitCommand wait = new WaitCommand(.05); // in seconds
      wait.initialize();
      pSubsystem.pufferClose();
    }
  }
}
