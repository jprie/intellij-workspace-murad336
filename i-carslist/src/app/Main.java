package app;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {
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

        // 2 Konstruktoren
        ArrayList<Car> emptyList = new ArrayList<>();
        Collection emptyCollection = emptyList;

        // Argument an den Konstruktor ist vom Typ Collection (dahinter kann sich ein ArrayList, LinkedList, HashSet, ... verbergen)
        ArrayList<Car> listFromCollection = new ArrayList<>(emptyCollection);

        // Konvertiert ArrayList zu LinkedList - Erstellen eine neue LinkedList mit Kopien der Referenzen der Elemente der ArrayList
        LinkedList<Car> carLinkedList = new LinkedList<>(cars);

        // sind es tatsächlich Kopien -
        if (carLinkedList.get(0) == cars.get(0)) {
            System.out.println("Is identical");
        }

        // Füge Car doppelt hinzu.
        Car fiatUno = new Car("Fiat", "Uno", Car.Type.KLEINWAGEN, 160, 13000, LocalDate.of(1999, 4, 17));
        carLinkedList.add(fiatUno);

        // Element aus der Liste entfernen möchte
//        carLinkedList.remove(fiat);

        System.out.println("LinkedList");
        printCars(carLinkedList);

        // TreeSet erstellen
        // Referenzen aus LinkedList werden in TreeSet eingefügt und automatisch sortiert (nach natürlicher Ordnung)
        // Siehe Comparable<Car>
        TreeSet<Car> carsSet = new TreeSet<>(carLinkedList);

        System.out.println("TreeSet: sortiert nach brand und Duplikate entfernt");
        printCars(carsSet);

        // TreeSet mit eigenem Comparator
        TreeSet<Car> carsSetWithComparator = new TreeSet<>(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                int comparedBrand = o1.getBrand().compareTo(o2.getBrand());
                int compareModel = o1.getModel().compareTo(o2.getModel());
                // Wenn brands gleich, sortiere nach Model
                // ternäre if-expression: op1 ? op2 : op3
//                if (op1 == true) {
//                    op2;
//                } else {
//                    op3;
//                }
                // binäre operatoren wie op1 + op2
                // unärer operator -op1 (invertiere op1)
                return comparedBrand == 0 ? compareModel : comparedBrand;
            }
        });

        carsSetWithComparator.addAll(carLinkedList);
        printCars(carsSetWithComparator);

        // Map ganz leer erstellt, verwenden, hat andere API als Collection-Kinder
        HashMap<String, Car> carsMap = new HashMap();

        // value Car ((Fiat Uno) unter key "Fiat" einfügen
        carsMap.put(fiatUno.getModel(), fiatUno);

        // "Fiat" wiederfinden
        Car fiatFromMap = carsMap.get("Uno");

        // Aus der carsList eine Map machen, wo der Key das model ist
        for (Car car : carLinkedList) {
            carsMap.put(car.getModel(), car);
        }

        // Map ausgeben, hole ich mir alle keys
        for (String key : carsMap.keySet()) {
            System.out.println("Key: " + key + ", Value: " + carsMap.get(key));
        }
        System.out.println();

        // Fiat Uno überschreiben, wenn key ident wird value ersetzt
        carsMap.put(fiatUno.getModel(), fiatUno);

        // Map ausgeben, hole ich mir alle keys
        for (String key : carsMap.keySet()) {
            System.out.println("Key: " + key + ", Value: " + carsMap.get(key));
        }

        // Values der Map
        System.out.println("Cars from Map");
        printCars(carsMap.values());

        // Komplexen Typ
        // Speisekarte mit "Vorspeise", "Hauptspeise", "Beilage", "Dessert"
        // Für jeden Speise-Typ gibt es 3 oder mehr Gerichte.
        // HashMap<String, ArrayList<Dish>> menu = new HashMap<>();

        // 2. Beispiel: Kategorie-Name und eindeutige Bücher
        // HashMap<String, TreeSet<Book>> bookIndex = new HashMap<>();

        // 3. Beispiel: Kategorie-Name und Exemplare pro eindeutigem Buch
        // HashMap<String, TreeSet<List<Book>>> booksAvailable = new HashMap<>();
    }

    // Frage: Warum kann ich Set und List mit einer Methode ausgeben?
    private static void printCars(Collection<Car> cars) {

        // Beide implementieren Iterable<E>
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }
}
