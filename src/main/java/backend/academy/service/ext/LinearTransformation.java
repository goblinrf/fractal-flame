package backend.academy.service.ext;

import backend.academy.model.Point;
import backend.academy.service.AffineTransformation;

@SuppressWarnings("ParameterNumber")
public class LinearTransformation extends AffineTransformation {
    private double a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;

    public LinearTransformation(
        double a,
        double b,
        double c,
        double d,
        double e,
        double f,
        int red,
        int green,
        int blue
    ) {
        super(red, green, blue);
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    @Override
    public Point apply(double x, double y) {
        double newX = a * x + b * y + c;
        double newY = d * x + e * y + f;
        return new Point(newX, newY);
    }
}
