package dev.batugokce.orderservice.order.entity;

import dev.batugokce.orderservice.common.AuditableEntity;
import dev.batugokce.orderservice.customer.entity.Customer;
import dev.batugokce.orderservice.order.entity.enums.State;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
@Table(name = "ORDERS")
@AllArgsConstructor
@NoArgsConstructor
public class Order extends AuditableEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER")
    private Customer customer;

    @Column(name = "STATE")
    private State state = State.CREATED;

    @Column(name = "TOTAL_PRICE")
    private BigDecimal totalPrice;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderItem> orderItems = new HashSet<>();

    public Order(Customer customer) {
        this.customer = customer;
        this.totalPrice = BigDecimal.ZERO;
    }

    public void calculatePrice() {
        this.totalPrice = orderItems.stream()
                .map(OrderItem::calculatePrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
