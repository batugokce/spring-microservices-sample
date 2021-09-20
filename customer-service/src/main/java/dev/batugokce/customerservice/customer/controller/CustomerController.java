package dev.batugokce.customerservice.customer.controller;

import dev.batugokce.customerservice.asynccall.service.PublishService;
import dev.batugokce.customerservice.customer.controller.dto.CreateCustomerDTO;
import dev.batugokce.customerservice.customer.entity.Customer;
import dev.batugokce.customerservice.customer.mapper.CustomerMapper;
import dev.batugokce.customerservice.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    @PostMapping
    public void createCustomer(@RequestBody CreateCustomerDTO createCustomerDTO) {
        Customer customer = customerMapper.dtoToCustomer(createCustomerDTO);
        customerService.createCustomer(customer);
    }

}
