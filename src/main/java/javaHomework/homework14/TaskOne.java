package javaHomework.homework14;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

public class TaskOne {
    public static void main(String[] args) {
        String file = "C:/Users/Logosorfe/IdeaProjects/ProHomework/src/main/java/JavaHomework/homework14/testfile.txt";
        String text = "This is my first experience when I myself work with IO API. I can do everything!";

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] textToByte = text.getBytes(StandardCharsets.UTF_8);
            for (byte unit : textToByte) fileOutputStream.write(unit);
            fileOutputStream.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}