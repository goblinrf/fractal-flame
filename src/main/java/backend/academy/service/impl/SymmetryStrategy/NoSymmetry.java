package backend.academy.service.impl.SymmetryStrategy;

import backend.academy.model.Point;
import backend.academy.service.SymmetryStrategy;
import java.util.Collections;
import java.util.List;

public class NoSymmetry implements SymmetryStrategy {
    @Override
    public List<Point> apply(Point point) {
        return Collections.singletonList(point); // Только одна точка, без симметрии.
    }
}
