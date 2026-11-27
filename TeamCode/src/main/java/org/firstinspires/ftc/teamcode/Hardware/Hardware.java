package org.firstinspires.ftc.teamcode.Hardware;

import com.pedropathing.follower.Follower;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.VoltageSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.pedro.Constants;


public class Hardware extends HardwareUtils{
    public static DcMotorEx backLeft;
    public static DcMotorEx backRight;
    public static DcMotorEx frontLeft;
    public static DcMotorEx frontRight;
    public static GoBildaPinpointDriver pinpoint;
    public static DcMotorEx intake;
    public static DcMotorEx transfer;
    public static DcMotorEx shooterLeft;
    public static DcMotorEx shooterRight;
    public static Servo roof;
    public static Follower follower;
    public static Servo stopper;

    public static VoltageSensor voltageSensor;
    public static void init(HardwareMap _hardwareMap, Telemetry _telemetry){
        telemetry = _telemetry;
        hardwareMap = _hardwareMap;
        follower = Constants.create(hardwareMap);

        pinpoint = _hardwareMap.get(GoBildaPinpointDriver.class, "pinpoint");
        backLeft = getDcEx("backLeft");
        backRight = getDcEx("backRight");
        frontLeft = getDcEx("frontLeft");
        frontRight = getDcEx("frontRight");
        intake = getDcEx("intake");

        transfer = getDcEx("transfer");
        shooterLeft = getDcEx("shooterLeft");
        shooterRight = getDcEx("shooterRight");
        roof = getServo("roof");
        stopper = getServo("stopper");
        voltageSensor = hardwareMap.voltageSensor.iterator().next();
    }
    public static void config(){
        backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        frontLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.FORWARD);
        intake.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        transfer.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        shooterRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        shooterLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        shooterRight.setDirection(DcMotorSimple.Direction.REVERSE);
        shooterLeft.setDirection(DcMotorSimple.Direction.FORWARD);

        intake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        transfer.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        intake.setDirection(DcMotorEx.Direction.REVERSE);
        transfer.setDirection(DcMotorEx.Direction.FORWARD);


    }
    public static void start(){
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
}
