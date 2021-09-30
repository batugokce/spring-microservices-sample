package dev.batugokce.customerservice.customer.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

@Value
public class CustomerDTO {
    @Schema(description = "username for the customer account", example = "jack123", required = true)
    String username;

    @Schema(description = "customer's name", example = "Jack", required = true)
    String name;

    @Schema(description = "customer's surname", example = "Grealish", required = true)
    String surname;

    @Schema(description = "email address of customer", example = "user@gmail.com", required = true)
    String emailAddress;
}
