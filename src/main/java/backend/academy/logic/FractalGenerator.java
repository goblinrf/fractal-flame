package backend.academy.logic;

import backend.academy.model.FractalImage;
import backend.academy.model.Rect;
import backend.academy.service.SymmetryStrategy;
import backend.academy.service.Transformation;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class FractalGenerator {

    private final int numThreads;

    public FractalGenerator(int numThreads) {
        this.numThreads = numThreads;
    }

    public void generateFractal(
        FractalImage image,
        Rect world,
        int n,
        int iterations,
        List<Transformation> transformations,
        SymmetryStrategy symmetry
    ) {

        ForkJoinPool forkJoinPool = new ForkJoinPool(numThreads);

        FractalTaskManager taskManager = new FractalTaskManager(
            image, world, n, iterations, transformations, symmetry
        );

        forkJoinPool.invoke(taskManager);

        forkJoinPool.shutdown();
    }
}
