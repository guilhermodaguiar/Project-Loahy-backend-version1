package nl.novi.project_loahy_backend.repository;

import nl.novi.project_loahy_backend.model.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CostumerRepository extends JpaRepository<Costumer, Long> {
    Optional<Costumer> findUserByCostumerEmailIs(String costumerEmail);

}
