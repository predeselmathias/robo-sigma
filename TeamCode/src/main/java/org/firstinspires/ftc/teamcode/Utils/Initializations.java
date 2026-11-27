package org.firstinspires.ftc.teamcode.Utils;

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Hardware.Hardware;
import org.firstinspires.ftc.teamcode.Mechanisms.Intake;
import org.firstinspires.ftc.teamcode.Mechanisms.Movement;
import org.firstinspires.ftc.teamcode.Mechanisms.Stopper;
import org.firstinspires.ftc.teamcode.TeleOps.ActionManager;

import java.util.List;

public class Initializations {

//    public static void assignColor(AllianceColor.Colors allianceColor){
//        AllianceColor.colors = allianceColor;
//        AllianceColor.AssignAlliance();
//    }
//
//    public static void initAllianceGoals(){
//        AllianceColor.AssignAlliance();
//    }

//    public static void initAuto(HardwareMap hardwareMap, Telemetry telemetry, Pose startingPose){
//
//        setCachingMode(hardwareMap, LynxModule.BulkCachingMode.AUTO);
//
//        Hardware.init(hardwareMap, telemetry);
//        Hardware.configure();
//        Hardware.follower.setStartingPose(startingPose);
//        TelemetryManager.telemetryInit();
//        Stopper.init();
//        Shooter.init();
//        PIDFControllers.init();
//
//        ActionManager.init();
//        Turret.init(true);
//        FieldMap.init();
//        ShooterTrajectoryComputer.init();
//
//        initAllianceGoals();
//        FieldMap.resetGoalOffsets();
//    }
//
   public static void initTeleOp(HardwareMap hardwareMap, Telemetry telemetry, Gamepad gamepad1, Gamepad gamepad2){

//    setCachingMode(hardwareMap, LynxModule.BulkCachingMode.AUTO);
        Hardware.init(hardwareMap,telemetry);
        Hardware.config();
       Movement.init();
       Intake.init();
       Stopper.init();
       ActionManager.assignGamepads(gamepad1,gamepad2);

   }

    public static void setCachingMode(HardwareMap hardwareMap, LynxModule.BulkCachingMode mode){
        List<LynxModule> allHubs = hardwareMap.getAll(LynxModule.class);
        for (LynxModule hub : allHubs){
            hub.setBulkCachingMode(mode);
        }
    }
}
