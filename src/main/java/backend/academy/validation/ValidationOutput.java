package backend.academy.validation;

import backend.academy.utils.ReadDataFromTxtFile;
import java.util.List;

@SuppressWarnings("ConstantName")
public class ValidationOutput {

    public boolean validationTransformation(String path, String[] transformations) {
        List<String> transformationName = ReadDataFromTxtFile.getTransformationsFromFile(path);
        for (String name : transformations) {
            if (!transformationName.contains(name.toLowerCase())) {
                return false;
            }
        }
        return true;
    }

    public boolean validationInteger(int num) {
        return num > 0;
    }
}
