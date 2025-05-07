package backend.academy.service.impl.transformation;

import backend.academy.model.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandkerchiefTransformationTest {

    @Test
    @DisplayName("Трансформация Handkerchief должна сработать корректно")
    void givenPoint_whenApply_thenReturnTransformedPoint() {
        // Given
        Point inputPoint = new Point(3, 4);
        HandkerchiefTransformation transformation = new HandkerchiefTransformation();

        // When
        Point result = transformation.apply(inputPoint);

        // Then
        double r = Math.sqrt(3 * 3 + 4 * 4);
        double theta = Math.atan2(4, 3);
        double expectedX = r * Math.sin(theta + r);
        double expectedY = r * Math.cos(theta - r);
        assertEquals(expectedX, result.x(), 0.0001, "Ожидаемое значение X не совпадает");
        assertEquals(expectedY, result.y(), 0.0001, "Ожидаемое значение Y не совпадает");
    }
}
