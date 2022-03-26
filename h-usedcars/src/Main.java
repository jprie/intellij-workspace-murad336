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

        // Neu alle Methoden-Referenzen

        // Typ 1: statische Methode
        //Cars.compareByModel()
        Collections.sort(cars, Cars::compareByModel);

        // Typ 2: Objekt-Methode
        ModelComparator modelComparator = new ModelComparator();
        //modelComparator.compare() - der Aufruf der Methode vergleicht nur 2 Cars
        Collections.sort(cars, modelComparator::compare); // Vergleicht alle Cars miteinander
        cars.sort(modelComparator); // tut genau das Gleiche (ruft per default die einzig mögliche Methode auf)
        cars.sort(modelComparator::compare); // tut auch genau das Gleiche

        // Typ 3: Objekt-Methode, des Objekts das verglichen wird (Car)
        Collections.sort(cars, Car::compareTo);

        // bisher nach natürlicher Ordnung sortiert
        printCars(cars);

        // sortiert verkehrt natürlich
        Collections.sort(cars, Collections.reverseOrder());
        printCars(cars);

        // sortiert verkehrt nach Model
        Collections.sort(cars, Collections.reverseOrder(modelComparator));
        printCars(cars);

        // wenn Liste bereits sortiert, dreht es ohne weitere Vergleiche die Reihenfolge der Indizes um
        Collections.reverse(cars);
    }

    private static int compareByType(Car c1, Car c2) {

        return -(c1.getType().compareTo(c2.getType()));
    }

    private static void printCars(List<Car> cars) {

        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }
}
