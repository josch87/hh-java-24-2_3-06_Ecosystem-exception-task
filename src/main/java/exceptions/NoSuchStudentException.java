package exceptions;

import java.util.NoSuchElementException;

public class NoSuchStudentException extends NoSuchElementException {
    public NoSuchStudentException() { super();}

    public NoSuchStudentException(String message) {
        super(message);
    }
}
