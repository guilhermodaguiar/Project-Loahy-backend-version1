package nl.novi.project_loahy_backend.repository;

import nl.novi.project_loahy_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUserEmailIs(String userName);

}
