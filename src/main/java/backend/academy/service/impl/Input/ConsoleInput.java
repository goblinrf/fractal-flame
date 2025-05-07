package backend.academy.service.impl.Input;

import backend.academy.service.InputStream;
import backend.academy.utils.ScannerUtils;
import java.util.function.Function;

public class ConsoleInput implements InputStream {
    @Override
    public <T> T read(String message, Function<String, T> parser) {
        return ScannerUtils.getInput(message, parser);
    }
}
