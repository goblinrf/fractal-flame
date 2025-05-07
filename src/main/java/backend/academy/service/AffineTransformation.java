package backend.academy.service;

import backend.academy.model.Point;

public abstract class AffineTransformation {
    private int red;
    private int green;
    private int blue;

    public AffineTransformation(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public abstract Point apply(double x, double y);

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }
}
