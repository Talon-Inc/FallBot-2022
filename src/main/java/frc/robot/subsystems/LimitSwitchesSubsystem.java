// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.NOSE_BUTTON;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LimitSwitchesSubsystem extends SubsystemBase {
  private DigitalInput digInp = null;

  /** Creates a new LimitSwitchesSubsystem. */
  public LimitSwitchesSubsystem() {
    digInp = new DigitalInput(NOSE_BUTTON);
  }

  public boolean getNoseButton() {
    return  digInp.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
