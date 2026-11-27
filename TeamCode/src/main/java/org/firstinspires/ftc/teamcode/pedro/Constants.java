package org.firstinspires.ftc.teamcode.pedro;

import com.pedropathing.algorithm.Foresight;
import com.pedropathing.algorithm.ForesightConfig;
import com.pedropathing.controllers.Controller;
import com.pedropathing.follower.Follower;
import com.pedropathing.math.Matrix;
import com.pedropathing.math.Vector2D;
import com.pedropathing.revhub.drivetrains.Mecanum;
import com.pedropathing.revhub.drivetrains.MecanumConfig;
import com.pedropathing.revhub.localizers.PinpointConfig;
import com.pedropathing.revhub.localizers.PinpointLocalizer;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class Constants {

    public static Follower create(HardwareMap h) {

        return new Follower(
                new PinpointLocalizer(h, localizerConfig),
                new Mecanum(h, drivetrainConfig),
                new Foresight(foresightConfig)
        );


    }
    public static MecanumConfig drivetrainConfig = new MecanumConfig(c -> {
        c.frontLeftName.set("frontLeft");
        c.frontRightName.set("frontRight");
        c.backLeftName.set("backLeft");
        c.backRightName.set("backRight");

        c.frontLeftDirection.set(DcMotorSimple.Direction.FORWARD);
        c.frontRightDirection.set(DcMotorSimple.Direction.REVERSE);
        c.backLeftDirection.set(DcMotorSimple.Direction.REVERSE);
        c.backRightDirection.set(DcMotorSimple.Direction.FORWARD);
    });
    public static Mecanum createDrivetrain(HardwareMap map) {
        return new Mecanum(map, drivetrainConfig);
    }
    public static PinpointConfig localizerConfig = new PinpointConfig(c -> {
        c.name.set("pinpoint");
        c.podType.set(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD);
        c.xPodOffset.set(4.526133800116111);
        c.yPodOffset.set(2.5239385770061826);
        c.xPodDirection.set(GoBildaPinpointDriver.EncoderDirection.REVERSED);
        c.yPodDirection.set(GoBildaPinpointDriver.EncoderDirection.REVERSED);
        c.globalDistanceUnit.set(DistanceUnit.INCH);
        c.offsetUnits.set(DistanceUnit.INCH);
    });
    public static ForesightConfig foresightConfig = new ForesightConfig(
            c -> {
                Controller primaryTranslationalForward = Controller.proportional(0.29842224030648323);
                Controller secondaryTranslationalForward = Controller.proportional(0.11025904380412552);
                Controller primaryTranslationalLateral = Controller.proportional(0.4096822189630888);
                Controller secondaryTranslationalLateral = Controller.proportional(0.15136663299635847);

                c.forwardTranslational.set(Controller.piecewise(secondaryTranslationalForward).put(2.5, primaryTranslationalForward));
                c.strafeTranslational.set(Controller.piecewise(secondaryTranslationalLateral).put(2.5, primaryTranslationalLateral));

                c.coast.set(Controller.proportionalFeedforward(0.013768032119646494));
                c.brake.set(Controller.proportionalFeedforward(0.011702827301699519));

                c.headingFeedback.set(Controller.proportional(4.058845123576982));
                c.headingBrakeCoefficients.set(Vector2D.cartesian(0.036907028654092566, 0.008745216272047326));

                c.linearBrakeCoefficients.set(Matrix.diag(0.002595068035121194, 0.010731224740823142));
                c.quadraticBrakeCoefficients.set(Matrix.diag(2.4827650351731765E-4, 2.40817052444181E-5));

                c.maxAchievableForwardVelocity.set(75.65753145030136);
                c.maxAchievableStrafeVelocity.set(57.03652991730701);
                c.naturalForwardDeceleration.set(33.70614050548439);
                c.naturalStrafeDeceleration.set(67.83494620539248);
            }
    );
}