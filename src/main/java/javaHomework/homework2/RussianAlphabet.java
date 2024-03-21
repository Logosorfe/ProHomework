package javaHomework.homework2;

import java.util.Arrays;

public class RussianAlphabet extends Alphabet{
    char []letters = {'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О'
            , 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я'};
    @Override
    public void printAlphabet() {
        super.printAlphabet();
        System.out.println(Arrays.toString(letters));
    }
}
