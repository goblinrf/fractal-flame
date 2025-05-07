package backend.academy.reader;

import backend.academy.factory.PrinterFactory;
import backend.academy.service.InputStream;
import backend.academy.utils.Printer;
import backend.academy.validation.ValidationOutput;
import java.util.function.Function;

@SuppressWarnings({"ConstantName", "MultipleStringLiterals"})
public class ReaderFractalFlameParams {
    private final InputStream inputStream;
    private static final Printer printer = PrinterFactory.createPrinter();
    ValidationOutput validationOutput = new ValidationOutput();

    public ReaderFractalFlameParams(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public int readInteger(String str) {
        int num;
        do {
            printer.print("Введите " + str);
            num = inputStream.read(": ", Integer::parseInt);
        }
        while (!validationOutput.validationInteger(num));
        return num;
    }

    public int readSymmetry(String str) {
        printer.print("Введите " + str + ": ");
        int result = inputStream.read("", Integer::parseInt);

        return result;
    }

    public double readDouble(String str) {

        printer.print("Введите " + str + ": ");
        double result = inputStream.read("", Double::parseDouble);

        return result;
    }

    public String[] readTransformation(String path) {
        String[] algorithm;

        do {
            algorithm = inputStream.read("Введите трансформации"
                + "из выше перечисленных: ", Function.identity()).split(" ");
        }
        while (!validationOutput.validationTransformation(path, algorithm));
        return algorithm;
    }
}
