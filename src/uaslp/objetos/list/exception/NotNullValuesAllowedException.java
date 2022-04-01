package uaslp.objetos.list.exception;

public class NotNullValuesAllowedException extends Exception{
    public NotNullValuesAllowedException(){
        super("No se aceptan valores NULL");
    }
}