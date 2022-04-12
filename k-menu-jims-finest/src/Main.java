import java.util.*;

public class Main {

    enum CourseName {
        STARTER, MAIN, SIDE, DESSERT, DAILY
    }

    public static void main(String[] args) {

        // Idee: Menu für 'Jim's finest'
        // als Key "Vorspeise", "Hauptspeise", "Beilage","Nachspeise"
        HashMap<CourseName, ArrayList<Dish>> menu = new HashMap<>();


        Dish trout = new Dish("Forelle", 21.30, List.of(Dish.Allergenic.A, Dish.Allergenic.D, Dish.Allergenic.B),
                Dish.DishType.FISH, 230);

        Dish steak = new Dish("Steak", 25.30, List.of(Dish.Allergenic.E, Dish.Allergenic.F),
                                Dish.DishType.MEAT, 400.4);

        Dish rice = new Dish("Reis", 4.5, List.of(), Dish.DishType.VEGETABLES, 120);
        Dish potatoes = new Dish("Potatos", 7.30, List.of(), Dish.DishType.VEGETABLES, 70);

        Dish caprese = new Dish("Mozzarella und Tomate", 13.20, List.of(Dish.Allergenic.B), Dish.DishType.VEGETABLES, 150);
        Dish soup = new Dish("Fritattensuppe", 16.30, List.of(Dish.Allergenic.C), Dish.DishType.OTHER, 90.2);

        Dish tiramisu = new Dish("Tiramisu", 15.2, List.of(Dish.Allergenic.F, Dish.Allergenic.G), Dish.DishType.OTHER, 130);
        Dish sacher = new Dish("Sachertorte", 12, List.of(Dish.Allergenic.B, Dish.Allergenic.H),
                Dish.DishType.OTHER, 260);

        // Dishes in Speisekarte einfügen

        // Vorspeise
        // List<Dish> starters = new ArrayList<>()

        // key + leere Liste
        menu.put(CourseName.STARTER, new ArrayList<>());

        // hole leere Liste über key und befülle sie
        menu.get(CourseName.STARTER).add(caprese);
        // hole Liste mit Caprese
        menu.get(CourseName.STARTER).add(soup);

        // Hauptspeise
        // List.of erzeugt eine UNMODIFIABLE List
        List<Dish> unmodifiableList = List.of(trout, steak);

        // Mache daraus eine ArrayList, damit modifizierbar!
        ArrayList<Dish> mainCourses = new ArrayList<>(unmodifiableList);
        menu.put(CourseName.MAIN, mainCourses);

        Dish schnitzel = new Dish("Schnitzel", 14.50, List.of(Dish.Allergenic.F, Dish.Allergenic.C), Dish.DishType.MEAT, 250);

        // im Nachhinein Speisen hinzufügen/entfernen/reihenfolge verändern
        menu.get(CourseName.MAIN).add(schnitzel);

        // Beilage
        menu.put(CourseName.SIDE, new ArrayList<>());
        menu.get(CourseName.SIDE).add(rice);
        menu.get(CourseName.SIDE).add(potatoes);

        // Dessert
        menu.put(CourseName.DESSERT, new ArrayList<>());
        menu.get(CourseName.DESSERT).addAll(List.of(tiramisu, sacher));

        // Speisekarte fertig, ab hier Speisen finden und abfragen
        // Möchte jetzt die 2. Hauptspeise
        menu.get(CourseName.MAIN).get(1);

        // Suche Dish mit Namen "Schnitzel" unter Verwendung von Menu
        // menu.get("Schnitzel") geht nicht, da es keinen Key "Schnitzel" gibt

        for (Dish dish : menu.get(CourseName.MAIN)) {
            if (dish.getName().equals("Schnitzel")) {
                System.out.println(dish);
            }
        }

        List<Dish> dishListAllergenicsEF = new ArrayList<>();
        // Liste aller Dishes mit Allergenen E oder F oder Beiden?
        for (CourseName key : menu.keySet()) {

            for (Dish dish : menu.get(key)) {
                if (dish.getAllergenics().contains(Dish.Allergenic.E) || dish.getAllergenics().contains(Dish.Allergenic.F)) {

                    dishListAllergenicsEF.add(dish);
                }
            }
        }

        // Für Verwendung mit TreeSet braucht es Comparable<Dish>
        Set<Dish> dishListWithPriceSmaller20 = new TreeSet<>();
        // Liste aller Dishes von denen Preis < 20
        for (CourseName key : menu.keySet()) {

            for (Dish dish : menu.get(key)) {
                if (dish.getPrice() < 20) {
                    dishListWithPriceSmaller20.add(dish);
                }
            }
        }

        Map<Dish.DishType, ArrayList<Dish>> dishTypeMap = new HashMap<>();
        // Erstellung einer neuen Map<DishType, Dish>
        for (CourseName key : menu.keySet()) {

            for (Dish dish : menu.get(key)) {

                // Existiert die Liste für diesen Key bereits?
                if (!dishTypeMap.containsKey(dish.getType())) {
                    // wenn nein, erzeuge leere Liste und füge sie unter dem Key in die Map ein
                    dishTypeMap.put(dish.getType(), new ArrayList<>());
                }
                // in jedem Fall, hänge dish als Element an die Liste an
                dishTypeMap.get(dish.getType()).add(dish);
            }
        }

        // Idee: Tagesmenü
        menu.put(CourseName.DAILY, new ArrayList<>());

        // Zufällig eine Vorspeise fürs Mittagsmenü wählen
//        Dish starter = getRandomDishForCourseName(menu, CourseName.STARTER);
//        menu.get(CourseName.DAILY).add(starter);

        // Hauptspeise
//        Dish mainCourse = getRandomDishForCourseName(menu, CourseName.MAIN);
//        menu.get(CourseName.DAILY).add(mainCourse);

        // Beilage

        // Dessert

        // Erstellt ein Tagesmenü und fügt es in die Karte ein
        generateDailyAndInsertInMenu(menu);

        System.out.println(menu.get(CourseName.DAILY));
    }

    private static void generateDailyAndInsertInMenu(HashMap<CourseName, ArrayList<Dish>> menu) {
        for (CourseName courseName : CourseName.values()) {
            if (courseName != CourseName.DAILY) {
                Dish dish = getRandomDishForCourseName(menu, courseName);
                menu.get(CourseName.DAILY).add(dish);
            }
        }
    }

    private static Dish getRandomDishForCourseName(HashMap<CourseName, ArrayList<Dish>> menu,
                                                   CourseName courseName) {
        Random random = new Random();
        List<Dish> dishes = menu.get(courseName);
        return dishes.get(random.nextInt(dishes.size()));

    }
}
