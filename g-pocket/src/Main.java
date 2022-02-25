public class Main {

    public static void main(String[] args) {

        // Raw-Types: die in denen kein Typ-Parameter definiert wurde
        // Dann wird automatisch java.lang.Object verwendet.
        Pocket pocket = new Pocket(1);
        Pocket pocketString = new Pocket("Hello");


        // Wrapper-Klassen

        // boxing
        Double dRef = Double.valueOf(2.3);

        // unboxing
        double d = dRef.doubleValue();

        // auto-unboxing
        int i = (Integer)pocket.getContent();

        // auto-boxing
        Integer iRef = 2;


        // Typ-Parameter selbst angeben
        Pocket<String> stringPocket = new Pocket<String>("hello");
        String hello = stringPocket.getContent();


        Pocket<Integer> integerPocket = new Pocket<>(1);
        int i2 = integerPocket.getContent();

        // Generische Methode aufrufen
        Pocket.printPocket(stringPocket);
    }
}
