package at.appdevs.basics;

import java.util.Scanner;

public class Game {

    // Color als Attribut, damit in allen Methoden zugreifbar
    private Piece.Color currentPlayerColor;
    private int winCounter = 0;

    private Board board;

    public void initGame() {
        board = new Board();
    }

    public void startGame() {

        // exit-flag
        boolean doExit = false;
        Scanner scanner = new Scanner(System.in);
        int countRounds = 0;

        printBoard();

        // Farbe beginnt


        // UI mit Scanner
        do {

            // Zu Beginn des Zugs Farbe festlegen (alternierend)
            currentPlayerColor = Piece.Color.values()[countRounds % 2];

            System.out.println("Geben Sie eine Zahl für die Spalte in die Sie den Stein einwerfen möchten ein");
            int column = scanner.nextInt();

            // Input auf 1-7 begrenzen!!
            if (column < 1 || column > Board.BOARD_COLUMNS) {
                System.out.println("Bitte wählen Sie andere Spalte zwischen 1 und " + Board.BOARD_COLUMNS);
                // continue überspringt Zeilen und geht direkt zur Schleifen-Bedingung
                continue;
            }

            // Schwerkraft: wenn Spalte voll, Meldung und gleicher Spieler nochmals
            if (throwPieceIntoColumn(column-1) == false) {
                System.out.println("Spalte ist voll. Bitte wählen Sie andere Spalte.");
                continue;
            };

            if (checkIfCurrentPlayerWins()) {
                System.out.println("Spieler " + currentPlayerColor + " gewinnt!");
                doExit = true;
            }
            printBoard();
            // Inkrementiere am Ende der Runde
            countRounds++;

        } while(!doExit);

        // Überprüfen ob gewonnen



    }

    // Überprüfe alle 4 Richtungen
    private boolean checkIfCurrentPlayerWins() {

        boolean playerWins;

        // playerWins = (false || true) || false || false;
        // playerWins = (true || false) || false;
        // playerWins = (true || false)
        // playerWins = true;
        playerWins = checkHorizontalWin()
                        || checkVerticalWin()
                        || checkDiagonalWinTopLeftBottomRight()
                        || checkDiagonalWinTopRightBottomLeft();
//        playerWins = playerWins || checkVerticalWin();
//        playerWins |= checkDiagonalWinTopLeftBottomRight();
//        playerWins |= checkDiagonalWinTopRightBottomLeft();

        return playerWins;
    }

    private boolean checkDiagonalWinTopRightBottomLeft() {
        return false;
    }

    private boolean checkDiagonalWinTopLeftBottomRight() {

        int maxColIndex = Board.BOARD_COLUMNS-3;
        for (int i=0; i<Board.BOARD_COLUMNS-1; i++) {
            winCounter = 0;
            // Bestimme Start der Diagonale (mit Optimierung)
            int rowIndex = i >= maxColIndex ? i % (maxColIndex-1) : 0; ;
            int colIndex = i >= maxColIndex ? 0 : i;

            System.out.println(rowIndex + ", " + colIndex);

            while(colIndex < Board.BOARD_COLUMNS && rowIndex < Board.BOARD_ROWS) {

                countIfPieceAtPositionOfCurrentPlayerColor(rowIndex, colIndex);
                if (winCounter == 4) return true;
                // Diagonale Bewegung
                rowIndex++;
                colIndex++;
            }

        }

        return false;
    }

    private boolean checkVerticalWin() {

        for (int colIndex=0; colIndex < Board.BOARD_COLUMNS; colIndex++) {
            winCounter = 0;
            for (int rowIndex=0; rowIndex < Board.BOARD_ROWS; rowIndex++) {

                // Zähl-Logik
                // Input: rowIndex, colIndex
                // Idee: Verändere Zähler
                countIfPieceAtPositionOfCurrentPlayerColor(rowIndex, colIndex);
                if (winCounter==4) return true;
            }

        }
        return false;
    }

    private boolean checkHorizontalWin() {

        for (int rowIndex=0; rowIndex < Board.BOARD_ROWS; rowIndex++) {
            winCounter = 0;
            for (int colIndex=0; colIndex < Board.BOARD_COLUMNS; colIndex++) {

                // Zähl-Logik
                countIfPieceAtPositionOfCurrentPlayerColor(rowIndex, colIndex);
                if (winCounter==4) return true;

            }

        }


        return false;
    }

    private void countIfPieceAtPositionOfCurrentPlayerColor(int rowIndex, int colIndex) {

        Piece piece = board.getPieceFromPosition(rowIndex, colIndex);
        if (piece != null &&  piece.getColor() == currentPlayerColor) {
            winCounter++;

        } else {
            winCounter = 0;
        }
    }

    // Simuliere Schwerkraft
    private boolean throwPieceIntoColumn(int column) {

        // Es gibt 2 Möglichkeiten: von oben nach unten, oder von unten nach oben
        // Von unten nach oben ist viel einfacher
        for (int rowIndex=Board.BOARD_ROWS-1; rowIndex>=0; rowIndex--) {

            // Ist das Kastl leer
            if (board.getPieceFromPosition(rowIndex, column) == null) {
                // Setz den Stein
                board.setPieceAtPosition(new Piece(currentPlayerColor), rowIndex, column);
                // damit nur 1 Stein gesetzt wird
                return true;
            }
        }
        // Spalte voll: konnte Stein nicht setzen
        return false;


    }

    public void testGame() {

        // lege einen Stein an eine bestimmte Stelle
        board.setPieceAtPosition(new Piece(Piece.Color.RED),
                3,
                4);

        printBoard();
    }

    private void printBoard() {

        System.out.println(board);
    }
}
