public class Cars {

    public static int compareByMaxSpeed(Car c1, Car c2) {

        return c1.getMaxSpeed() - c2.getMaxSpeed();
    }

    public static int compareByModel(Car c1, Car c2) {

        return c1.getModel().compareTo(c2.getModel());
    }
}
