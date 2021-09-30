package dev.batugokce.customerservice.customer.repository;

import dev.batugokce.customerservice.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    boolean existsByUsername(String username);

    Optional<Customer> findByUsername(String username);

    @Modifying
    @Query("UPDATE Customer c SET c.password=:password WHERE c.username=:username")
    void updatePassword(String password, String username);
}
