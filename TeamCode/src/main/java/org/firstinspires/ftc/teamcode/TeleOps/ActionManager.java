package org.firstinspires.ftc.teamcode.TeleOps;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Mechanisms.Intake;
import org.firstinspires.ftc.teamcode.Utils.OneTap;

public class ActionManager {
    public static OneTap rightBumper = new OneTap();
    public static OneTap dpad_down = new OneTap();
    public static OneTap leftBumper = new OneTap();
    private static Gamepad gamepad1;
    private static Gamepad gamepad2;

    public static void assignGamepads(Gamepad _gamepad1, Gamepad _gamepad2){
        gamepad1 = _gamepad1;
        gamepad2 = _gamepad2;
    }
    public static void control(){
        intake();
        outtake();
    }
    public static void intake(){
        if(rightBumper.onPress(gamepad1.right_bumper)) {
            if (Intake.Direction == Intake.Directions.INTAKE) {
                Intake.intakeOff();
            }
            else{
                Intake.intakeOn();
            }
        }
    }
    public static void outtake(){
        if(leftBumper.onPress(gamepad1.left_bumper)) {
            if (Intake.Direction != Intake.Directions.OUTTAKE) {
                Intake.outtake();
            } else {
                Intake.intakeOff();
            }
        }
    }

}
