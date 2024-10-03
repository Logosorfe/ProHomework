package javaHomework.homework4;

import java.util.Arrays;

public class Deal {
    public static void main(String[] args) {
        DeckUtility du = new DeckUtility();
        GameUtility gu = new GameUtility();

        gu.initializePlayers(du);
        System.out.println("Players are initialized");

        du.initializeDeck();
        System.out.println(Arrays.toString(du.deck));
        System.out.println("Deck is created");

        du.shuffleDeck(du.deck);
        System.out.println(Arrays.toString(du.deck));
        System.out.println("Deck is shuffled");

        System.out.println();
        System.out.println("Dealt cards are:");
        System.out.println();
        gu.printDealtCards(du);
    }
}
