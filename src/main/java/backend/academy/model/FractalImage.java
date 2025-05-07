package backend.academy.model;

public record FractalImage(Pixel[][] data, int width, int height) {
    public static FractalImage create(int width, int height) {
        Pixel[][] data = new Pixel[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                data[x][y] = new Pixel(0, 0, 0, 0, 0);
            }
        }
        return new FractalImage(data, width, height);
    }

    public boolean contains(int x, int y) {
        return x >= 0 && y >= 0 && x < width && y < height;
    }

    public Pixel pixel(int x, int y) {
        if (!contains(x, y)) {
            throw new IndexOutOfBoundsException("Point out of bounds.");
        }
        return data[x][y];
    }

    public void updatePixel(int x, int y, Pixel pixel) {
        if (contains(x, y)) {
            data[x][y] = pixel;
        }
    }
}
