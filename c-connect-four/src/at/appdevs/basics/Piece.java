package at.appdevs.basics;

public class Piece {

    enum Color {
        RED("r"), YELLOW("y");

        private String caption;

        private Color(String caption) {
            this.caption = caption;
        }
    }

    private Color color;

    public Piece(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return color.caption;
    }

}
