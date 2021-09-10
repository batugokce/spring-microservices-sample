package dev.batugokce.orderservice.order.repository;

import dev.batugokce.orderservice.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    /*private static final Map<Long, Order> books = new HashMap<>();

    public Optional<Order> findById(Long bookId) {
        return Optional.ofNullable(books.get(bookId));
    }

    public void save(Order order) {
        books.put(order.getId(), order);
    }

    public void delete(Long bookId) {
        books.remove(bookId);
    }*/

}
