package backend.academy.service.ext;

import backend.academy.model.Point;
import backend.academy.service.AffineTransformation;

public class TranslationTransformation extends AffineTransformation {
    private double translateX;
    private double translateY;

    public TranslationTransformation(double translateX, double translateY, int red, int green, int blue) {
        super(red, green, blue);
        this.translateX = translateX;
        this.translateY = translateY;
    }

    @Override
    public Point apply(double x, double y) {
        double newX = x + translateX;
        double newY = y + translateY;
        return new Point(newX, newY);
    }
}
