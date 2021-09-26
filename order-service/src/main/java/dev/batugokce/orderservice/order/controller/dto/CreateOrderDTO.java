package dev.batugokce.orderservice.order.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderDTO {

    @NotNull
    @Schema(description = "id of the customer", example = "13", required = true)
    private Long customerId;

    @NotNull
    @Schema(description = "id and ordered amount of items", required = true)
    private Map<Long, Integer> itemAmountMap;
}
