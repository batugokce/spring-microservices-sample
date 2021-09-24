package dev.batugokce.orderservice.customer.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Customer {

    @Id
    @Column(name = "ID")
    private Long id;

}
