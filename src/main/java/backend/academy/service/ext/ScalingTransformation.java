package backend.academy.service.ext;

import backend.academy.model.Point;
import backend.academy.service.AffineTransformation;

public class ScalingTransformation extends AffineTransformation {
    private double scaleX;
    private double scaleY;

    public ScalingTransformation(double scaleX, double scaleY, int red, int green, int blue) {
        super(red, green, blue);
        this.scaleX = scaleX;
        this.scaleY = scaleY;
    }

    @Override
    public Point apply(double x, double y) {
        double newX = x * scaleX;
        double newY = y * scaleY;
        return new Point(newX, newY);
    }
}
