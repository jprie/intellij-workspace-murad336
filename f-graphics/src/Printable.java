public interface Printable {

    static final double WIDTH_A4 = 21.0;
    static final double HEIGHT_A4 = 29.7;

    static boolean fitsA4(double height, double width) {
        return height <= HEIGHT_A4 && width <= WIDTH_A4;
    }

    // Methoden in Interfaces sind automatisch abstrakt und public
    int print();

    void printBeautifully();
}
