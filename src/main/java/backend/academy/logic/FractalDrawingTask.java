package backend.academy.logic;

import backend.academy.model.FractalImage;
import backend.academy.model.Pixel;
import backend.academy.model.Point;
import backend.academy.model.Rect;
import backend.academy.service.AffineTransformation;
import backend.academy.service.SymmetryStrategy;
import backend.academy.service.Transformation;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ThreadLocalRandom;
import static backend.academy.factory.AffineTransformationsFactory.generateAffineTransformation;

@SuppressFBWarnings("PREDICTABLE_RANDOM")
public class FractalDrawingTask extends RecursiveTask<Void> {
    private transient FractalImage image;
    private transient Rect world;
    private final int iterations;
    private final List<Transformation> transformations;
    private transient SymmetryStrategy symmetryStrategy;
    private static final int DEFAULT_AFFINE_TRANSFORMATIONS = 8;
    private static final int WARMUP_STEPS = -20;

    public FractalDrawingTask(
        FractalImage image,
        Rect world,
        int iterations,
        List<Transformation> transformations,
        SymmetryStrategy symmetryStrategy
    ) {
        this.image = image;
        this.world = world;
        this.iterations = iterations;
        this.transformations = transformations;
        this.symmetryStrategy = symmetryStrategy;
    }

    @Override
    protected Void compute() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        double x = random.nextDouble(world.xmin(), world.xmax());
        double y = random.nextDouble(world.ymin(), world.ymax());
        Point point = new Point(x, y);

        List<AffineTransformation> affineTransformations =
            generateAffineTransformations(DEFAULT_AFFINE_TRANSFORMATIONS);

        for (int j = WARMUP_STEPS; j < iterations; j++) {
            AffineTransformation affineTransformation = affineTransformations.get(
                random.nextInt(affineTransformations.size())
            );
            point = affineTransformation.apply(point.x(), point.y());

            Transformation transformation = transformations.get(
                random.nextInt(transformations.size())
            );
            point = transformation.apply(point);

            if (j >= 0 && world.contains(point)) {
                List<Point> points = symmetryStrategy.apply(point);
                for (Point symPoint : points) {
                    updatePixel(symPoint, affineTransformation);
                }
            }
        }
        return null;
    }

    protected void updatePixel(Point point, AffineTransformation affineTransformation) {
        int pixelX = (int) (((point.x() - world.xmin()) / (world.xmax() - world.xmin())) * image.width());
        int pixelY =
            image.height() - (int) (((point.y() - world.ymin()) / (world.ymax() - world.ymin())) * image.height());

        if (image.contains(pixelX, pixelY)) {
            Pixel pixel = image.pixel(pixelX, pixelY);
            int newR = (pixel.hitCount() == 0) ? affineTransformation.getRed()
                : pixel.r() + affineTransformation.getRed() / 2;
            int newG = (pixel.hitCount() == 0) ? affineTransformation.getGreen()
                : pixel.g() + affineTransformation.getGreen() / 2;
            int newB = (pixel.hitCount() == 0) ? affineTransformation.getBlue()
                : pixel.b() + affineTransformation.getBlue() / 2;

            image.updatePixel(pixelX, pixelY, new Pixel(newR, newG, newB, pixel.hitCount() + 1, 0));
        }
    }

    private List<AffineTransformation> generateAffineTransformations(int count) {
        List<AffineTransformation> affineTransformations = new ArrayList<>(count);
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = 0; i < count; i++) {
            affineTransformations.add(generateAffineTransformation(random));
        }
        return affineTransformations;
    }
}
