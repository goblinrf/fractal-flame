package backend.academy.logic;

import backend.academy.enums.ImageFormat;
import backend.academy.factory.InputFactory;
import backend.academy.factory.OutputFactory;
import backend.academy.factory.TransformationFactory;
import backend.academy.model.FractalImage;
import backend.academy.model.Rect;
import backend.academy.reader.ReaderFractalFlameParams;
import backend.academy.service.InputStream;
import backend.academy.service.OutputStream;
import backend.academy.service.SymmetryStrategy;
import backend.academy.service.Transformation;
import backend.academy.service.impl.SymmetryStrategy.NoSymmetry;
import backend.academy.service.impl.SymmetryStrategy.Symmetry;
import backend.academy.service.impl.processor.LogGammaCorrection;
import backend.academy.utils.ImageUtils;
import backend.academy.utils.ReadDataFromTxtFile;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

@SuppressWarnings("MultipleStringLiterals")
public class FractalFlameController {
    private String transformationPath = "src/main/resources/transformationsName.txt";
    private InputStream input = InputFactory.createInput("console");
    private ReaderFractalFlameParams readerFractalFlameParams = new ReaderFractalFlameParams(input);
    private OutputStream output = OutputFactory.createOutput("console");
    private TransformationFactory transformationFactory = new TransformationFactory();
    private SymmetryStrategy symmetry;

    public void start() throws IOException {
        int width = readerFractalFlameParams.readInteger("высоту");
        int height = readerFractalFlameParams.readInteger("ширину");
        FractalImage fractalImage = FractalImage.create(width, height);

        double xmin = readerFractalFlameParams.readDouble("минимальное значение x (можно дробное)");
        double ymin = readerFractalFlameParams.readDouble("минимальное значение y (можно дробное)");
        double xmax = readerFractalFlameParams.readDouble("максимальное значение x (можно дробное)");
        double ymax = readerFractalFlameParams.readDouble("максимальное значение y (можно дробное");
        Rect world = new Rect(xmin, ymin, xmax, ymax);

        int iterations = readerFractalFlameParams.readInteger("количество итерации");
        int n = readerFractalFlameParams.readInteger("количество точек");

        output.println(ReadDataFromTxtFile.getTransformationsFromFile(transformationPath));
        String[] transformationsName = readerFractalFlameParams.readTransformation(transformationPath);
        List<Transformation> transformationList = transformationFactory.getTransformations(
            transformationsName);

        int numThreads = readerFractalFlameParams.readInteger("количество потоков");
        FractalGenerator generator = new FractalGenerator(numThreads);

        int sym = readerFractalFlameParams.readSymmetry("симметрию. Если не хотите использовать, введите ноль");

        if (sym == 0) {
            symmetry = new NoSymmetry();
        } else {
            symmetry = new Symmetry(sym);
        }

        generator.generateFractal(fractalImage, world, n, iterations, transformationList, symmetry);
        LogGammaCorrection logGammaCorrection = new LogGammaCorrection();
        logGammaCorrection.process(fractalImage);

        ImageFormat format = ImageFormat.PNG;
        ImageUtils.save(fractalImage, Path.of("src/main/image/juliascope_fractal"), format);

    }
}
