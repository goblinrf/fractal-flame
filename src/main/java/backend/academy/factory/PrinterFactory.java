package backend.academy.factory;

import backend.academy.utils.Printer;

@SuppressWarnings("HideUtilityClassConstructor")
public class PrinterFactory {
    public static Printer createPrinter() {
        return new Printer();
    }
}
