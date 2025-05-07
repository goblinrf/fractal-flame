package backend.academy.service.impl.SymmetryStrategy;

import backend.academy.model.Point;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Тесты для Symmetry")
class SymmetryTest {

    private Symmetry symmetry;

    @BeforeEach
    @DisplayName("Настраиваем количество симметрий на 4")
    void setUp() {
        symmetry = new Symmetry(4);
    }

    @Test
    @DisplayName("Генерация точек для симметрии 4 должна сработать корректно")
    void givenNewPoint_whenApplySymmetry_thenCheckCorrectPoint() {
        // given
        Point originPoint = new Point(1, 0);

        // when
        List<Point> points = symmetry.apply(originPoint);

        // then
        assertThat(points).hasSize(4);
        assertThat(points).containsExactlyInAnyOrder(
            new Point(1.0, 0.0),         // Оригинальная точка
            new Point(6.123233995736766E-17, 1.0),         // На 90 градусов
            new Point(-1.0, 1.2246467991473532E-16),        // На 180 градусов
            new Point(-1.8369701987210297E-16, -1.0)         // На 270 градусов
        );
    }
}
