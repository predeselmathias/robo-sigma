package org.firstinspires.ftc.teamcode.Utils;

public class ConditionChecker extends Thread{

    private LambdaBool _lambdaC;
    private Lambda _lambdaA;

    public static int timeToEnd = 5000;
    public static boolean opModeStopped = false;
    private boolean hasTimeout;
    private boolean threadDelay;

    private boolean canceled;

    private int minTime;

    public ConditionChecker(LambdaBool lambdaCondition, Lambda lambdaAction){
        _lambdaC = lambdaCondition;
        _lambdaA = lambdaAction;
        hasTimeout = true;
        threadDelay = true;
        canceled = false;
        this.minTime = 5;
    }

    public ConditionChecker(LambdaBool lambdaCondition, Lambda lambdaAction, int minTime){
        _lambdaC = lambdaCondition;
        _lambdaA = lambdaAction;
        hasTimeout = true;
        threadDelay = true;
        canceled = false;
        this.minTime = minTime;
    }
    public ConditionChecker(LambdaBool lambdaCondition, Lambda lambdaAction, boolean timeout){
        _lambdaC = lambdaCondition;
        _lambdaA = lambdaAction;
        hasTimeout = timeout;
        threadDelay = true;
        canceled = false;
        this.minTime = 5;
    }

    public ConditionChecker(LambdaBool lambdaCondition, Lambda lambdaAction, boolean timeout, boolean threadDelay){
        _lambdaC = lambdaCondition;
        _lambdaA = lambdaAction;
        hasTimeout = timeout;
        this.threadDelay = threadDelay;
        canceled = false;
        this.minTime = 5;
    }

    @Override
    public void run() {
        long time = System.currentTimeMillis();
        long lastInCorrect = time + timeToEnd;
        while (!opModeStopped && !canceled){
            long current = System.currentTimeMillis();
            if (!_lambdaC.run()){
                lastInCorrect = current;
            } else if (minTime < 10) {
                break;
            }

            if (current - lastInCorrect > minTime){
                break;
            }

            if ((current - time > timeToEnd || opModeStopped) && hasTimeout){
                return;
            }
            if (threadDelay){
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        if (opModeStopped || canceled) return;
        _lambdaA.run();
    }

    public void cancel(){
        canceled = true;
    }
}
