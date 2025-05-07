package backend.academy.service.impl.transformation;

import backend.academy.model.Point;
import backend.academy.service.Transformation;
import java.io.Serializable;

public class HandkerchiefTransformation implements Transformation, Serializable {

    @Override
    public Point apply(Point point) {
        double x = point.x();
        double y = point.y();
        double rSquared = Math.sqrt(x * x + y * y);
        double theta = Math.atan2(y, x);

        return new Point(rSquared * Math.sin(theta + rSquared), rSquared * Math.cos(theta - rSquared));
    }
}
