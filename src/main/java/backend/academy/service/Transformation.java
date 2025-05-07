package backend.academy.service;

import backend.academy.model.Point;

public interface Transformation {
    Point apply(Point point);
}
