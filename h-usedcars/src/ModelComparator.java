import java.util.Comparator;

public class ModelComparator implements Comparator<Car> {

    // Objekt-Methode: d.h. zur Ausführung brauche ich  ein Objekt!!
    @Override
    public int compare(Car o1, Car o2) {
        // Für String ist die Methode compareTo bereits implementiert!
        return o1.getModel().compareTo(o2.getModel());
    }
}
