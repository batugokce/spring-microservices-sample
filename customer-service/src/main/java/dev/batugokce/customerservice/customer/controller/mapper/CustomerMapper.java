package dev.batugokce.customerservice.customer.controller.mapper;

import dev.batugokce.customerservice.customer.controller.dto.CreateCustomerDTO;
import dev.batugokce.customerservice.customer.controller.dto.CustomerDTO;
import dev.batugokce.customerservice.customer.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer toCustomer(CreateCustomerDTO createCustomerDTO);

    CustomerDTO toCustomerDTO(Customer customer);
}
