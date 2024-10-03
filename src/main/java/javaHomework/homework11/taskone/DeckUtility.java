package javaHomework.homework11.taskone;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DeckUtility {
    List<String> deck;
    final String[] suits = {Suit.clubs.name(), Suit.diamonds.name(), Suit.hearts.name(),
            Suit.spades.name()};
    final String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen",
            "King", "Ace"};
    final int numberOfCards = suits.length * ranks.length;

    public DeckUtility() {
        initializeDeck();
        shuffleDeck();
    }

    public void initializeDeck() {
        deck = new ArrayList<>();
        for (int i = 0; i < ranks.length; i++) {
            for (int j = 0; j < suits.length; j++) {
                deck.add(ranks[i] + " of " + suits[j]);
            }
        }
    }

    public void shuffleDeck() {
        final Random random = new Random();
        for (int i = 0; i < deck.size(); i++) {
            int card = i + (random.nextInt(deck.size() - i));
            String temp = deck.get(card);
            deck.set(card,deck.get(i));
            deck.set(i,temp);
        }
    }
}
