package app;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

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




    }

    private static void printCars(List<Car> cars) {

        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }
}
