package nl.novi.project_loahy_backend.repository;

import nl.novi.project_loahy_backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
