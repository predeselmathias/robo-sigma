package org.firstinspires.ftc.teamcode.Mechanisms;

import static org.firstinspires.ftc.teamcode.Hardware.Hardware.intake;
import static org.firstinspires.ftc.teamcode.Hardware.Hardware.transfer;

import com.acmerobotics.dashboard.config.Config;
import com.bylazar.configurables.annotations.Configurable;

@Config
@Configurable
public class Intake {
    public static final double intakePowerOn = 1.0;
    public static final double transferPowerOn = 0.7;
    public static final double intakePowerOff = 0;
    public static final double transferPowerOff = 0;
    public static final double outtakePower = -0.6;

    public enum Directions {
        INTAKE,
        OUTTAKE,
        STOPPED
    }
    public static Directions Direction;

    public static void intakeOn() {
        intake.setPower(intakePowerOn);
        transfer.setPower(transferPowerOn);
        Direction = Directions.INTAKE;
    }

    public static void intakeOff() {
        intake.setPower(intakePowerOff);
        transfer.setPower(transferPowerOff);
        Direction = Directions.STOPPED;
    }
    public static void outtake(){
        intake.setPower(outtakePower);
        transfer.setPower(outtakePower);
        Direction = Directions.OUTTAKE;
    }

    public static void init() {
        intakeOff();
    }

}
