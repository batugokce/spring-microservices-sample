package dev.batugokce.orderservice.stock.entity;

import dev.batugokce.orderservice.common.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Item extends BaseEntity {

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "STOCK")
    private int stock;
}
