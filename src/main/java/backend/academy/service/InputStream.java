package backend.academy.service;

import java.util.function.Function;

public interface InputStream {
    <T> T read(String message, Function<String, T> parser);
}
