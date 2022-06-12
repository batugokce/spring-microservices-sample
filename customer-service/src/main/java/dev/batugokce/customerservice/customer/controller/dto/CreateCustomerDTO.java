package dev.batugokce.customerservice.customer.controller.dto;

import dev.batugokce.customerservice.customer.entity.enums.Gender;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Value
public class CreateCustomerDTO {
    @NotBlank
    @Schema(description = "username for the customer account", example = "jack123", required = true)
    String username;

    @NotNull
    @Schema(description = "password for the customer account", example = "qA1?c5nCQ", required = true)
    String password;

    @NotNull
    @Schema(description = "customer's name", example = "Jack", required = true)
    String name;

    @NotNull
    @Schema(description = "customer's surname", example = "Grealish", required = true)
    String surname;

    @Email
    @Schema(description = "email address of customer", example = "user@gmail.com", required = true)
    String emailAddress;

    @Schema(description = "telephone number of customer", example = "05395212233")
    String telephoneNumber;

    @Schema(description = "birth day of customer", example = "1998-09-17")
    LocalDate birthDay;

    @Schema(description = "gender of customer", example = "MALE")
    Gender gender;
}
