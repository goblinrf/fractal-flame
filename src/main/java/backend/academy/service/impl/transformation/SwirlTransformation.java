package backend.academy.service.impl.transformation;

import backend.academy.model.Point;
import backend.academy.service.Transformation;
import java.io.Serializable;

public class SwirlTransformation implements Transformation, Serializable {

    @Override
    public Point apply(Point point) {
        double x = point.x();
        double y = point.y();
        double r2 = x * x + y * y;
        double sinR2 = Math.sin(r2);
        double cosR2 = Math.cos(r2);

        double newX = x * sinR2 - y * cosR2;
        double newY = x * cosR2 + y * sinR2;

        return new Point(newX, newY);
    }

}
