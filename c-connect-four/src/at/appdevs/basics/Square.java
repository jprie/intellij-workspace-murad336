package at.appdevs.basics;

public class Square {

    // Enthält bereits einen Spielstein oder nicht
    private Piece piece;

    public Square() {}

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    @Override
    public String toString() {
        return piece == null ? "." : piece.toString();
    }
}
