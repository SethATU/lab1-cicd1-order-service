package ie.atu.cicd1orderservice.service;

import ie.atu.cicd1orderservice.client.CatalogClient;
import ie.atu.cicd1orderservice.client.dto.ProductResponse;
import ie.atu.cicd1orderservice.model.Order;
import ie.atu.cicd1orderservice.repository.OrderRepo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepo repo;
    private final CatalogClient catalogClient;

    public OrderService(OrderRepo repo, CatalogClient catalogClient) {
        this.repo = repo;
        this.catalogClient = catalogClient;
    }

    public List<Order> getAll() {
        return repo.findAll();
    }

    public Order create(Order order) {
        order.setId(null);
        return repo.save(order);
    }

    public ProductResponse testCatalogConnection(Long productId) {
        return catalogClient.getProductById(productId);
    }

    public ProductResponse getProductForOrder(Long orderId) {
        Order order = repo.findById(orderId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));
        return catalogClient.getProductById(order.getProductId());
    }
}
