package org.firstinspires.ftc.teamcode.Utils;


public class Utils {

    public static void swap(Object a, Object b){
        Object temp = a;
        a = b;
        b = temp;
    }

    public static double sqr(double x){
        return x * x;
    }

    public static double cube(double x){
        return x * x * x;
    }

    public static double clamp(double x, double a, double b){
        return x = Math.max(a, Math.min(b, x));

    }

}
