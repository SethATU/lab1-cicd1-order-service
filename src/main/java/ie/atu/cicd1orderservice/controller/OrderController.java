package ie.atu.cicd1orderservice.controller;

import ie.atu.cicd1orderservice.model.Order;
import ie.atu.cicd1orderservice.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService service;
    public OrderController(OrderService service) { this.service = service; }

    @GetMapping
    public List<Order> getAll() { return service.getAll(); }

    @PostMapping
    public Order create(@RequestBody Order order) { return service.create(order); }
}
