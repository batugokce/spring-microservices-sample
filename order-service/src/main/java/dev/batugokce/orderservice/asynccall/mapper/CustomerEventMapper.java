package dev.batugokce.orderservice.asynccall.mapper;

import dev.batugokce.orderservice.asynccall.event.CustomerCreationEvent;
import dev.batugokce.orderservice.customer.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CustomerEventMapper {

    @Mappings({
            @Mapping(target = "id", source = "customerId")
    })
    Customer toCustomer(CustomerCreationEvent customerCreationEvent);

}
