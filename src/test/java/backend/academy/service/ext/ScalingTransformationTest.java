package backend.academy.service.ext;

import backend.academy.model.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ScalingTransformationTest {
    private ScalingTransformation scaling;
    @Test
    @DisplayName("Масштабирование должно сработать корректно")
    void givenScalingParams_whenApplyNewPoint_thenAssertEquals() {
        // given
        Point point = new Point(1, 1);
        scaling = new ScalingTransformation(2, 3, 0, 0, 255);
        // when
        Point result = scaling.apply(point.x(), point.y());

        // then
        assertEquals(new Point(2, 3), result);
    }
}
