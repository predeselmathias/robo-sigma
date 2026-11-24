package org.firstinspires.ftc.teamcode.Utils;

public class TimeFilter {
    private boolean stableState;
    private double timeSinceChange;

    public boolean update(boolean rawSignal, double ignoreTime, double dt) {
        if (rawSignal != stableState) {
            timeSinceChange += dt;
            if (timeSinceChange >= ignoreTime) {
                stableState = rawSignal;
                timeSinceChange = 0;
            }
        } else {
            timeSinceChange = 0;
        }
        return stableState;
    }

    public void forceState(boolean rawSignal) {
        stableState = rawSignal;
        timeSinceChange = 0;
    }
}