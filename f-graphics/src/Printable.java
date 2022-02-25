public interface Printable {

    // statische Attribute möglich
    static final double WIDTH_A4 = 21.0;
    static final double HEIGHT_A4 = 29.7;

    // statische Methoden mit Implementierung möglich
    static boolean fitsA4(double height, double width) {
        return height <= HEIGHT_A4 && width <= WIDTH_A4;
    }

    // Methoden in Interfaces sind automatisch abstrakt und public
    int print();

    // default Methoden weichen die Verpflichtung, abstrakte Methoden zu
    // implementieren auf, da eine default-Implementierung mitgeliefert wird
    // Das erlaubt Erweiterung der Java API ohne bestehende Projekte zu brechen
    default void printBeautifully() {
        System.out.println("This is the default implementation of print beautifully");
    }

}
