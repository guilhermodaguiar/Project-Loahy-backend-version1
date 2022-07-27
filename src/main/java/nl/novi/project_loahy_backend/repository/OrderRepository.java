package nl.novi.project_loahy_backend.repository;

import nl.novi.project_loahy_backend.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
