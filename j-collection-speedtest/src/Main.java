import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        List<String> list = new LinkedList<>();
        Random random = new Random();

        int times = 100000;

        long timeElapsed = timeRunnable(() -> {

            for (int i=0; i<times; i++) {
                list.add("esprgiaejnsprbijaes]");
            }

            for (int i=0; i<times; i++) {
                list.remove(0);
            }
        });

        System.out.println("Time elapsed: " + timeElapsed / 1000000 + "ms");

    }

    public static long timeRunnable(Runnable runnable) {

        long startTime = System.nanoTime();

        runnable.run();

        long endTime = System.nanoTime();

        // return elapsed time
        return endTime - startTime;

    }
}
