package backend.academy.service.impl.processor;

import backend.academy.model.FractalImage;
import backend.academy.model.Pixel;
import static java.lang.Math.pow;

@SuppressWarnings({"MemberName", "MagicNumber"})
public class LogGammaCorrection {
    private double GAMMA = 2.2;

    public void process(FractalImage image) {
        double maxIntensity = 0.0;

        final int width = image.width();
        final int height = image.height();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Pixel pixel = image.pixel(x, y);
                if (pixel.hitCount() > 0) {
                    double intensity = Math.log10(pixel.hitCount());
                    maxIntensity = Math.max(maxIntensity, intensity);
                    image.updatePixel(x, y, new Pixel(pixel.r(), pixel.g(), pixel.b(), pixel.hitCount(), intensity));
                }
            }
        }

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Pixel pixel = image.pixel(x, y);
                if (pixel.hitCount() > 0) {
                    double normalized = pixel.normal() / maxIntensity;

                    int correctedR = (int) (pixel.r() * pow(normalized, (1.0 / GAMMA)));
                    int correctedG = (int) (pixel.g() * pow(normalized, (1.0 / GAMMA)));
                    int correctedB = (int) (pixel.b() * pow(normalized, (1.0 / GAMMA)));

                    image.updatePixel(x, y,
                        new Pixel(correctedR, correctedG, correctedB, pixel.hitCount(), normalized));
                }
            }
        }
    }

}
