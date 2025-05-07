package backend.academy.service.ext;

import backend.academy.model.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TranslationTransformationTest {
    private TranslationTransformation translation;


    @Test
    @DisplayName("Смещение должно сработать корректно")
    void givenTranslationParams_whenApplyNewPoint_thenAssertEquals() {
        // given
        Point point = new Point(0, 0);
        translation = new TranslationTransformation(5, -3, 255, 255, 0);
        // when
        Point result = translation.apply(point.x(), point.y());

        // then
        assertEquals(new Point(5, -3), result);
    }
}
