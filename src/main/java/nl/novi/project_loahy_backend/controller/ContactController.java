package nl.novi.project_loahy_backend.controller;

import nl.novi.project_loahy_backend.Dto.ContactDto;
import nl.novi.project_loahy_backend.Dto.CreateContactDto;
import nl.novi.project_loahy_backend.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/contactus")
public class ContactController {

    @Autowired
    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping()
    public ResponseEntity<List<ContactDto>> getContacts() {

        List<ContactDto> contactDtos = contactService.getContacts();

        return ResponseEntity.ok().body(contactDtos);
    }

    //later aanpassen
    @GetMapping(path = "/{contact-name}")
    public ResponseEntity<ContactDto> getContact(@PathVariable("contact-name") Long contactNumber) {

        ContactDto optionalContact = contactService.getContact(contactNumber);


        return ResponseEntity.ok().body(optionalContact);

    }

    @PostMapping()
    public ResponseEntity<ContactDto> createContact(@RequestBody CreateContactDto createContactDto) {

        final ContactDto createdContact = contactService.createContact(createContactDto);

        return ResponseEntity.ok(createdContact);
    }


    @DeleteMapping(path = "/{contact-id}")
    public ResponseEntity<ContactDto> deleteContact(@PathVariable("contact-id") Long contactNumber) {
        contactService.deleteContact(contactNumber);
        return ResponseEntity.noContent().build();
    }

}
