package dev.batugokce.orderservice.order.controller.mapper;

import dev.batugokce.orderservice.order.controller.dto.ItemDTO;
import dev.batugokce.orderservice.order.controller.dto.OrderResponseDTO;
import dev.batugokce.orderservice.order.entity.Order;
import dev.batugokce.orderservice.order.entity.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "customerId", source = "customer.id"),
            @Mapping(target = "state", source = "state"),
            @Mapping(target = "totalPrice", source = "totalPrice"),
            @Mapping(target = "itemDTOS", source = "orderItems", qualifiedByName = "itemDTOSet")
    })
    OrderResponseDTO orderToResponseDTO(Order order);

    @Named("itemDTOSet")
    static Set<ItemDTO> toItemDTOSet(Set<OrderItem> orderItems) {
        return orderItems
                .stream()
                .map(orderItem -> new ItemDTO(orderItem.getItem().getId(), orderItem.getItem().getPrice(), orderItem.getAmount()))
                .collect(Collectors.toSet());
    }
}
