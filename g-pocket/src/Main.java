import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

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

        // Das Schlüsselwort var
        var doublePocket = new Pocket<Double>(2.3);
        Pocket<Double> doublePocket1 = new Pocket<Double>(2.3);

        Pocket<ArrayList<String>> pocketOfArrayListOfString;
        HashMap<String, Integer> hashOfStringAndInteger;
        HashMap<String, TreeSet<Integer> > hashMapOfStringAndTreeSetOfInteger;

        // var für komplexe generische Typ
        var complexList = new ArrayList<HashMap<String, TreeSet<Integer>>>();
        ArrayList<HashMap<String, TreeSet<Integer> > > complexListLong = new ArrayList<HashMap<String, TreeSet<Integer>>>();







    }
}
