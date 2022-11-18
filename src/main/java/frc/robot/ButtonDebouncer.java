// Copied from https://frc-pdr.readthedocs.io/en/latest/user_input/joystick.html

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Timer;

public class ButtonDebouncer{

    // 
    GenericHID controller;
    int buttonnum;
    double latest;
    double debounce_period;

    public ButtonDebouncer(GenericHID controller, int buttonnum){
        this.controller = controller;
        this.buttonnum = buttonnum;
        this.latest = 0;
        this.debounce_period = .5;
    }
    public ButtonDebouncer(GenericHID controller, int buttonnum, float period){
        this.controller = controller;
        this.buttonnum = buttonnum;
        this.latest = 0;
        this.debounce_period = period;
    }

    public void setDebouncePeriod(float period){
        this.debounce_period = period;
    }

    public boolean get(){
        double now = Timer.getFPGATimestamp();
        if(controller.getRawButton(buttonnum)){
            if((now-latest) > debounce_period){
                latest = now;
                return true;
            }
        }
        return false;
    }
}