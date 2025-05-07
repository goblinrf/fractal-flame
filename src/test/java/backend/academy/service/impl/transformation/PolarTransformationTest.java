package backend.academy.service.impl.transformation;

import backend.academy.model.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolarTransformationTest {

    @Test
    void givenPoint_whenApply_thenReturnTransformedPoint() {
        // Given
        Point inputPoint = new Point(1, 1);
        PolarTransformation transformation = new PolarTransformation();

        // When
        Point result = transformation.apply(inputPoint);

        // Then
        double r = Math.sqrt(1 * 1 + 1 * 1);
        double theta = Math.atan2(1, 1);
        assertEquals(theta / Math.PI, result.x(), 0.0001, "Ожидаемое значение X не совпадает");
        assertEquals(r - 1, result.y(), 0.0001, "Ожидаемое значение Y не совпадает");
    }
}
