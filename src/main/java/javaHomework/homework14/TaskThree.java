package javaHomework.homework14;

import java.io.File;
import java.lang.reflect.Array;
import java.util.Arrays;

public class TaskThree {
    public static void main(String[] args) {
        String path = "C:/Users/Logosorfe/IdeaProjects/ProHomework/src/main/java/JavaHomework/homework14";

        File directory = new File(path + "/directory");
        directory.mkdir();

        File subdirectory = new File(path + "/directory" + "/subdirectory");
        subdirectory.mkdir();

        deleteDirectories(path);
    }

    public static void deleteDirectories(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        for (File currentFile : files) {
            if (currentFile.isDirectory()) {
                deleteDirectories(currentFile.getAbsolutePath());
                currentFile.delete();
            }/** Забыл поставить эти скобки и стёр всё в папке homework14 :))) */
        }
    }
}