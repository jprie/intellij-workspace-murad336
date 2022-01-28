package at.appdevs.basics;

public class Game {

    private Board board;

    public void initGame() {
        board = new Board();
    }

    public void startGame() {

        printBoard();
        // UI mit Scanner
        // Abwechselnd ziehen
        // Überprüfen ob Eingabe möglich
        // Schwerkraft
        // Überprüfen ob gewonnen



    }

    private void printBoard() {

        System.out.println(board);
    }
}
