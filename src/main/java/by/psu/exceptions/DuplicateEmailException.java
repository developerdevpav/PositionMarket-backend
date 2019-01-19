package by.psu.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DuplicateEmailException extends RuntimeException {
    public DuplicateEmailException() {
    }
    private int codeError = HttpStatus.BAD_REQUEST.value();

    public DuplicateEmailException(String message) {
        super(message);
    }
}
