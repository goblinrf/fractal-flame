package backend.academy.utils;

import backend.academy.enums.ImageFormat;
import backend.academy.model.FractalImage;
import backend.academy.model.Pixel;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import javax.imageio.ImageIO;

@SuppressFBWarnings("PATH_TRAVERSAL_IN")
public final class ImageUtils {
    private static final int RED_SHIFT = 16;  // Сдвиг для красного компонента
    private static final int GREEN_SHIFT = 8; // Сдвиг для зелёного компонента
    private static final int BLUE_SHIFT = 0;

    public static void save(FractalImage image, Path filename, ImageFormat format) throws IOException {
        int width = image.width();
        int height = image.height();

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Pixel pixel = image.pixel(x, y);
                int color = (pixel.r() << RED_SHIFT) | (pixel.g() << GREEN_SHIFT) | (pixel.b() << BLUE_SHIFT);
                bufferedImage.setRGB(x, y, color);
            }
        }
        String formatName = format.name().toLowerCase();
        try {

            Path absolutePath = filename.toAbsolutePath().normalize();
            String fileNameString = absolutePath.toString();
            if (!fileNameString.endsWith("." + formatName)) {
                fileNameString += "." + formatName;
            }

            File file = new File(fileNameString);
            ImageIO.write(bufferedImage, formatName, file);
        } catch (InvalidPathException e) {
            throw new IOException("Некорректный путь", e);
        }

    }

    private ImageUtils() {

    }
}
