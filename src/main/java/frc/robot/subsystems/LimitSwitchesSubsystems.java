package frc.robot.subsystems;

import static frc.robot.Constants.NOSE_BUTTON;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;

public class LimitSwitchesSubsystems extends SubsystemBase{
    //variables
    private DigitalInput digInp = null;
    private Timer time = null;

    /**Creates a new LImitSwitchesSubsystem **/
    public LimitSwitchesSubsystems() {
        digInp = new DigitalInput(NOSE_BUTTON);

    }

}
