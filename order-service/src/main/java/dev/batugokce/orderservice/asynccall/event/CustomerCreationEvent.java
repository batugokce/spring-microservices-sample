package dev.batugokce.orderservice.asynccall.event;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomerCreationEvent {
    private Long customerId;
}
