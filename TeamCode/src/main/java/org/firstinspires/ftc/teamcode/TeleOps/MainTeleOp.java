package org.firstinspires.ftc.teamcode.TeleOps;

import com.bylazar.configurables.annotations.Configurable;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Hardware.Hardware;
import org.firstinspires.ftc.teamcode.Mechanisms.Movement;
import org.firstinspires.ftc.teamcode.Utils.Initializations;
@TeleOp
public class MainTeleOp extends OpMode {
    @Override
    public void init() {
        Initializations.initTeleOp(hardwareMap, telemetry, gamepad1, gamepad2);
    }

    @Override
    public void loop() {
        Hardware.follower.update();
        Movement.run(gamepad1);
        ActionManager.control();
    }
}
