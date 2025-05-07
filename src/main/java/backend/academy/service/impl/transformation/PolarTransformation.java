package backend.academy.service.impl.transformation;

import backend.academy.model.Point;
import backend.academy.service.Transformation;
import java.io.Serializable;

public class PolarTransformation implements Transformation, Serializable {

    @Override
    public Point apply(Point point) {
        double r = Math.sqrt(point.x() * point.x() + point.y() * point.y());
        double theta = Math.atan2(point.y(), point.x());
        return new Point(theta / Math.PI, r - 1);
    }
}
