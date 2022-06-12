package dev.batugokce.customerservice.asynccall.event;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CustomerCreationEvent {
    private Long customerId;
}
