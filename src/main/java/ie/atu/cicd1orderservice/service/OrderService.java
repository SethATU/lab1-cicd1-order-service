package ie.atu.cicd1orderservice.service;

import ie.atu.cicd1orderservice.model.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final List<Order> orders = new ArrayList<>();
    private long nextId = 1;
    public List<Order> getAll() {
        return orders;
    }
    public Order create(Order order) {
        order.setId(nextId++);
        orders.add(order);
        return order;
    }
}
