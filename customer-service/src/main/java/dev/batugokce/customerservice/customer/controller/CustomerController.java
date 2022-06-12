package dev.batugokce.customerservice.customer.controller;

import dev.batugokce.customerservice.customer.controller.dto.ChangePasswordDTO;
import dev.batugokce.customerservice.customer.controller.dto.CreateCustomerDTO;
import dev.batugokce.customerservice.customer.controller.dto.CustomerDTO;
import dev.batugokce.customerservice.customer.controller.mapper.CustomerMapper;
import dev.batugokce.customerservice.customer.entity.Customer;
import dev.batugokce.customerservice.customer.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
        Customer customer = customerMapper.toCustomer(createCustomerDTO);
        customerService.createCustomer(customer);
    }

    @GetMapping("/{id}")
    @Operation(summary = "finds a customer")
    public CustomerDTO getCustomer(@Parameter(description = "ID number of the customer to be searched")
                                       @PathVariable Long id) {
        Customer customer = customerService.getCustomer(id);
        return customerMapper.toCustomerDTO(customer);
    }

    @PutMapping
    @Operation(summary = "changes password of an existing customer")
    public void changePassword(@RequestBody ChangePasswordDTO changePasswordDTO) {
        customerService.changePassword(changePasswordDTO.getUsername(), changePasswordDTO.getOldPassword(), changePasswordDTO.getNewPassword());
    }

}
