import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Idee: Menu für 'Jim's finest'
        // als Key "Vorspeise", "Hauptspeise", "Beilage","Nachspeise"
        HashMap<String, ArrayList<Dish>> menu = new HashMap<>();


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

        menu.put("Vorspeise", new ArrayList<>());

        menu.get("Vorspeise").add(caprese);
        menu.get("Vorspeise").add(soup);

        // Hauptspeise
        ArrayList<Dish> mainCourses = new ArrayList<>(List.of(trout, steak));
        menu.put("Hauptspeise", mainCourses);

        Dish schnitzel = new Dish("Schnitzel", 14.50, List.of(Dish.Allergenic.F, Dish.Allergenic.C), Dish.DishType.MEAT, 250);

        menu.get("Hauptspeise").add(schnitzel);

        // Beilage


        // Dessert


        // Möchte jetzt die 2. Hauptspeise
        menu.get("Hauptspeise").get(1);

        // Suche Dish mit Namen "Schnitzel" unter Verwendung von Menu
        // menu.get("Schnitzel")

        for (Dish dish : menu.get("Hauptspeise")) {
            if (dish.getName().equals("Schnitzel")) {
                System.out.println(dish);
            }
        }

        List<Dish> dishListAllergenicsEF = new ArrayList<>();
        // Liste aller Dishes mit Allergenen E oder F oder Beiden?
        for (String key : menu.keySet()) {

            for (Dish dish : menu.get(key)) {
                if (dish.getAllergenics().contains(Dish.Allergenic.E) || dish.getAllergenics().contains(Dish.Allergenic.F)) {

                    dishListAllergenicsEF.add(dish);
                }
            }
        }

        // Für Verwendung mit TreeSet braucht es Comparable<Dish>
        Set<Dish> dishListWithPriceSmaller20 = new TreeSet<>();
        // Liste aller Dishes von denen Preis < 20
        for (String key : menu.keySet()) {

            for (Dish dish : menu.get(key)) {
                if (dish.getPrice() < 20) {
                    dishListWithPriceSmaller20.add(dish);
                }
            }
        }

        Map<Dish.DishType, ArrayList<Dish>> dishTypeMap = new HashMap<>();
        // Erstellung einer neuen Map<DishType, Dish>
        for (String key : menu.keySet()) {

            for (Dish dish : menu.get(key)) {

                if (!dishTypeMap.containsKey(dish.getType())) {
                    // TO BE CONTINUED
                }
            }
        }

    }
}
