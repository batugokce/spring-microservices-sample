package dev.batugokce.customerservice.customer.entity;

import dev.batugokce.customerservice.common.AuditableEntity;
import dev.batugokce.customerservice.customer.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends AuditableEntity {

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;

    @Column(name = "TELEPHONE_NUMBER")
    private String telephoneNumber;

    @Column(name = "BIRTH_DAY")
    private LocalDate birthDay;

    @Column(name = "GENDER")
    private Gender gender;

}
