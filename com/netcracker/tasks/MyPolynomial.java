package com.netcracker.tasks;

import java.util.Arrays;

public class MyPolynomial {
    private double[] coeffs;

    public MyPolynomial(double ... coeffs) {
        this.coeffs = coeffs;
    }

    public int getDegree() {
        return coeffs.length;
    }

    @Override
    public String toString() {
        return "MyPolynomial{" +
                "coeffs=" + Arrays.toString(coeffs) +
                '}';
    }

    public double evaluate(double x) {
        double evaluateResult = 0.0;
        for(int i = 0; i<coeffs.length; ++i){
            evaluateResult += Math.pow(x, i)*coeffs[i];
        }
        return evaluateResult;
    }

    public MyPolynomial add(MyPolynomial right) {
        int maxLength = coeffs.length >= right.coeffs.length ? coeffs.length : right.coeffs.length;
        double[] resultArray = new double[maxLength];

        for (int i = 0; i<coeffs.length; ++i) {
            resultArray[i] += coeffs[i];
        }
        for (int i = 0; i<right.coeffs.length; ++i) {
            resultArray[i] += right.coeffs[i];
        }
        return new MyPolynomial(resultArray);
    }

    public MyPolynomial multiply(MyPolynomial right) {

        double[] resultArray = new double[coeffs.length + right.coeffs.length - 1];

        for(int i = 0; i<coeffs.length; ++i) {
            for(int j = 0; j<right.coeffs.length; ++j) {
                resultArray[i+j] += coeffs[i] * right.coeffs[j];
            }
        }
        return new MyPolynomial(resultArray);
    }
}
