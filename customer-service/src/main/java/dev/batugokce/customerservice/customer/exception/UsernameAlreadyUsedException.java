package dev.batugokce.customerservice.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "This username is already used.")
public class UsernameAlreadyUsedException extends RuntimeException {
    public UsernameAlreadyUsedException(String message) {
        super(message);
    }
}
