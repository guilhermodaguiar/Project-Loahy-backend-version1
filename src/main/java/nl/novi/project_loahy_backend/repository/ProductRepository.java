package nl.novi.project_loahy_backend.repository;

import nl.novi.project_loahy_backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findProductByProductNameIs(String productId);


    void deleteProductByProductId(Long productId);
}
