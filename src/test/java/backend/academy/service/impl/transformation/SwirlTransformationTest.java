package backend.academy.service.impl.transformation;

import backend.academy.model.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwirlTransformationTest {

    @Test
    @DisplayName("Трансформация Swirl должна сработать корректно")
    void givenPoint_whenApply_thenReturnTransformedPoint() {
        // Given
        Point inputPoint = new Point(1, 1);
        SwirlTransformation transformation = new SwirlTransformation();

        // When
        Point result = transformation.apply(inputPoint);

        // Then
        double r2 = 1 * 1 + 1 * 1;
        double sinR2 = Math.sin(r2);
        double cosR2 = Math.cos(r2);
        double expectedX = 1 * sinR2 - 1 * cosR2;
        double expectedY = 1 * cosR2 + 1 * sinR2;
        assertEquals(expectedX, result.x(), 0.0001, "Ожидаемое значение X не совпадает");
        assertEquals(expectedY, result.y(), 0.0001, "Ожидаемое значение Y не совпадает");
    }
}
