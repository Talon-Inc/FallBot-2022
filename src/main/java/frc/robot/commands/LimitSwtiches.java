package frc.robot.commands;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;



public class LimitSwtiches extends CommandBase {
    
    DigitalInput limitSwitch;

    public void robotInit() {
        limitSwitch = new DigitalInput(1);
    }

    public void operatorControl() {

        while (limitSwitch.get()) {
            Timer.delay(10);
        }
    }
}

