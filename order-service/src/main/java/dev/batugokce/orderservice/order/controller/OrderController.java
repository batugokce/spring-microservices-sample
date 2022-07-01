package dev.batugokce.orderservice.order.controller;

import dev.batugokce.orderservice.order.controller.dto.CreateOrderDTO;
import dev.batugokce.orderservice.order.controller.dto.OrderResponseDTO;
import dev.batugokce.orderservice.order.controller.mapper.OrderMapper;
import dev.batugokce.orderservice.order.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
@Tag(name = "Order Controller", description = "responsible for order management")
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @PostMapping
    @Operation(summary = "creates a new order")
    public OrderResponseDTO createOrder(@RequestBody CreateOrderDTO createOrderDTO) {
        var customerId = createOrderDTO.getCustomerId();
        var itemAmountMap = createOrderDTO.getItemAmountMap();
        var createdOrder = orderService.saveOrder(customerId, itemAmountMap);
        return orderMapper.orderToResponseDTO(createdOrder);
    }

    @GetMapping
    @Operation(summary = "finds an order")
    public OrderResponseDTO getOrder(@Parameter(description = "ID number of the order to be searched")
                                         @RequestParam Long id) {
        var order = orderService.getOrder(id);
        return orderMapper.orderToResponseDTO(order);
    }

}
