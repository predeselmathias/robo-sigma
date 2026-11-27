//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pedropathing.control;

public class PIDFController {
    private PIDFCoefficients coefficients;
    private PIDFCoefficientSupplier coefficientSupplier;
    private double previousError;
    private double error;
    private double position;
    private double targetPosition;
    private double errorIntegral;
    private double errorDerivative;
    private double feedForwardInput;
    private long previousUpdateTimeNano;
    private long deltaTimeNano;

    public PIDFController(PIDFCoefficientSupplier set) {
        this.coefficientSupplier = set;
        this.setCoefficients(set.get((double)0.0F));
        this.reset();
    }

    public double run() {
        this.coefficients = this.coefficientSupplier.get(this.error);
        return this.error * this.P() + this.errorDerivative * this.D() + this.errorIntegral * this.I() + this.feedForwardInput * this.F();
    }

    public void updatePosition(double position) {
        this.position = position;
        this.previousError = this.error;
        this.error = this.targetPosition - this.position;
        this.deltaTimeNano = System.nanoTime() - this.previousUpdateTimeNano;
        this.previousUpdateTimeNano = System.nanoTime();
        this.errorIntegral += this.error * ((double)this.deltaTimeNano / Math.pow((double)10.0F, (double)9.0F));
        this.errorDerivative = (this.error - this.previousError) / ((double)this.deltaTimeNano / Math.pow((double)10.0F, (double)9.0F));
    }

    public void updateError(double error) {
        this.previousError = this.error;
        this.error = error;
        long nanoTime = System.nanoTime();
        this.deltaTimeNano = nanoTime - this.previousUpdateTimeNano;
        this.previousUpdateTimeNano = nanoTime;
        this.errorIntegral += error * ((double)this.deltaTimeNano / Math.pow((double)10.0F, (double)9.0F));
        this.errorDerivative = (error - this.previousError) / ((double)this.deltaTimeNano / Math.pow((double)10.0F, (double)9.0F));
    }

    public void updateFeedForwardInput(double input) {
        this.feedForwardInput = input;
    }

    public void reset() {
        this.previousError = (double)0.0F;
        this.error = (double)0.0F;
        this.position = (double)0.0F;
        this.targetPosition = (double)0.0F;
        this.errorIntegral = (double)0.0F;
        this.errorDerivative = (double)0.0F;
        this.previousUpdateTimeNano = System.nanoTime();
    }

    public void setTargetPosition(double set) {
        this.targetPosition = set;
    }

    public double getTargetPosition() {
        return this.targetPosition;
    }

    public void setCoefficients(PIDFCoefficients set) {
        this.coefficients = set;
    }

    public PIDFCoefficients getCoefficients() {
        return this.coefficients;
    }

    public void setP(double set) {
        this.coefficients.P = set;
    }

    public double P() {
        return this.coefficients.P;
    }

    public void setI(double set) {
        this.coefficients.I = set;
    }

    public double I() {
        return this.coefficients.I;
    }

    public void setD(double set) {
        this.coefficients.D = set;
    }

    public double D() {
        return this.coefficients.D;
    }

    public void setF(double set) {
        this.coefficients.F = set;
    }

    public double F() {
        return this.coefficients.F;
    }

    public double getError() {
        return this.error;
    }

    public double getErrorDerivative() {
        return this.errorDerivative;
    }
}
