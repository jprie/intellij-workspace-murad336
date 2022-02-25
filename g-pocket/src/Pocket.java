public class Pocket<T> {

    // Klassen-Methode
    // Da bei Klassen-Erstellung noch kein Typ-Parameter übergeben wird (erst bei Objekt-Erstellung)
    // MUSS der Typ-Parameter <T> bei Aufruf der Methode übergeben werden.
    static <T> void printPocket(Pocket<T> pocket) {

        System.out.println(pocket);
    }

    // Objekt-Methoden und Objekt-Attribute
    private T content;

    public Pocket(T content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Pocket{" +
                "content=" + content +
                '}';
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
