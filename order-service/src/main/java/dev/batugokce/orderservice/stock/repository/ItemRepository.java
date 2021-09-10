package dev.batugokce.orderservice.stock.repository;

import dev.batugokce.orderservice.stock.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
