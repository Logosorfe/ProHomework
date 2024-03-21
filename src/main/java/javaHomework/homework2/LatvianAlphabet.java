package javaHomework.homework2;

import java.util.Arrays;

public class LatvianAlphabet extends Alphabet {
    char[] letters = {'A', 'Ā', 'B', 'C', 'Č', 'D', 'E', 'Ē', 'F', 'G', 'Ģ', 'H', 'I', 'Ī', 'J', 'K'
            , 'Ķ', 'L', 'Ļ', 'M', 'N', 'Ņ', 'O', 'P', 'R', 'S', 'Š', 'T', 'U', 'Ū', 'V', 'Z', 'Ž'};

    @Override
    public void printAlphabet() {
        super.printAlphabet();
        System.out.println(Arrays.toString(letters));
    }
}
