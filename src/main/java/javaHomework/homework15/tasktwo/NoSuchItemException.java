package javaHomework.homework15.tasktwo;

public class NoSuchItemException extends RuntimeException{
    public NoSuchItemException(String message){
        super(message);
    }
}