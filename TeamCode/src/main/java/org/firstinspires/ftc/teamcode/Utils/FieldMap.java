//package org.firstinspires.ftc.teamcode.Utils;
//
//import com.acmerobotics.dashboard.config.Config;
//
//import org.firstinspires.ftc.teamcode.TeamCode.TrajectoryMath.ShooterTrajectoryComputer;
//@Config
//public class FieldMap {
//
//    // ---------------- CONSTANTS -------------- //
//
//    public static double inheritedMovementMultiplier;
//
//    public static final Vector2D_EX blueGoal = new Vector2D_EX(4 ,134.7);
//    public static final Vector2D_EX redGoal = new Vector2D_EX(139.2, 134.7);
//
//    public static final Vector2D_EX turretOffsets = new Vector2D_EX(0 ,-1.614);
//    public static Vector2D_EX goalOffsets = new Vector2D_EX();
//
//    public static void init(){
//        inheritedMovementMultiplier = 0.55;
//    }
//
//    public static Vector2D_EX allianceGoal;
//
//    // ---------------- GETTER VARIABLES ---------------- //
//
//    private static Vector2D_EX goal;
//    private static double angleToGoal;
//    private static double distanceToGoal;
//
//    private static Vector2D_EX virtualGoal;
//    private static double angleToVirtualGoal;
//    private static double distanceToVirtualGoal;
//
//
//    // ------------------ UPDATE -------------- //
//    public static void update(){
//        goal = goal();
//        angleToGoal = angleToGoal();
//        distanceToGoal = distanceToGoal();
//
//        virtualGoal = VirtualGoal();
//        angleToVirtualGoal = angleToVirtualGoal();
//        distanceToVirtualGoal = distanceToVirtualGoal();
//
//    }
//
//    // ----------------- GETTERS --------------- //
//    public static Vector2D_EX getGoal(){ return goal; }
//    public static double getAngleToGoal(){ return angleToGoal; }
//    public static double getDistanceToGoal(){ return distanceToGoal; }
//
//
//    public static Vector2D_EX getVirtualGoal(){ return virtualGoal; }
//    public static double getAngleToVirtualGoal(){ return angleToVirtualGoal; }
//    public static double getDistanceToVirtualGoal(){ return distanceToVirtualGoal; }
//
//
//
//    // ----------------- INTERNAL CALCULATIONS ----------------- //
//
//
//    // -- GOAL -- //
//
//    private static Vector2D_EX goal(){
//        return allianceGoal;
//    }
//
//    private static double angleToGoal() {
//        return SensorData.getRobotPosition().angleTo(allianceGoal);
//    }
//    private static double distanceToGoal()
//    {
//        Vector2D_EX robotPosition = SensorData.getRobotPosition();
//        return allianceGoal.minus(robotPosition).length();
//    }
//
//    // ----------------- VIRTUAL GOAL ----------------- //
//    private static Vector2D_EX VirtualGoal(){
//        Vector2D_EX inheritedMovement = VectorTravelledIn(ShooterTrajectoryComputer.estimatedTravelTime());
//        inheritedMovement = inheritedMovement.scalarMultiply(inheritedMovementMultiplier);
//        return allianceGoal.minus(inheritedMovement);
//    }
//
//    private static Vector2D_EX getAbsoluteTurretPosition() {
//        Vector2D_EX robotPos = SensorData.getRobotPosition();
//        double robotHeading = SensorData.getRobotHeading();
//
//        double rotatedX = turretOffsets.getX() * Math.cos(robotHeading) - turretOffsets.getY() * Math.sin(robotHeading);
//        double rotatedY = turretOffsets.getX() * Math.sin(robotHeading) + turretOffsets.getY() * Math.cos(robotHeading);
//
//        return new Vector2D_EX(robotPos.getX() + rotatedX, robotPos.getY() + rotatedY);
//    }
//
//    private static double angleToVirtualGoal() {
//        Vector2D_EX turretPosition = getAbsoluteTurretPosition();
//        return turretPosition.angleTo(getVirtualGoal());
//    }
//
//    private static double distanceToVirtualGoal() {
//        Vector2D_EX robotPosition = SensorData.getRobotPosition();
//        return robotPosition.minus(getVirtualGoal()).length();
//    }
//
//    public static void offsetGoal(Vector2D_EX offset) {
//        if(AllianceColor.colors == AllianceColor.Colors.BLUE) {
//            goalOffsets.add(offset);
//            allianceGoal = allianceGoal.add(offset);
//        }
//        else {
//            goalOffsets.add(new Vector2D_EX(-offset.x, offset.y));
//            allianceGoal = allianceGoal.add(new Vector2D_EX(-offset.x, offset.y));
//        }
//    }
//
//    public static void resetGoalOffsets() {
//        allianceGoal = allianceGoal.add(goalOffsets);
//        goalOffsets = new Vector2D_EX(0, 0);
//    }
//
//
//    // -------------------- UTILS ------------------ //
//
//    public static double offsetToFitIn(double min, double max, double value, double step){
//        while(value < min) value += step;
//        while(value > max) value -= step;
//        return value;
//    }
//    public static double inMeters(double x){
//        return x * 0.0254;
//    }
//
//    public static Vector2D_EX VectorTravelledIn(double t){
//        return SensorData.getRobotVelocity().scalarMultiply(t);
//    }
//    public static double deltaAngle(){
//        return getAngleToVirtualGoal() - getAngleToGoal();
//    }
//
//    public static boolean isInFar(){
//        return SensorData.getRobotPosition().getY() < 82;
//    }
//
//    public static void setAllianceGoal(Vector2D_EX goal){
//        allianceGoal = goal;
//    }
//
//    // ------------------- USED IN THE PAST ----------------------- //
//
//    public static double goalHeightPercent(){
//        double angle = offsetToFitIn(0, Math.PI / 2, getAngleToGoal(), Math.PI / 2);
//        angle -= Math.PI / 4;
//        angle = Math.abs(angle);
//        angle /= Math.PI / 4;
//        return angle;
//    }
//
//    public static Vector2D_EX vectorToGoal() {
//        Vector2D_EX robotPosition = SensorData.getRobotPosition();
//        return robotPosition.minus(allianceGoal).scalarMultiply(-1);
//    }
//
//
//
//}