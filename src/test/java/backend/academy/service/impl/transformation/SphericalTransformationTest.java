package backend.academy.service.impl.transformation;

import backend.academy.model.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SphericalTransformationTest {

    @Test
    @DisplayName("Трансформация Spherical должна сработать корректно")
    void givenPoint_whenApply_thenReturnTransformedPoint() {
        // Given
        Point inputPoint = new Point(2, 3);
        SphericalTransformation transformation = new SphericalTransformation();

        // When
        Point result = transformation.apply(inputPoint);

        // Then
        double r = 2 * 2 + 3 * 3;
        assertEquals(2 / r, result.x(), 0.0001, "Ожидаемое значение X не совпадает");
        assertEquals(3 / r, result.y(), 0.0001, "Ожидаемое значение Y не совпадает");
    }
}
