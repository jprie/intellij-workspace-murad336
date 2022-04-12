import java.util.List;

public class Dish implements Comparable<Dish> {

    @Override
    public int compareTo(Dish o) {
        return this.getName().compareTo(o.getName());
    }

    enum Allergenic {
        A, B, C, D, E, F, G, H, I, J
    }

    enum DishType {
        MEAT, FISH, VEGETABLES, OTHER
    }

    private String name;
    private double price;
    private List<Allergenic> allergenics;
    private DishType type;
    private double calories;

    public Dish(String name, double price, List<Allergenic> allergenics, DishType type, double calories) {
        this.name = name;
        this.price = price;
        this.allergenics = allergenics;
        this.type = type;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Allergenic> getAllergenics() {
        return allergenics;
    }

    public void setAllergenics(List<Allergenic> allergenics) {
        this.allergenics = allergenics;
    }

    public DishType getType() {
        return type;
    }

    public void setType(DishType type) {
        this.type = type;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + "\'" +
                "}";
    }
}
