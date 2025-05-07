package backend.academy.service.impl.transformation;

import backend.academy.model.Point;
import backend.academy.service.Transformation;
import java.io.Serializable;

public class SphericalTransformation implements Transformation, Serializable {

    @Override
    public Point apply(Point point) {
        double x = point.x();
        double y = point.y();

        double r = x * x + y * y;

        double newX = 1 / r * x;
        double newY = 1 / r * y;

        return new Point(newX, newY);
    }
}
