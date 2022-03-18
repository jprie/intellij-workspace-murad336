import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // List.of erzeugt eine sogenannte IMMUTABLE List
        List<Car> initList = List.of(
                new Car("Fiat", "Punto", Car.Type.KLEINWAGEN, 160, 13000, LocalDate.of(1999, 4, 17)),
                new Car("Ferrari", "F40", Car.Type.SPORTS, 314, 200000, LocalDate.of(1994,2,4)),
                new Car("VW", "Passat", Car.Type.LIMOUSINE, 240, 23000, LocalDate.of(2012, 7,2)),
                new Car("Mercedes", "M", Car.Type.SUV, 220, 32000, LocalDate.of(2010, 4, 19)),
                new Car("Ford", "Transit", Car.Type.TRUCK, 185, 24000, LocalDate.of(2014,5,3)),
                new Car("Alfa Romeo", "Giulia", Car.Type.COUPE, 215, 28000, LocalDate.of(2017, 4, 1))
        );

        // ArrayList ist veränderbar
        ArrayList<Car> cars = new ArrayList<>(initList);
        printCars(cars);

        // Sortieren nach Model-Name
        ModelComparator modelComparator = new ModelComparator();

        // sort sortiert 'in-place', original Array wird verändert
        cars.sort(modelComparator);
        printCars(cars);

        // Sortiere nach maxSpeed
        MaxSpeedComparator maxSpeedComparator = new MaxSpeedComparator();
        cars.sort(maxSpeedComparator);
        printCars(cars);

        // Sortiere nach Preis

        Comparator<Car> priceComparator = new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return (int)(o1.getPrice() - o2.getPrice());
            }
        };

        cars.sort(priceComparator);
        Collections.sort(cars, priceComparator);
        printCars(cars);

        // Sortiere nach buildDate
        Comparator<Car> buildDateComparator = (Car c1, Car c2) -> c1.getBuildDate().compareTo(c2.getBuildDate());

        cars.sort(buildDateComparator);
        Collections.sort(cars, buildDateComparator);
        printCars(cars);

        // Mit Comparable vergleichen (wird nicht wirklich so verwendet)
        int result = cars.get(0).compareTo(cars.get(1));

        // Nach natürlicher Reihenfolge (definiert in Car) sortieren
        Collections.sort(cars);

        // Mit bestimmntem Comparator sortieren
        Collections.sort(cars, modelComparator);
        cars.sort(modelComparator);

        // Nach Type sortieren (mit Methodenreferenz)
        Collections.sort(cars, Main::compareByType);

        // Nach maxSpeed sortieren (mit Methodenreferenz)
        Collections.sort(cars, Cars::compareByMaxSpeed);

        Cars.compareByMaxSpeed(cars.get(0), cars.get(1));

        // Nach natürlicher Reihenfolge sortieren
        Collections.sort(cars);
        Collections.sort(cars, Car::compareTo);

        // Wenn ich die Objekt-Methode eines 'anderen' Objekts aufrufen möchte
        Collections.sort(cars, modelComparator::compare);

    }

    private static int compareByType(Car c1, Car c2) {

        return c1.getType().compareTo(c2.getType());
    }

    private static void printCars(List<Car> cars) {

        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }
}
