package com.example.back.model.DTO;

public class Ratio {
    private int positive;
    private int negative;

    public Ratio() {
    }

    public Ratio(int positive, int negative) {
        this.positive = positive;
        this.negative = negative;
    }

    public int getPositive() {
        return positive;
    }

    public void setPositive(int positive) {
        this.positive = positive;
    }

    public int getNegative() {
        return negative;
    }

    public void setNegative(int negative) {
        this.negative = negative;
    }
}
