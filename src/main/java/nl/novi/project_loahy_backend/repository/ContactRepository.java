package nl.novi.project_loahy_backend.repository;

import nl.novi.project_loahy_backend.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContactRepository extends JpaRepository<Contact, Long> {
}
