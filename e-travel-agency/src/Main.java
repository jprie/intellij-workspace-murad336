import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        TravelAgency fineTrips = new TravelAgency("Fine Trips", new ArrayList<>());
        Trip barcelonaTrip = new Trip("Barcelona Trip", new Destination("Barcelona", "Spain"), new BigDecimal(3.4));
        Trip parisTrip = new Trip("Paris Trip", new Destination("Paris", "France"), new BigDecimal(3.4));

        fineTrips.addTrip(barcelonaTrip);
        fineTrips.addTrip(parisTrip);

        Destination graz = new Destination("Graz", "Austria");
        Destination  vienna = new Destination("Vienna", "Austria");

        if (graz.equals(vienna)) {
            System.out.println("Graz.equals(Vienna)");
        }

        if (barcelonaTrip.getDestination().equals(graz)) {

        }

        List<Trip> tripsToBarcelona = fineTrips.findTripsWithDestination(
                new Destination("Barcelona", "Spain"));

        System.out.println(tripsToBarcelona
        );
    }
}
