package uaslp.objetos.list.exception;

public class NotSuchElementException extends RuntimeException{
    public NotSuchElementException() {
        super("Null values are not allowed");
    }
}
