package com.netcracker.tasks.one;

public class Ball {

    private double x;
    private double y;
    private int radius;
    private double xDelta;
    private double yDelta;

    public Ball(double x, double y, int radius, int speed, int direction) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.xDelta = speed * Math.cos(direction);
        this.yDelta = -speed * Math.sin(direction);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return Double.compare(ball.x, x) == 0 && Double.compare(ball.y, y) == 0 && radius == ball.radius
                && Double.compare(ball.xDelta, xDelta) == 0 && Double.compare(ball.yDelta, yDelta) == 0;
    }

    @Override
    public int hashCode() {
        int result = 17;

        result = 31 * result + (int)(Double.doubleToLongBits(x) ^ (Double.doubleToLongBits(x) >>> 32));
        result = 31 * result + (int)(Double.doubleToLongBits(y) ^ (Double.doubleToLongBits(y) >>> 32));
        result = 31 * result + radius;
        result = 31 * result + (int)(Double.doubleToLongBits(xDelta) ^ (Double.doubleToLongBits(xDelta) >>> 32));
        result = 31 * result + (int)(Double.doubleToLongBits(yDelta) ^ (Double.doubleToLongBits(yDelta) >>> 32));

        return result;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public double getXDelta() {
        return xDelta;
    }

    public void setXDelta(double xDelta) {
        this.xDelta = xDelta;
    }

    public double getYDelta() {
        return yDelta;
    }

    public void setYDelta(double yDelta) {
        this.yDelta = yDelta;
    }

    public void move() {
        x += xDelta;
        y += yDelta;
    }

    public void reflectHorizontal() {
        xDelta = -xDelta;
    }

    public void reflectVertical() {
        yDelta = -yDelta;
    }

    @Override
    public String toString() {
        return "Ball{" +
                "(" + x +
                "," + y +
                "), speed=(" + xDelta +
                "," + yDelta +
                ")}";
    }
}
