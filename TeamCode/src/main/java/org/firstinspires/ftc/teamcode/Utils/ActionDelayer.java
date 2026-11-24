package org.firstinspires.ftc.teamcode.Utils;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ActionDelayer {
    public static double timeScale = 1;

    private static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(8);

    public static void setTimeScale(double _timeScale){
        timeScale = _timeScale;
    }

    public static void time(int msDelay, Lambda lambda) {
        scheduler.schedule(lambda::run, msDelay, TimeUnit.MILLISECONDS);
    }

    public static void time(int msDelay, Lambda lambda, double customTimeScale){
        msDelay = (int)(msDelay * (1 / customTimeScale));
        time(msDelay, lambda);
    }

    public static ConditionChecker condition(LambdaBool condition, Lambda action){
        ConditionChecker checker = new ConditionChecker(condition, action);
        checker.start();
        return checker;
    }

    public static ConditionChecker condition(LambdaBool condition, int minTime, Lambda action){
        ConditionChecker checker = new ConditionChecker(condition, action, minTime);
        checker.start();
        return checker;
    }

    public static void conditionHighAccuracy(LambdaBool condition, Lambda action){
        new ConditionChecker(condition, action, true, false).start();
    }

    public static void condition(LambdaBool condition, Lambda action, boolean timeout){
        new ConditionChecker(condition, action, timeout).start();
    }

    public static void repeat(LambdaBool condition, int stepDelay, Lambda action) {

    }

    public static void reset() {
        scheduler.shutdownNow();
        scheduler = Executors.newScheduledThreadPool(4);
    }
}