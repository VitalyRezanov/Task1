package com.netcracker.tasks;

import java.util.Objects;

public class Container {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Container(int x, int y, int width, int height) {
        this.x1 = x;
        this.y1 = y;
        this.x2 = x + width;
        this.y2 = y - height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Container container = (Container) o;
        return x1 == container.x1 && y1 == container.y1 && x2 == container.x2 && y2 == container.y2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x1, y1, x2, y2);
    }

    public int getX() {
        return x1;
    }

    public int getY() {
        return y1;
    }

    public int getWidth() {
        return Math.abs(x1 - x2);
    }

    public int getHeight() {
        return Math.abs(y1 - y2);
    }
    public boolean collides(Ball ball) {
        boolean mark = true;
        double xPlusRadius = ball.getX() + ball.getRadius();
        double yPlusRadius = ball.getY() + ball.getRadius();
        if ((xPlusRadius < x1 || xPlusRadius > x2) || (yPlusRadius > y1 || yPlusRadius < y2)) {
            mark = false;
        }
        return mark;
    }

    @Override
    public String toString() {
        return "Container{" +
                "(" + x1 +
                "," + y1 +
                "), (" + x2 +
                "," + y2 +
                ")}";
    }
}
