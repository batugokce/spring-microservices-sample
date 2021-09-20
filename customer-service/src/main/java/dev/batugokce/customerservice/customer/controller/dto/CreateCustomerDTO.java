package dev.batugokce.customerservice.customer.controller.dto;

import dev.batugokce.customerservice.customer.enums.Gender;
import lombok.Value;

import java.time.LocalDate;

@Value
public class CreateCustomerDTO {
    String username;
    String password;
    String name;
    String surname;
    String emailAddress;
    String telephoneNumber;
    LocalDate birthDay;
    Gender gender;
}
