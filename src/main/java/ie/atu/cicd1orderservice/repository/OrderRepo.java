package ie.atu.cicd1orderservice.repository;

import ie.atu.cicd1orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo
        extends JpaRepository<Order, Long> {
}
