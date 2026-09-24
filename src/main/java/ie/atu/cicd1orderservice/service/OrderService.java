package ie.atu.cicd1orderservice.service;

import ie.atu.cicd1orderservice.model.Order;
import ie.atu.cicd1orderservice.repository.OrderRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepo repo;

    public OrderService(OrderRepo repo) {
        this.repo = repo;
    }

    public List<Order> getAll() {
        return repo.findAll();
    }

    public Order create(Order order) {
        order.setId(null);
        return repo.save(order);
    }
}
