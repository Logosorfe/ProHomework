package javaHomework.homework2;

import java.util.Arrays;

public class EnglishAlphabet extends Alphabet {
    char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    @Override
    public void printAlphabet() {
        super.printAlphabet();
        System.out.println(Arrays.toString(letters));
    }
}
