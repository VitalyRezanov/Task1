package com.netcracker.tasks;


public class MyComplex {
    private double real = 0.0;
    private double img = 0.0;
    public static double epsilon = 0.000000000001;

    public MyComplex() {
    }

    public MyComplex(double real, double img) {
        this.real = real;
        this.img = img;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImg() {
        return img;
    }

    public void setImg(double img) {
        this.img = img;
    }

    public void setValue(double real, double img) {
        this.real = real;
        this.img = img;
    }

    @Override
    public String toString() {
        return "(real+imagi),e.g.,(" + real + "+" + img + "i)";
    }

    public boolean isReal() {
        return Math.abs(real) < epsilon;
    }

    public boolean isImaginary() {
        return Math.abs(img) < epsilon;
    }

    public boolean equals(double real, double imag) {
        return (Math.abs(this.real - real) < epsilon) && (Math.abs(this.img - imag)) < epsilon;
    }

    public boolean equals(MyComplex another) {
        return equals(another.real, another.img);
    }

    public double magnitude() {
        return Math.sqrt(Math.pow(real, 2) + Math.pow(img, 2));
    }

    public double argument1() {
        double arg = 0.0;
        if(real > 0 && img > 0) {
            arg = Math.atan(img/real);
        }
        else if (real > 0 && img < 0) {
            arg = -Math.atan(img/real);
        }
        if (real < 0 && img > 0) {
            arg = Math.PI - Math.atan(img/real);
        }
        else if (real < 0 && img < 0) {
            arg = Math.atan(img/real) - Math.PI;
        }
        else if (real < 0 && this.isImaginary()) {
            arg = Math.PI;
        }
        if (this.isReal() && img > 0)  {
            arg = Math.PI/2;
        }
        else if (this.isReal() && img < 0) {
            arg = -Math.PI;
        }
        return arg;
    }

    public MyComplex add(MyComplex right) {
        this.real += right.real;
        this.img += right.img;
        return this;
    }

    public MyComplex addNew(MyComplex right) {
        return new MyComplex(this.real + right.real, this.img + right.img);
    }

    public MyComplex subtract(MyComplex right) {
        this.real -= right.real;
        this.img -= right.img;
        return this;
    }

    public MyComplex subtractNew(MyComplex right) {
        return new MyComplex(this.real - right.real, this.img - right.img);
    }

    public MyComplex multiply(MyComplex right) {
        this.real *= right.real;
        this.img *= right.img;
        return this;
    }

    public MyComplex divide(MyComplex right) {
        this.real /= right.real;
        this.img /= right.img;
        return this;
    }

    public MyComplex conjugate() {
        return new MyComplex(real, -img);
    }
}
