package org.firstinspires.ftc.teamcode.TeleOps;

import com.bylazar.configurables.annotations.Configurable;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.Hardware.Hardware;
import org.firstinspires.ftc.teamcode.Mechanisms.Movement;
import org.firstinspires.ftc.teamcode.Utils.Initializations;

public class MainTeleOp extends OpMode {
    @Override
    public void init() {
        Initializations.initTeleOp(gamepad1,gamepad2);
    }

    @Override
    public void loop() {
        Hardware.follower.update();
        Movement.run(gamepad1);

    }
}
