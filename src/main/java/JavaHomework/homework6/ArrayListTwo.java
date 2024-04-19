package JavaHomework.homework6;

import java.util.ArrayList;

public class ArrayListTwo {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Hello");
        strings.add("how");
        strings.add("are");
        strings.add("you");
        strings.add("today");

        ArrayListTwo arrayListTwo = new ArrayListTwo();
        System.out.println("Original list - " + strings);
        System.out.println("Size of each string - "
                + arrayListTwo.sizeOfEachString(strings));
    }
    public ArrayList<Integer>sizeOfEachString(ArrayList<String> strings){
        ArrayList<Integer>tempIntegers=new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {
            tempIntegers.add(strings.get(i).length());
        }
        return tempIntegers;
    }
}
