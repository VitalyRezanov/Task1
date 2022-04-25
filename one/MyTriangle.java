package com.netcracker.tasks.one;

import java.util.Objects;

public class MyTriangle {
    private MyPoint v1;
    private MyPoint v2;
    private MyPoint v3;

    public MyTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        this.v1.setXY(x1, y1);
        this.v2.setXY(x2, y2);
        this.v3.setXY(x3, y3);
    }

    public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyTriangle that = (MyTriangle) o;
        return Objects.equals(v1, that.v1) && Objects.equals(v2, that.v2) && Objects.equals(v3, that.v3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(v1, v2, v3);
    }

    @Override
    public String toString() {
        return "MyTriangle{" +
                "v1=" + v1 +
                ", v2=" + v2 +
                ", v3=" + v3 +
                '}';
    }
    public double getPerimeter() {
        return v1.distance(v2) + v2.distance(v3) + v3.distance(v1);
    }
    public String getType() {

        Double side1 = new Double(v1.distance(v2));
        Double side2 = new Double(v2.distance(v3));
        Double side3 = new Double(v3.distance(v1));

        if (side1.compareTo(side2) == 0 && side2.compareTo(side3) == 0) {
            return "Equilateral";
        }
        else if (side1.compareTo(side2) == 0 || side1.compareTo(side3) == 0 || side2.compareTo(side3) == 0) {
            return "Isosceles";
        }
        else {
            return "Scalene";
        }
    }
}
