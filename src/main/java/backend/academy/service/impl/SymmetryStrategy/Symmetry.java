package backend.academy.service.impl.SymmetryStrategy;

import backend.academy.model.Point;
import backend.academy.service.SymmetryStrategy;
import java.util.ArrayList;
import java.util.List;

public class Symmetry implements SymmetryStrategy {
    private final int symmetry;

    public Symmetry(int symmetry) {
        this.symmetry = symmetry;
    }

    @Override
    public List<Point> apply(Point point) {
        List<Point> points = new ArrayList<>(symmetry);
        double centerX = 0;
        double centerY = 0;

        for (int i = 0; i < symmetry; i++) {
            double angle = 2 * Math.PI * i / symmetry;
            double cos = Math.cos(angle);
            double sin = Math.sin(angle);

            double rotatedX = cos * (point.x() - centerX) - sin * (point.y() - centerY) + centerX;
            double rotatedY = sin * (point.x() - centerX) + cos * (point.y() - centerY) + centerY;

            points.add(new Point(rotatedX, rotatedY));
        }
        return points;
    }
}
