package backend.academy.service.ext;

import backend.academy.model.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RotationTransformationTest {
    private RotationTransformation rotation;

    @Test
    @DisplayName("Поворот на 90 градусов должно сработать корректно")
    void givenRotationParams_whenApplyNewPoint_thenAssertEquals() {
        // given
        Point point = new Point(1, 0);
        rotation = new RotationTransformation(Math.PI / 2, 0, 255, 0);
        // when
        Point result = rotation.apply(point.x(), point.y());

        // then
        assertEquals(0.0, result.x(), 1e-10);
        assertEquals(1.0, result.y(), 1e-10);
    }
}
