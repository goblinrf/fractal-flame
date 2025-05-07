package backend.academy.service.ext;

import backend.academy.model.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LinearTransformationTest {
    private LinearTransformation linear;
    @Test
    @DisplayName("Линейное преобразование должно сработать корректно")
    void givenLinerParams_whenApplyNewPoint_thenAssertEquals() {
        // given
        linear = new LinearTransformation(1, 2, 0, 3, 1, 0, 255, 0, 0);
        Point point = new Point(1, 2);

        // when
        Point result = linear.apply(point.x(), point.y());

        // then
        assertEquals(new Point(5, 5), result);
    }
}
