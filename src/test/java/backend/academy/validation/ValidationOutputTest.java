package backend.academy.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidationOutputTest {

    private ValidationOutput validationOutput;
    private String transformationPath = "src/main/resources/transformationsName.txt";

    @BeforeEach
    void setUp() {
        validationOutput = new ValidationOutput();
    }

    @Test
    @DisplayName("Валидация трансформаций должна проходить")
    void givenCorrectTransformation_whenValidationTransformation_thenAssertTrue() {
        //Given
        String[] transformations = {"swirl", "spherical"};
        //When
        boolean result = validationOutput.validationTransformation(transformationPath, transformations);
        //Then
        assertTrue(result);
    }

    @Test
    @DisplayName("Валидация трансформаций не должна проходить")
    void givenIncorrectTransformation_whenValidationTransformation_thenAssertFalse() {
        //Given
        String[] str = {"swirldsds", "spherical"};
        //When
        boolean result = validationOutput.validationTransformation(transformationPath, str);
        //Then
        assertFalse(result);
    }

    @Test
    @DisplayName("Валидация чисел не должна проходить")
    void givenIncorrectNumbers_whenValidationInteger_thenAssertFalse() {
        //Then
        assertFalse(validationOutput.validationInteger(0));
        assertFalse(validationOutput.validationInteger(-10));
    }

    @Test
    @DisplayName("Валидация чисел должна проходить")
    void givenCorrectNumber_whenValidationInteger_thenAssertTrue() {
        //Then
        assertTrue(validationOutput.validationInteger(1000));
    }
}
