package backend.academy.service.ext;

import backend.academy.model.Point;
import backend.academy.service.AffineTransformation;

public class RotationTransformation extends AffineTransformation {
    private double angle;

    public RotationTransformation(double angle, int red, int green, int blue) {
        super(red, green, blue);
        this.angle = angle;
    }

    @Override
    public Point apply(double x, double y) {
        double cosTheta = Math.cos(angle);
        double sinTheta = Math.sin(angle);
        double newX = x * cosTheta - y * sinTheta;
        double newY = x * sinTheta + y * cosTheta;
        return new Point(newX, newY);
    }
}
