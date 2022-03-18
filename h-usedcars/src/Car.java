import java.time.LocalDate;

public class Car implements  Comparable<Car> {

    @Override
    public int compareTo(Car o2) {
        return this.getBrand().compareTo(o2.getBrand());
    }

    enum Type {
        COUPE, CABRIOLET, KLEINWAGEN, LIMOUSINE, SPORTS, SUV, TRUCK
    }
    private String brand;
    private String model;
    private Type type;
    private int maxSpeed;
    private double price;
    private LocalDate buildDate;

    public Car(String brand, String model, Type type, int maxSpeed, double price, LocalDate buildDate) {
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.maxSpeed = maxSpeed;
        this.price = price;
        this.buildDate = buildDate;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", type=" + type +
                ", maxSpeed=" + maxSpeed +
                ", price=" + price +
                ", buildDate=" + buildDate +
                '}';
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getBuildDate() {
        return buildDate;
    }

    public void setBuildDate(LocalDate buildDate) {
        this.buildDate = buildDate;
    }
}
