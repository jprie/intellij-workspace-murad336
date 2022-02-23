import java.math.BigDecimal;
import java.util.Objects;

public class Trip {

    private static int lastId = 0;

    private long id;
    private String name;
    private Destination destination;
    private BigDecimal price;

    public Trip(String name, Destination destination, BigDecimal price) {
        this.id = ++lastId;
        this.name = name;
        this.destination = destination;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean hasDestination(Destination destination) {

        // Besser mit Objects.equals, da dann null-sicher
//        null.equals(this.destination);

        return Objects.equals(this.destination, destination);
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", destination=" + destination +
                ", price=" + price +
                '}';
    }
}
