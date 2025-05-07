package backend.academy.logic;

import backend.academy.model.FractalImage;
import backend.academy.model.Pixel;
import backend.academy.model.Point;
import backend.academy.model.Rect;
import backend.academy.service.AffineTransformation;
import backend.academy.service.SymmetryStrategy;
import backend.academy.service.Transformation;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class FractalDrawingTaskTest {

    @Mock
    private FractalImage image;
    @Mock
    private Rect world;
    @Mock
    private SymmetryStrategy symmetryStrategy;
    @Mock
    private AffineTransformation affineTransformation;
    @Mock
    private Transformation transformation;
    @Captor
    private ArgumentCaptor<Point> pointCaptor;

    private List<Transformation> transformations;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        transformations = new ArrayList<>();
        transformations.add(transformation);
    }

    @Test
    @DisplayName("Должен корректно обновиться пиксель")
    void givenPointMockFractalDrawingTask_whenUpdatePixel_thenVerify() {
        //Given
        Point point = new Point(50.0, 50.0);
        when(image.contains(anyInt(), anyInt())).thenReturn(true);
        when(image.pixel(anyInt(), anyInt())).thenReturn(new Pixel(100, 100, 100, 1, 0));
        FractalDrawingTask task = new FractalDrawingTask(image, world, 10, transformations, symmetryStrategy);
        //When
        task.updatePixel(point, affineTransformation);
        //Then
        verify(image, times(1)).updatePixel(anyInt(), anyInt(), any(Pixel.class));
    }
}
