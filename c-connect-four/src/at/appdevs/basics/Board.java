package at.appdevs.basics;

import java.util.Arrays;

public class Board {

    public static final int BOARD_ROWS = 6;
    public static final int BOARD_COLUMNS = 7;

    // Leeres 6x7 Array: d.h. alle Positionen sind null
    // Deswegen braucht es initSquares
    private Square[][] squares = new Square[BOARD_ROWS][BOARD_COLUMNS];

    public Board() {
        // Befüllt das Array mit Squares
        initSquares();
    }

    private void initSquares() {

        for (int rowCount=0; rowCount<BOARD_ROWS; rowCount++) {

            for (int colCount=0; colCount<BOARD_COLUMNS; colCount++) {

                // ersetze null durch ein neues Square
                squares[rowCount][colCount] = new Square();
            }
        }
    }

    public void setPieceAtPosition(Piece piece, int row, int col) {

        squares[row][col].setPiece(piece);
    }

    public Piece getPieceFromPosition(int row, int col) {

        // ACHTUNG: kann null enthalten!!!
        return squares[row][col].getPiece();
    }

    @Override
    public String toString() {

        String output = "";

        // Spalten-Zahlen nummerieren
        for (int i=0; i<BOARD_COLUMNS; i++) {
            output += (i+1) + "\t";
        }
        output += "\n";

        for (int rowCount=0; rowCount<BOARD_ROWS; rowCount++) {

            for (int colCount=0; colCount<BOARD_COLUMNS; colCount++) {

                // toString von Square für jedes Square
                Square square = squares[rowCount][colCount];
                output +=  square + "\t";
            }

            // Nach jeder Zeile umbrechen
            output += "\n";
        }

        return output;
    }
}
