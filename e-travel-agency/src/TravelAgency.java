import java.util.ArrayList;
import java.util.List;

public class TravelAgency {

    private String name;
    private List<Trip> trips;

    public TravelAgency(String name, List<Trip> trips) {
        this.name = name;
        this.trips = trips;
    }

    public List<Trip> findTripsWithDestination(Destination destination) {

        List<Trip> foundTrips = new ArrayList<>();

        for (Trip t : trips) {
            if (t.hasDestination(destination)) {
                foundTrips.add(t);
            }
        }

        return foundTrips;
    }

    public void addTrip(Trip trip) {

        trips.add(trip);
    }

    public Trip removeTrip(int index) {

        return trips.remove(index);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }
}
