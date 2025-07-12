package fos.fos.repository;

import java.util.*;

import fos.fos.model.Order;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {
    private final Map<Long, Order> orderMap = new HashMap<>();
    private long counter = 1;

    public Long save(Order order) {
        order.setId(counter);
        orderMap.put(counter, order);
        return counter++;
    }

    public Optional<Order> findById(Long id) {
        return Optional.ofNullable(orderMap.get(id));
    }

    public List<Order> findAll() {
        return new ArrayList<>(orderMap.values());
    }

}
