package org.firstinspires.ftc.teamcode.Mechanisms;

import com.acmerobotics.dashboard.config.Config;
import com.bylazar.configurables.annotations.Configurable;

import org.firstinspires.ftc.teamcode.Hardware.Hardware;
@Config
@Configurable
public class Stopper {
    public static double stopperOn = 0.5;
    public static double stopperOff = 1.0;

    public enum Directions {
        OPEN,
        CLOSED
    }

    public static Directions stopperPosition;

    public static void stopperOpen(){
        Hardware.stopper.setPosition(stopperOn);
        stopperPosition = Directions.OPEN;
    }

    public static void stopperClosed(){
        Hardware.stopper.setPosition(stopperOff);
        stopperPosition = Directions.CLOSED;
    }
    public static void init() {
       stopperClosed();
    }
}
