package dev.batugokce.orderservice.order.controller;

import dev.batugokce.orderservice.order.controller.dto.CreateOrderDTO;
import dev.batugokce.orderservice.order.controller.dto.OrderResponseDTO;
import dev.batugokce.orderservice.order.entity.Order;
import dev.batugokce.orderservice.order.mapper.OrderMapper;
import dev.batugokce.orderservice.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @PostMapping
    public void order(@RequestBody CreateOrderDTO createOrderDTO) {
        long customerId = createOrderDTO.getCustomerId();
        var itemAmountMap = createOrderDTO.getItemAmountMap();
        orderService.saveOrder(customerId, itemAmountMap);
    }

    @GetMapping
    public OrderResponseDTO getOrder(@RequestParam Long id) {
        Order order = orderService.getOrder(id);
        return orderMapper.orderToResponseDTO(order);
    }

}
