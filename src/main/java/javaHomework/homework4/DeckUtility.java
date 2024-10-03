package javaHomework.homework4;

import java.util.Random;

public class DeckUtility {
    String[] deck;
    final String[] suits = {Suit.clubs.name(), Suit.diamonds.name(), Suit.hearts.name(),
            Suit.spades.name()};
    final String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen",
            "King", "Ace"};
    final int numberOfCards = suits.length * ranks.length;

    public void initializeDeck() {
        deck = new String[numberOfCards];
        for (int i = 0; i < ranks.length; i++) {
            for (int j = 0; j < suits.length; j++) {
                deck[suits.length * i + j] = ranks[i] + " " + suits[j];
            }
        }
    }

    public void shuffleDeck(String[] deck) {
        final Random random = new Random();
        for (int i = 0; i < numberOfCards; i++) {
            int card = i + (random.nextInt(numberOfCards - i));
            String temp = deck[card];
            deck[card] = deck[i];
            deck[i] = temp;
        }
    }
}