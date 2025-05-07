package backend.academy.service.impl.transformation;

import backend.academy.model.Point;
import backend.academy.service.Transformation;
import java.io.Serializable;

public class FisheyeTransformation implements Transformation, Serializable {

    @Override
    public Point apply(Point point) {
        double x = point.x();
        double y = point.y();
        double r = Math.sqrt(x * x + y * y);
        double factor = 2 / (r + 1);

        // Reversed order of x and y in the output
        return new Point(factor * y, factor * x);
    }
}
