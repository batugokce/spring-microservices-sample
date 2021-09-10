package dev.batugokce.orderservice.order.entity;

import dev.batugokce.orderservice.common.BaseEntity;
import dev.batugokce.orderservice.stock.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    @Column(name = "AMOUNT")
    private int amount;

    public BigDecimal calculatePrice() {
        return item.getPrice().multiply(BigDecimal.valueOf(amount));
    }
}
