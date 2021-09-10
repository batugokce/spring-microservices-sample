package dev.batugokce.orderservice.order.service;

import dev.batugokce.orderservice.customer.service.CustomerService;
import dev.batugokce.orderservice.order.entity.Order;
import dev.batugokce.orderservice.order.repository.OrderRepository;
import dev.batugokce.orderservice.stock.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerService customerService;
    private final OrderItemService orderItemService;
    private final ItemService itemService;

    @Transactional
    public void saveOrder(long customerId, Map<Long, Integer> itemAmountMap) {
        var customer = customerService.findById(customerId);

        if (!Objects.isNull(customer)) {
            var items = itemService.checkItemStock(itemAmountMap);
            var order = new Order(customer);
            order = orderRepository.save(order);

            orderItemService.preparePurchases(items, order, itemAmountMap);
            itemService.updateStock(items, itemAmountMap);
            order.calculatePrice();
            orderRepository.save(order);
        }
    }

    @Transactional
    public Order getOrder(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

}
