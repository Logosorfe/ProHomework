package javaHomework.homework4;

import java.util.Scanner;

public class GameUtility {
    final int cardsForPlayer = 5;
    int players;

    public void initializePlayers(DeckUtility deckUtility) {
        final Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the number of players: ");
            if (sc.hasNextInt()) {
                players = sc.nextInt();
                if (cardsForPlayer * players <= deckUtility.numberOfCards
                        && cardsForPlayer * players > 0) /**здесь отсутствовала
                && cardsForPlayer * players > 0 */
                {
                    break;
                } else {
                    if (players == 0) {
                        System.out.println("The game has been terminated.");
                        break;
                    } else if (players < 0) {
                        System.out.println("The number of players cannot be less than 0");
                    } else {
                        System.out.println("Too many players!");
                    }
                }
            } else {
                System.out.println("You have not entered a number, or your number is too " +
                        "large!");
                sc.next();/** без этого всё летело в цикл */
            }
        }
    }

    public void printDealtCards(DeckUtility deckUtility) {
        for (int i = 0; i < players * cardsForPlayer; i++) {
            System.out.println(deckUtility.deck[i]);

            if (i % cardsForPlayer == cardsForPlayer - 1)
                System.out.println();
        }
    }
}
