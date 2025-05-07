package backend.academy;

import backend.academy.factory.TransformationFactory;
import backend.academy.logic.FractalGenerator;
import backend.academy.model.FractalImage;
import backend.academy.model.Rect;
import backend.academy.service.Transformation;
import backend.academy.service.impl.SymmetryStrategy.NoSymmetry;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FractalPerformanceTest {
    private TransformationFactory transformationFactory = new TransformationFactory();

    @Test
    @DisplayName("Время работы многопоточной версии должно быть меньше чем у одно поточной")
    public void givenMultiAndSingleThreadsFractalFlameConfig_whenStartSingleAndMultiThreadVersion_thenAssertMultiThreadBetter() {
        // Given
        int width = 800;
        int height = 800;
        int iterations = 10000;
        int multiThreads = 15;
        int singleThread = 1;
        int n = 1000;
        NoSymmetry symmetry;
        Rect world = new Rect(-1.5, -1.5, 1.5, 1.5);
        FractalImage imageSingleThread = FractalImage.create(width, height);
        FractalImage imageMultiThread = FractalImage.create(width, height);
        symmetry = new NoSymmetry();
        long startSingleThread = System.currentTimeMillis();
        List<Transformation> transformationList = transformationFactory.getTransformations(
            new String[] {"swirl"});

        // When
        FractalGenerator generator1 = new FractalGenerator(singleThread);
        generator1.generateFractal(imageSingleThread, world, n, iterations, transformationList, symmetry);
        long singleThreadTime = System.currentTimeMillis() - startSingleThread;
        System.out.println("Однопоточная версия заняла: " + singleThreadTime + " мс");

        FractalGenerator generator8 = new FractalGenerator(multiThreads);
        long startMultiThread = System.currentTimeMillis();
        generator8.generateFractal(imageMultiThread, world, n, iterations, transformationList, symmetry);
        long multiThreadTime = System.currentTimeMillis() - startMultiThread;
        System.out.println("Многопоточная версия заняла: " + multiThreadTime + " мс");

        // Then
       System.out.println(multiThreadTime<singleThreadTime);
    }

}
