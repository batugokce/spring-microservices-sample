package dev.batugokce.customerservice.customer.mapper;

import dev.batugokce.customerservice.customer.controller.dto.CreateCustomerDTO;
import dev.batugokce.customerservice.customer.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer dtoToCustomer(CreateCustomerDTO createCustomerDTO);
}
