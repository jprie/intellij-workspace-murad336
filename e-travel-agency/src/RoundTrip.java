import java.math.BigDecimal;
import java.util.List;

public class RoundTrip extends Trip {

    private List<Destination> destinations;

    public RoundTrip(String name, BigDecimal price, List<Destination> destinations) throws Exception {
        // Konstruktor von Trip, bekommt Destination... StartPunkt der Reise

        super(name, destinations.size() > 0 ? destinations.get(0) : null, price);
        if (destinations.size() < 0) {
            throw new Exception("Destinations size < 0");
        }
        this.destinations = destinations;
    }

    @Override
    public boolean hasDestination(Destination destination) {
        for (Destination d : destinations) {

            if (d.equals(destination)) {
                return true;
            }
        }
        return false;
    }
}
