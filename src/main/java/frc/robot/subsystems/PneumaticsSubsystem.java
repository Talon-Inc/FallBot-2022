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
  private DoubleSolenoid pusher = null;
  private DoubleSolenoid puffer = null;

  /** Creates a new PneumaticsSubsystem. */
  public PneumaticsSubsystem() {
    comp = new Compressor(PneumaticsModuleType.valueOf("CTREPCM"));
    comp.enableDigital();
    sol1 = new DoubleSolenoid(PneumaticsModuleType.valueOf("CTREPCM"), 0, 1);
    sol2 = new DoubleSolenoid(PneumaticsModuleType.valueOf("CTREPCM"), 2, 3);
    pusher = new DoubleSolenoid(PneumaticsModuleType.valueOf("CTREPCM"), 4, 5);
    puffer = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 6, 7);
  }

  public void sol1Open() {
    sol1.set(DoubleSolenoid.Value.kForward);
  }

  public void sol1Close() {
    sol1.set(DoubleSolenoid.Value.kReverse);
  }

  public void sol2Open() {
    sol2.set(DoubleSolenoid.Value.kForward);
  }

  public void sol2Close() {
    sol2.set(DoubleSolenoid.Value.kReverse);
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
