package backend.academy.service.impl.Output;

import backend.academy.factory.PrinterFactory;
import backend.academy.service.OutputStream;
import backend.academy.utils.Printer;

public class ConsoleOutput implements OutputStream {
    private final Printer printer = PrinterFactory.createPrinter();

    @Override
    public void print(Object message) {
        printer.print(message);
    }

    @Override
    public void println(Object message) {
        printer.println(message);
    }
}
