package pl.sda.javawwa31.exceptions;

public interface Valideable {
    boolean validate(String pswd) throws ValidationException;
}
