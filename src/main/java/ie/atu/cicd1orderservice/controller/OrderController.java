package ie.atu.cicd1orderservice.controller;

import ie.atu.cicd1orderservice.client.dto.ProductResponse;
import ie.atu.cicd1orderservice.model.Order;
import ie.atu.cicd1orderservice.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService service;
    private final OrderService orderService;

    public OrderController(OrderService service, OrderService orderService) { this.service = service;
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getAll() { return service.getAll(); }

    @PostMapping
    public Order create(@RequestBody Order order) { return service.create(order); }

    @GetMapping("/test-catalog/{productId}")
    public ProductResponse testCatalogConnection(@PathVariable Long productId) {
        return service.testCatalogConnection(productId);
    }

    @GetMapping("/{orderId}/product")
    public ProductResponse getProductById(@PathVariable("orderId") Long orderId) {
        return orderService.getProductForOrder(orderId);
    }
}
