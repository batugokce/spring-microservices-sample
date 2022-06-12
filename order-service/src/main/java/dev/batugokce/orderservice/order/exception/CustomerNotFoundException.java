package dev.batugokce.orderservice.order.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY, reason = "Customer not found.")
public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException() {
        super("Customer could not be found.");
    }
}
