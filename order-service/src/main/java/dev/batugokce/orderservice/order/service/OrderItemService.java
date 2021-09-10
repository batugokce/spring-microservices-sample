package dev.batugokce.orderservice.order.service;

import dev.batugokce.orderservice.order.entity.Order;
import dev.batugokce.orderservice.order.entity.OrderItem;
import dev.batugokce.orderservice.stock.entity.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderItemService {

    public void preparePurchases(List<Item> items, Order order, Map<Long, Integer> itemAmountMap) {
        Set<OrderItem> orderItems = items.stream()
                .map(item -> new OrderItem(order, item, itemAmountMap.get(item.getId())))
                .collect(Collectors.toSet());
        order.setOrderItems(orderItems);
    }

}
