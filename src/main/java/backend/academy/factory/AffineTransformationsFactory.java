package backend.academy.factory;

import backend.academy.service.AffineTransformation;
import backend.academy.service.ext.LinearTransformation;
import backend.academy.service.ext.RotationTransformation;
import backend.academy.service.ext.ScalingTransformation;
import backend.academy.service.ext.TranslationTransformation;
import java.util.Random;

@SuppressWarnings("MagicNumber")
public class AffineTransformationsFactory {

    public static AffineTransformation generateAffineTransformation(Random random) {
        int red = random.nextInt(100, 200);
        int green = random.nextInt(1);
        int blue = random.nextInt(200, 256);

        switch (random.nextInt(4)) {
            case 0 -> {
                double a = random.nextDouble() * 2 - 1;
                double b = random.nextDouble() * 2 - 1;
                double c = random.nextDouble() * 2 - 1;
                double d = random.nextDouble() * 2 - 1;
                double e = random.nextDouble() - 0.5;
                double f = random.nextDouble() - 0.5;
                return new LinearTransformation(a, b, c, d, e, f, red, green, blue);
            }
            case 1 -> {
                double angle = random.nextDouble() * 2 * Math.PI;
                return new RotationTransformation(angle, red, green, blue);
            }
            case 2 -> {
                double scaleX = random.nextDouble() * 2 + 0.5;
                double scaleY = random.nextDouble() * 2 + 0.5;
                return new ScalingTransformation(scaleX, scaleY, red, green, blue);
            }
            case 3 -> {
                double translateX = random.nextDouble() - 0.5;
                double translateY = random.nextDouble() - 0.5;
                return new TranslationTransformation(translateX, translateY, red, green, blue);
            }
            default -> throw new IllegalStateException("Unexpected value");
        }
    }

    private AffineTransformationsFactory() {
    }
}
