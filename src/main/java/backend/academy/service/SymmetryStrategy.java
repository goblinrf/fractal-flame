package backend.academy.service;

import backend.academy.model.Point;
import java.util.List;

public interface SymmetryStrategy {
    List<Point> apply(Point point);
}
