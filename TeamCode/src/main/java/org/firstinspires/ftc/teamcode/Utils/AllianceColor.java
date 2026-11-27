//package org.firstinspires.ftc.teamcode.Utils;
//
//import com.acmerobotics.dashboard.config.Config;
//
//@Config
//public class AllianceColor {
//    public enum Colors{
//        RED,
//        BLUE
//    }
//
//    public static Colors colors;
//
//    public static double xRedOffSet = 144.2;
//    public static double xOffSetToRight = 2.2;
//    public static double yOffSetToUp = 1.4;
//
//    public static void AssignAlliance(){
//        if(AllianceColor.colors == Colors.BLUE)
//            FieldMap.setAllianceGoal(FieldMap.blueGoal);
//        else
//            FieldMap.setAllianceGoal(FieldMap.redGoal);
//    }
//
//    public static double getStartOffSetPosesX(double x) {
//        if(AllianceColor.colors == Colors.BLUE)
//            return x;
//        else
//            return xRedOffSet - x - xOffSetToRight;
//    }
//
//    public static double getStartOffSetPosesY(double y) {
//        if(AllianceColor.colors == Colors.BLUE)
//            return y;
//        else
//            return y - yOffSetToUp;
//    }
//
//    public static double getOffSetPoses(double x) {
//        if(AllianceColor.colors == Colors.BLUE)
//            return x;
//        else
//            return xRedOffSet - x;
//    }
//    public static double offset(double x){
//        if(AllianceColor.colors == Colors.BLUE)
//            return 0;
//        else
//            return x;
//    }
//    public static double offsetHeading(double x){
//        if(AllianceColor.colors == Colors.BLUE)
//            return 0;
//        else
//            return x;
//    }
//
//    public static double getMirrorHeading(double heading) {
//        if(AllianceColor.colors == Colors.BLUE)
//            return heading;
//        else
//            return (180 - heading) % 360;
//    }
//}
