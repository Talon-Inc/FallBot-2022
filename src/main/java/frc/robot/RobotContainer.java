// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static frc.robot.Constants.*;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.CloseMouth;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.OpenMouth;
import frc.robot.commands.PnuematicsCommand;
import frc.robot.commands.TrickOrTreat;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.LimitSwitchesSubsystem;
import frc.robot.subsystems.PneumaticsSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  private XboxController controller = new XboxController(CONTROLLER_PORT);
  
  // Subsystems
  private final LimitSwitchesSubsystem lSubsystem = new LimitSwitchesSubsystem();
  private final PneumaticsSubsystem pSubsystem = new PneumaticsSubsystem();

  // Commands
  private final PnuematicsCommand pCommand = new PnuematicsCommand(pSubsystem, controller);
  private final TrickOrTreat trickOrTreat = new TrickOrTreat(pSubsystem);
  private final OpenMouth openMouth = new OpenMouth(pSubsystem);
  private final CloseMouth closeMouth = new CloseMouth(pSubsystem);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    ButtonDebouncer debounce = new ButtonDebouncer(controller, BUTTON_A);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    JoystickButton A_button = new JoystickButton(controller, BUTTON_A);
    A_button.toggleWhenPressed(openMouth);

    JoystickButton B_button = new JoystickButton(controller, BUTTON_B);
    B_button.toggleWhenPressed(closeMouth);

    JoystickButton Y_button = new JoystickButton(controller, BUTTON_Y);
    Y_button.toggleWhenPressed(trickOrTreat);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  // public Command getAutonomousCommand() {
  //   // An ExampleCommand will run in autonomous
  //   return m_autoCommand;
  // }

  public Command getPneumaticsCommand() {
    return pCommand;
  }
}
