package dev.batugokce.customerservice.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY, reason = "Incorrect password.")
public class IncorrectPasswordException extends RuntimeException {
    public IncorrectPasswordException() {
        super("Your password is not correct.");
    }
}
