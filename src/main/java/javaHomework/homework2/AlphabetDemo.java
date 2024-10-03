package javaHomework.homework2;

public class AlphabetDemo {
    public static void main(String[] args) {
        RussianAlphabet russian = new RussianAlphabet();
        EnglishAlphabet english = new EnglishAlphabet();
        LatvianAlphabet latvian = new LatvianAlphabet();

        russian.setName("Russian");
        russian.printAlphabet();
        english.setName("English");
        english.printAlphabet();
        latvian.setName("Latvian");
        latvian.printAlphabet();

        System.out.println();

        Alphabet[] alphabets = {russian, english, latvian};
        printAllInfo(alphabets);
    }
    public static void printAllInfo(Alphabet[] alphabets) {
        for (Alphabet alphabet : alphabets) {
            alphabet.printAlphabet();
        }
    }
}
