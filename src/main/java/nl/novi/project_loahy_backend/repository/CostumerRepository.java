package nl.novi.project_loahy_backend.repository;

import nl.novi.project_loahy_backend.model.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;



public interface CostumerRepository extends JpaRepository<Costumer, Long> {
    Optional<Costumer> findUserByCostumerEmailIs(String costumerEmail);

}
