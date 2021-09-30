package dev.batugokce.customerservice.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY, reason = "User could not be found.")
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("User could not be found.");
    }
}
