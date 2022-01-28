package at.appdevs.basics;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<GameCard> cardsList = new ArrayList<>();
        GameCard aCard = new GameCard(GameCard.Color.CLUBS,
                                    GameCard.Rank.ACE);

        // Wie kann ich in ein ganzes Deck erstellen
        GameCard.Rank[] ranks = GameCard.Rank.values();
        GameCard.Color[] colors = GameCard.Color.values();

        // Deck erstellen mit Doppelschleife
        for (GameCard.Color c : GameCard.Color.values()) {

            for (GameCard.Rank r : GameCard.Rank.values()) {

                GameCard card = new GameCard(c, r);
                System.out.println(card);
                cardsList.add(card);
            }

        }

        // Praktische Methoden
        GameCard.Rank rankTen = GameCard.Rank.valueOf("TEN");
        int indexInRankValuesArray = rankTen.ordinal();
        System.out.println("Index of rankTen: " + rankTen.ordinal());
        System.out.println("Points of rankTen: " + rankTen.getPoints());
        System.out.println("Points of rankTen: " + GameCard.Rank.TEN.getPoints());
    }

}
