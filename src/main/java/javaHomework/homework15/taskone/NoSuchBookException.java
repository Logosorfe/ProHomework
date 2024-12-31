package javaHomework.homework15.taskone;

public class NoSuchBookException extends RuntimeException{
    public NoSuchBookException(String message){
        super(message);
    }
}