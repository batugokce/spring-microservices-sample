package dev.batugokce.customerservice.customer.repository;

import dev.batugokce.customerservice.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    boolean existsByUsername(String username);
}
