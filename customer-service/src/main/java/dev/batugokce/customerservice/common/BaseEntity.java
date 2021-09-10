package dev.batugokce.customerservice.common;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
