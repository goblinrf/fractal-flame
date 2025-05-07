package backend.academy.model;

public record Rect(double xmin, double ymin, double xmax, double ymax) {
    public boolean contains(Point point) {
        return point.x() >= xmin() && point.x() <= xmax()
            && point.y() >= ymin() && point.y() <= ymax();
    }
}
