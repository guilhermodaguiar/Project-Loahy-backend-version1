package nl.novi.project_loahy_backend.controller;

import nl.novi.project_loahy_backend.Dto.ContactDto;
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

    @GetMapping(path = "")
    public ResponseEntity<List<ContactDto>> getContacts() {
        List<ContactDto> contactDtos = contactService.getContacts();

        return ResponseEntity.ok().body(contactDtos);
    }

    @GetMapping(path = "/{contact-name}")
    public ResponseEntity<ContactDto> getUser(@PathVariable("contact-name") String contactname) {

        ContactDto optionalContact = contactService.getContact(contactname);


        return ResponseEntity.ok().body(optionalContact);

    }

    @PostMapping()
    public ResponseEntity<ContactDto> createContact(@RequestBody CreateContactDto createContactDto) {

        final ContactDto createdContact = contactService.createContact(createContactDto);

        return ResponseEntity.ok().(createdContact);
    }


    @PutMapping(value = "/{contact-name}")
    public ResponseEntity<ContactDto> updateContact(@PathVariable("contact-name") String contactName, @RequestBody ContactDto contactDto) {

        contactService.updateContact(contactName, contactDto);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "contact-name")
    public ResponseEntity<ContactDto> deleteContact(@PathVariable("contact-name") String contactName) {
        contactService.deleteContact(contactName);
        return ResponseEntity.noContent().build();
    }

}
