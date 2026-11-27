package org.firstinspires.ftc.teamcode.Utils;

import com.pedropathing.math.Vector;

public class Vector2D_EX {
    public double x;
    public double y;

    public static final Vector2D_EX ZERO = new Vector2D_EX(0 ,0);
    public static final Vector2D_EX RIGHT = new Vector2D_EX(1, 0);
    public static final Vector2D_EX LEFT = new Vector2D_EX(-1, 0);
    public static final Vector2D_EX UP = new Vector2D_EX(0, 1);
    public static final Vector2D_EX DOWN = new Vector2D_EX(0, -1);


    public static Vector2D_EX fromAngle(double angle){
        return new Vector2D_EX(Math.cos(angle), Math.sin(angle));
    }

    public Vector2D_EX() {
        this.x = 0;
        this.y = 0;
    }
    public Vector2D_EX(double x, double y) {
        this.x = x;
        this.y = y;
    }
//    public Vector2D_EX(Vector pedroVector) {
//        this.x = pedroVector.getXComponent();
//        this.y = pedroVector.getYComponent();
//    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public boolean equals(Vector2D_EX other){
        return this.x == other.x && this.y == other.y;
    }

    // Method to subtract another Vector2D_EX from this one
    public Vector2D_EX minus(Vector2D_EX other) {
        return new Vector2D_EX(this.x - other.x, this.y - other.y);
    }

    // Method to add two vectors
    public Vector2D_EX add(Vector2D_EX other) {
        return new Vector2D_EX(this.x + other.x, this.y + other.y);
    }

    // Method to perform scalar multiplication
    public Vector2D_EX scalarMultiply(double scalar) {
        return new Vector2D_EX(this.x * scalar, this.y * scalar);
    }

    // Method to calculate the dot product of two 2D vectors
    public double dotProduct(Vector2D_EX other) {
        return this.x * other.x + this.y * other.y;
    }

    // Method to calculate the length of the vector
    public double length() {
        return Math.sqrt(x * x + y * y);
    }

    // Method to calculate the angle between two vectors
    public double angleBetween(Vector2D_EX other) {
        double dot = this.dotProduct(other);
        double lengths = this.length() * other.length();
        return Math.acos(dot / lengths); // returns the angle in radians
    }

    public double angleTo(Vector2D_EX other){
        return this.minus(other).scalarMultiply(-1).angle();
    }

    public boolean closeTo(Vector2D_EX other, double range){
        return this.minus(other).length() <= range;
    }

    public double angle(){
        return Math.atan2(y, x);
    }

    public Vector2D_EX rotated(double angle){
        double l = this.length();
        return Vector2D_EX.fromAngle(this.angle() + angle) .scalarMultiply(l);
    }

    @Override
    public String toString() {
        return "{" + "x=" + (int)(x * 1000) / 1000.0 + ", y=" + (int)(y * 1000) / 1000.0 + '}';
    }
}
