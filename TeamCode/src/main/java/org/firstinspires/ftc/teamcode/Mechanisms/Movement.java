package org.firstinspires.ftc.teamcode.Mechanisms;

import com.acmerobotics.dashboard.config.Config;
import com.bylazar.configurables.annotations.Configurable;
import com.pedropathing.math.Vector;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Hardware.Hardware;

@Config
@Configurable
public class Movement {

    public static double headingSensivity=0.7;
    public static double limitSpeedMultiplier=0.4;
    public static void init() {
        Hardware.follower.update();
        Hardware.start();

    }

    public static void run(Gamepad gamepad1) {

        double forward, strafe, turn;
        forward = -gamepad1.right_stick_y;
        strafe =-gamepad1.right_stick_x;
        turn = -gamepad1.left_stick_x * headingSensivity;
        if (gamepad1.dpad_right) {
            forward *= limitSpeedMultiplier;
            strafe *= limitSpeedMultiplier;
            turn *= limitSpeedMultiplier;
        }

        Hardware.follower.manual(forward, strafe, turn);
    }

}
