package nl.novi.project_loahy_backend.repository;

import nl.novi.project_loahy_backend.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BrandRepository extends JpaRepository<Brand, String> {
}
