//package org.firstinspires.ftc.teamcode.Utils;
//
//import com.pedropathing.math.Vector;
//
//
//public class SensorData {
//    private static Pose robotPosePedro;
//
//    private static Vector2D_EX robotPosition;
//    private static double robotHeading;
//    private static double robotAngularVelocity;
//
//    private static Vector robotVelocityPedro;
//    private static Vector2D_EX robotVelocity;
//
//    private static boolean beamBreak1Input;
//    private static boolean beamBreak2Input;
//    private static boolean beamBreak3Input;
//
//    private static double shooterVelocity;
//    public static double voltage;
//
//    public static void update(){
//        voltage = Hardware.voltageSensor.getVoltage();
//
//        robotPosePedro = Hardware.follower.getPose();
//
//        if (robotPosePedro == null) {
//            robotPosition = new Vector2D_EX(0, 0);
//            robotHeading = 0;
//        }
//        else {
//            robotPosition = new Vector2D_EX(robotPosePedro.getX(), robotPosePedro.getY());
//            robotHeading = robotPosePedro.getHeading();
//        }
//
//        robotVelocityPedro = Hardware.follower.getVelocity();
//        robotVelocity = new Vector2D_EX(robotVelocityPedro.getXComponent(), robotVelocityPedro.getYComponent());
//        robotAngularVelocity = Hardware.follower.getAngularVelocity();
//
//        shooterVelocity = Hardware.shooterRight.getVelocity();
//
//        beamBreak1Input = Hardware.beamBreak1.getState();
//        beamBreak2Input = Hardware.beamBreak2.getState();
//        beamBreak3Input = Hardware.beamBreak3.getState();
//    }
//
//
//    public static double getVoltage() {
//        return voltage;
//    }
//
//    public static Pose getRobotPose() {
//        return robotPosePedro;
//    }
//
//    public static Vector2D_EX getRobotPosition() {
//        return robotPosition;
//    }
//
//    public static double getRobotHeading() {
//        return robotHeading;
//    }
//
//    public static Vector2D_EX getRobotVelocity() {
//        return robotVelocity;
//    }
//
//    public static double getRobotAngularVelocity(){
//        return robotAngularVelocity;
//    }
//
//    public static double getShooterVelocity() {
//        return shooterVelocity;
//    }
//
//    public static boolean getBeamBreak1Input() {
//        return !beamBreak1Input;
//    }
//
//    public static boolean getBeamBreak2Input() {
//        return !beamBreak2Input;
//    }
//
//    public static boolean getBeamBreak3Input() {
//        return !beamBreak3Input;
//    }
//}
