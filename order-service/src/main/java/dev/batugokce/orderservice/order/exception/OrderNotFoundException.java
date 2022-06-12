package dev.batugokce.orderservice.order.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY, reason = "Order not found.")
public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException() {
        super("Order could not be found.");
    }
}
