package nl.novi.project_loahy_backend.repository;

import nl.novi.project_loahy_backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findProductByProductNameIs(String productName);

    List<Product> findByProductId(Long productId);
    void deleteProductByProductId(Long productId);
}
