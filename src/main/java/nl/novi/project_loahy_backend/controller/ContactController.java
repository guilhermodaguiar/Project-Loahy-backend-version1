package nl.novi.project_loahy_backend.controller;

import nl.novi.project_loahy_backend.Dto.ContactDto;
import nl.novi.project_loahy_backend.Dto.CreateContactDto;
import nl.novi.project_loahy_backend.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path="/contacts")
public class ContactController {

    @Autowired
    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping()
    public ResponseEntity<List<ContactDto>> getAllContacts() {

        List<ContactDto> contactDtos = contactService.getAllContacts();

        return ResponseEntity.ok().body(contactDtos);
    }

    //later aanpassen
    @GetMapping(path = "/{id}")
    public ResponseEntity<ContactDto> getContact(@PathVariable("id") Long contactId) {

        ContactDto optionalContact = contactService.getContactById(contactId);


        return ResponseEntity.ok().body(optionalContact);

    }

    @PostMapping()
    public ResponseEntity<ContactDto> createRemark(@RequestBody CreateContactDto createContactDto) {

        final ContactDto createdContact = contactService.createRemark(createContactDto);

        final URI location = URI.create("/contacts/" + createdContact.getContactId());
        return ResponseEntity
                .created(location)
                .body(createdContact);
    }


    @DeleteMapping(path = "/{contact-id}")
    public ResponseEntity<ContactDto> deleteContact(@PathVariable("contact-id") Long contactId) {
        contactService.deleteContact(contactId);
        return ResponseEntity.noContent().build();
    }

}
