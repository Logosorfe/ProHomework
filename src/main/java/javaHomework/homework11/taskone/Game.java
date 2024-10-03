package javaHomework.homework11.taskone;

import java.util.Stack;

public class Game {
    public static void main(String[] args) {
        DeckUtility du = new DeckUtility();
        Stack<String> solitaire = new Stack<>();
        int counter = 1;
        while (du.deck.size() > 4) {
            System.out.println("After shuffle number " + counter);
            for (int i = 0; i < du.deck.size(); i++) {
                if (solitaire.isEmpty()) {
                    solitaire.push(du.deck.get(i));
                } else if (du.deck.get(i).charAt(du.deck.get(i).length() - 2) ==
                        solitaire.peek().charAt(solitaire.peek().length() - 2)) {
                    solitaire.pop();
                } else {
                    solitaire.push(du.deck.get(i));
                }
            }
            du.deck.clear();
            System.out.println(solitaire);
            for (String temp : solitaire) du.deck.add(temp);
            du.shuffleDeck();
            solitaire.removeAllElements();
            counter++;
        }
    }
}
