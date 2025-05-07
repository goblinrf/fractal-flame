package backend.academy.service.impl.processor;

import backend.academy.model.FractalImage;
import backend.academy.model.Pixel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Тесты для LogGammaCorrection")
class LogGammaCorrectionTest {

    private LogGammaCorrection logGammaCorrection;

    @BeforeEach
    void setUp() {
        logGammaCorrection = new LogGammaCorrection();
    }

    @Test
    @DisplayName("Применение логарифмической гамма-коррекции должно отработать корректно")
    void givenFractalImage_whenStartGammaCorrection_thenGetPixelsAndCheckCorrect() {
        // given
        FractalImage image = FractalImage.create(2, 2);
        image.updatePixel(0, 0, new Pixel(100, 50, 25, 10, 0.0));
        image.updatePixel(0, 1, new Pixel(200, 100, 50, 20, 0.0));
        image.updatePixel(1, 0, new Pixel(50, 25, 10, 5, 0.0));
        image.updatePixel(1, 1, new Pixel(0, 0, 0, 0, 0.0));

        // when
        logGammaCorrection.process(image);

        // then
        Pixel pixel00 = image.pixel(0, 0);
        Pixel pixel01 = image.pixel(0, 1);
        Pixel pixel10 = image.pixel(1, 0);
        Pixel pixel11 = image.pixel(1, 1);

        assertThat(pixel00.r()).isBetween(0, 100);
        assertThat(pixel00.g()).isBetween(0, 50);
        assertThat(pixel00.b()).isBetween(0, 25);

        assertThat(pixel01.r()).isBetween(0, 200);
        assertThat(pixel01.g()).isBetween(0, 100);
        assertThat(pixel01.b()).isBetween(0, 50);

        assertThat(pixel10.r()).isBetween(0, 50);
        assertThat(pixel10.g()).isBetween(0, 25);
        assertThat(pixel10.b()).isBetween(0, 10);

        assertThat(pixel11.r()).isEqualTo(0);
        assertThat(pixel11.g()).isEqualTo(0);
        assertThat(pixel11.b()).isEqualTo(0);
    }
}
