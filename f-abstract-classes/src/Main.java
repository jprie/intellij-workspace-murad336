public class Main {

    public static void main(String[] args) {

        GuideDog guideDog = new GuideDog("abc123");
        WatchDog watchDog = new WatchDog("fgh456");

        System.out.println(guideDog.getTaxes());
        System.out.println(watchDog.getTaxes());

        TaxedDog taxedDog = guideDog;

        TaxedDog[] taxedDogs = new TaxedDog[] {guideDog, watchDog};

        for (TaxedDog t : taxedDogs) {
            System.out.println("Dog with id: " + t.getTaxId() + ": " + t.getTaxes());

            // Frage: wie kann ich in dieser Schleife die Wachhunde im Array bellen lassen?
            if (t instanceof WatchDog) {
                WatchDog watchDog1 = (WatchDog) t; // Cast
                // t.barkForAlarm();
                watchDog1.barkForAlarm();
                watchDog1.getTaxId();
            }
        }
    }
}
