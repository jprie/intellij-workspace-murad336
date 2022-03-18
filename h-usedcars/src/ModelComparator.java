import java.util.Comparator;

public class ModelComparator implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {
        // Für String ist die Methode compareTo bereits implementiert!
        return o1.getModel().compareTo(o2.getModel());
    }
}
