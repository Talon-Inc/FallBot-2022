// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PneumaticsSubsystem extends SubsystemBase {
  // Variables
  private Compressor comp = null;
  private DoubleSolenoid sol1 = null;
  private DoubleSolenoid sol2 = null;
  private DoubleSolenoid sol3 = null;

  /** Creates a new ExampleSubsystem. */
  public PneumaticsSubsystem() {
    comp = new Compressor(moduleType);
    sol1 = new DoubleSolenoid(PneumaticsModuleType.valueOf("CTREPCM"), 0, 1);
    sol1 = new DoubleSolenoid(PneumaticsModuleType.valueOf("CTREPCM"), 2, 3);
    sol1 = new DoubleSolenoid(PneumaticsModuleType.valueOf("CTREPCM"), 4, 5);
  }

  // Methods
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}