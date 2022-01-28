package at.appdevs.basics;

public class GameCard {

    // Ist eine innere Klasse
    enum Color {
        HEARTS, DIAMONDS, SPADES, CLUBS;
    }

    enum Rank {
        // Hier werden alle Objekte vom Typ Rank erstellt
        // Objekte erstellt man mit Hilfe des Konstruktors
        // Deswegen passiert hier der Konstruktor-Aufruf
        TEN(10), JACK(2), QUEEN(3), KING(4), ACE(11);

        private int points;

        // Im enum ist der Konstruktor immer private
        // Sonst könnte ich weitere Objekte erstellen und genau das möchte
        // ich mit enum verhindern.
        private Rank(int points) {
            this.points = points;
        }

        public int getPoints() {
            return points;
        }

        @Override
        public String toString() {
            return "Rank{" +
                    "points=" + points +
                    '}';
        }
    }

    private Color color;
    private Rank rank;

    public GameCard(Color color, Rank rank) {
        this.color = color;
        this.rank = rank;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public int getPoints() {
        return rank.getPoints();
    }

    @Override
    public String toString() {
        return "GameCard{" +
                "color=" + color +
                ", rank=" + rank +
                '}';
    }
}
