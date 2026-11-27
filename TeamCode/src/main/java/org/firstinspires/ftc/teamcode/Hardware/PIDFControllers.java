import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

@Config
public class PIDFControllers {

    public static PIDFCoefficients shooterCoefficients = new PIDFCoefficients(0.00370, 0, 0, 0.82);

    private static final double shooterPeakVelocity = 2500;
    public static double shooterActualTarget;
    public static double shooterOffsettingRatio = 20;
    public static double velocityOffset = 63;

    private static PIDFController shooterController;
    public static boolean shooterEnabled;

    public static final double tunedVoltage = 12.5;

    public static void init() {
        shooterController = new PIDFController(shooterCoefficients);
        shooterEnabled = false;
    }

    public static void update() {
        double voltageCompensation = tunedVoltage / SensorData.getVoltage();
        double shooterVel = SensorData.getShooterVelocity();

        shooterController.updatePosition(shooterVel);
        shooterController.updateFeedForwardInput(shooterVel / shooterPeakVelocity);

        if (shooterEnabled && Math.abs(shooterActualTarget) >= 50) {
            double processedTarget = shooterActualTarget
                    + shooterOffsettingRatio * Math.max(0, shooterActualTarget - shooterVel)
                    + velocityOffset;

            shooterController.setTargetPosition(processedTarget);

            updateShooterPower(shooterController.run() * voltageCompensation);

        }
        else
            updateShooterPower(0);

    }


    private static void updateShooterPower(double power){
        Hardware.shooterLeft.setPower(power);
        Hardware.shooterRight.setPower(power);
    }

    public static void updateShooterCoefficients(PIDFCoefficients coefficients){
        shooterController.setCoefficients(coefficients);
    }

    public static void updateShooterCurrentVelocity(double position){
        shooterController.updatePosition(position);
    }

    public static void updateShooterTargetVelocity(double target){
        shooterActualTarget = target;
        shooterController.setTargetPosition(target + velocityOffset);
    }


    public static double getShooterPower(){
        return shooterController.run();
    }

    public static double getShooterCurrentVel() {
        return SensorData.getShooterVelocity();
    }

    public static double getShooterTargetVelocity(){
        return shooterActualTarget;
    }

    public static double getShooterOffsetTargetVel(){
        return shooterController.getTargetPosition();
    }

    public static void setShooterTargetConstant(double targetVelocity){
        PIDFControllers.shooterEnabled = true;
        double shooterVel = SensorData.getShooterVelocity();

        shooterController.updatePosition(shooterVel);
        shooterController.updateFeedForwardInput(shooterVel / shooterPeakVelocity);

        shooterController.setTargetPosition(targetVelocity + PIDFControllers.velocityOffset);

        updateShooterPower(shooterController.run());
    }


}
