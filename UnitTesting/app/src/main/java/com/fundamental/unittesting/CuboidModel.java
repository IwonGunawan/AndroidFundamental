package com.fundamental.unittesting;

public class CuboidModel {
    private double length;
    private double width;
    private double height;

    public CuboidModel() {

    }

    public void save(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double getVolume() {
        return length * width * height;
    }

    public double getCircumference() {
        return 4 * (length + width + height);
    }

    public double getSurfaceArea() {
        double wl = width * length;
        double wh = width * height;
        double lh = length * height;

        return 2 * (wl + wh + lh);
    }

}
