package dev.batugokce.customerservice.asynccall.event;

import dev.batugokce.customerservice.customer.entity.Customer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomerCreationEvent {
    private Long customerId;

    public CustomerCreationEvent(Customer customer) {
        this.customerId = customer.getId();
    }
}
