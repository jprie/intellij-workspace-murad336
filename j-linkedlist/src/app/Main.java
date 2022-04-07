package app;

public class Main {

    public static void main(String[] args) {

        GenericLinkedList<String> genericLinkedList = new GenericLinkedList<>(
                new String[] {"Alpha", "Bravo", "Charlie"});

        System.out.println(genericLinkedList);

        genericLinkedList.add("Delta");

        System.out.println(genericLinkedList);

        for (String s : genericLinkedList) {
            System.out.println(s);
        }
    }
}
