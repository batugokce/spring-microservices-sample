package dev.batugokce.orderservice.order.controller.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ItemDTO {
    private final Long id;
    private final BigDecimal pricePerItem;
    private final int amount;
}
