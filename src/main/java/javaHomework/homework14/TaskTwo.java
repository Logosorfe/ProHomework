package javaHomework.homework14;

import java.io.File;

public class TaskTwo {
    public static void main(String[] args) {
        String path = "C:/Users/Logosorfe/IdeaProjects/ProHomework/src/main/java/JavaHomework/homework14/testfile.txt";
/** Для меня нет проблемы создать физический файл на рабочем столе, просто так удобнее, как логическое продолжение первого задания*/
        File file = new File(path);

        System.out.println("Does file exists - " + file.exists());

        System.out.print("Has file just been deleted - " + file.delete());
    }
}