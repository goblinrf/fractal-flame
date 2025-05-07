package backend.academy.service.impl.transformation;

import backend.academy.model.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FisheyeTransformationTest {

    @Test
    @DisplayName("Трансформация Fisheye должна сработать корректно")
    void givenPoint_whenApply_thenReturnTransformedPoint() {
        // Given
        Point inputPoint = new Point(2, 2);
        FisheyeTransformation transformation = new FisheyeTransformation();

        // When
        Point result = transformation.apply(inputPoint);

        // Then
        double expectedX = 2 * 2 / (Math.sqrt(2 * 2 + 2 * 2) + 1);
        double expectedY = 2 * 2 / (Math.sqrt(2 * 2 + 2 * 2) + 1);
        assertEquals(expectedX, result.x(), 0.0001, "Ожидаемое значение X не совпадает");
        assertEquals(expectedY, result.y(), 0.0001, "Ожидаемое значение Y не совпадает");
    }
}
