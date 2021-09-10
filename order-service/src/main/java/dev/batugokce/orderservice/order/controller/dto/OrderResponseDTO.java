package dev.batugokce.orderservice.order.controller.dto;

import dev.batugokce.orderservice.order.entity.enums.State;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
public class OrderResponseDTO {
    private final Long id;
    private final Long customerId;
    private final State state;
    private final BigDecimal totalPrice;
    private final Set<ItemDTO> itemDTOS;
}
