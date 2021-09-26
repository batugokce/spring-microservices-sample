package dev.batugokce.customerservice.customer.controller;

import dev.batugokce.customerservice.customer.controller.dto.CreateCustomerDTO;
import dev.batugokce.customerservice.customer.entity.Customer;
import dev.batugokce.customerservice.customer.mapper.CustomerMapper;
import dev.batugokce.customerservice.customer.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
@Tag(name = "Customer Controller", description = "responsible for customer account management")
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    @PostMapping
    @Operation(summary = "creates a customer account")
    public void createCustomer(@RequestBody CreateCustomerDTO createCustomerDTO) {
        Customer customer = customerMapper.dtoToCustomer(createCustomerDTO);
        customerService.createCustomer(customer);
    }

}
