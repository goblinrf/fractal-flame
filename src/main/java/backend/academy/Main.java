package backend.academy;

import backend.academy.logic.FractalFlameController;
import java.io.IOException;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Main {

    public static void main(String[] args) throws IOException {
        FractalFlameController fractalFlameController = new FractalFlameController();
        fractalFlameController.start();

    }

}
