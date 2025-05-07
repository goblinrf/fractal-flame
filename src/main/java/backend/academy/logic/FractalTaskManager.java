package backend.academy.logic;

import backend.academy.model.FractalImage;
import backend.academy.model.Rect;
import backend.academy.service.SymmetryStrategy;
import backend.academy.service.Transformation;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class FractalTaskManager extends RecursiveTask<Void> {
    private transient FractalImage image;
    private transient Rect world;
    private final int n;
    private final int iterations;
    private List<Transformation> transformations;
    private transient SymmetryStrategy symmetry;

    public FractalTaskManager(
        FractalImage image,
        Rect world,
        int n,
        int iterations,
        List<Transformation> transformations,
        SymmetryStrategy symmetry
    ) {
        this.image = image;
        this.world = world;
        this.n = n;
        this.iterations = iterations;
        this.transformations = transformations;
        this.symmetry = symmetry;
    }

    @Override
    protected Void compute() {
        List<RecursiveTask<Void>> tasks = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            tasks.add(new FractalDrawingTask(
                image, world, iterations, transformations, symmetry
            ));
        }

        invokeAll(tasks);

        return null;
    }
}
