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
  private DoubleSolenoid mouth = null;
  private DoubleSolenoid pusher = null;
  private DoubleSolenoid puffer = null;

  /** Creates a new PneumaticsSubsystem. */
  public PneumaticsSubsystem() {
    comp = new Compressor(PneumaticsModuleType.valueOf("CTREPCM"));
    comp.enableDigital();
    mouth = new DoubleSolenoid(PneumaticsModuleType.valueOf("CTREPCM"), 0, 1);
    pusher = new DoubleSolenoid(PneumaticsModuleType.valueOf("CTREPCM"), 2, 3);
    puffer = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 4, 5);
  }

  public void mouthOpen() {
    mouth.set(DoubleSolenoid.Value.kForward);
  }

  public void mouthClose() {
    mouth.set(DoubleSolenoid.Value.kReverse);
  }

  public void pusherOpen() {
    pusher.set(DoubleSolenoid.Value.kForward);
  }
  
  public void pusherClose() {
    pusher.set(DoubleSolenoid.Value.kReverse);
  }

  public void pufferOpen() {
    puffer.set(DoubleSolenoid.Value.kForward);
  }

  public void pufferClose() {
    puffer.set(DoubleSolenoid.Value.kReverse);
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
