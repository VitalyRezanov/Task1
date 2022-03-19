package com.netcracker.tasks;

public class MyComplex {
    private double real = 0.0;
    private double img = 0.0;

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
        return real != 0.0? true :false;
    }

    public boolean isImaginary() {
        return img != 0.0? true :false;
    }

    public boolean equals(double real, double imag) {
        return this.real == real && this.img == imag ? true: false;
    }

    public boolean equals(MyComplex another) {
        return equals(another.real, another.img);
    }

    public double magnitude() {
        return Math.sqrt(Math.pow(real, 2) + Math.pow(img, 2));
    }

    public double argument() {
        double arg = 0.0;
        if(real > 0 && img >= 0) {
            if(img==0){
                arg = 0.0;
            }
            else{
                arg = Math.atan(img/real);
            }
        }
        else if(real <= 0 && img > 0) {
            if(real == 0) {
                arg = Math.PI/2;
            }
            else {
                arg = Math.PI - Math.atan(img/real);
            }
        }
        else if(real < 0 && img <= 0) {
            if(img == 0) {
                arg = Math.PI;
            }
            else {
                arg = Math.atan(img/real) - Math.PI;
            }
        }
        else if(real >= 0 && img < 0) {
            if(real == 0) {
                arg = -Math.PI;
            }
            else {
                arg = -Math.atan(img/real);
            }
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
