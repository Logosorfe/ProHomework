package JavaHomework.homework14;

import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

public class TaskOne {
    public static void main(String[] args) throws Exception {
        String file = "C:/Users/logos/IdeaProjects/ProHomework/src/main/java/JavaHomework/homework14/testfile.txt";
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        String text = "This is my first experience when I myself work with IO API. I can do everything!";

        byte[] textToByte = text.getBytes(StandardCharsets.UTF_8);
        for(byte unit : textToByte) fileOutputStream.write(unit);
        fileOutputStream.close();
    }
}
