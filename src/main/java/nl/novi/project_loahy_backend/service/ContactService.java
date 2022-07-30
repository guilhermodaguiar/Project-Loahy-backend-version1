package nl.novi.project_loahy_backend.service;

import nl.novi.project_loahy_backend.Dto.ContactDto;
import nl.novi.project_loahy_backend.Dto.CreateContactDto;
import nl.novi.project_loahy_backend.exeptions.ContactNotFoundException;
import nl.novi.project_loahy_backend.model.Contact;
import nl.novi.project_loahy_backend.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<ContactDto> getAllContacts() {
        List<ContactDto> collection = new ArrayList<>();
        List<Contact> list = contactRepository.findAll();
        for (Contact contact : list) {
            collection.add(fromContact(contact));
        }
        return collection;
    }


    public ContactDto getContactById(Long contactId) {
        new ContactDto();
        ContactDto contactDto;
        Optional<Contact> contact = contactRepository.findById(contactId);
        if (contact.isPresent()) {
            contactDto = fromContact(contact.get());
        } else {
            throw new ContactNotFoundException(contactId);
        }
        return contactDto;
    }


//even video kijken of setcontact ID erin hoort.
    public ContactDto createRemark(CreateContactDto createContactDto) {

        Contact contact = new Contact();
        contact.setContactName(createContactDto.getContactName());
        contact.setContactEmail(createContactDto.getContactEmail());
        contact.setContactOrganisation(createContactDto.getContactOrganisation());
        contact.setContactPhone(createContactDto.getContactPhone());
        contact.setRemark(createContactDto.getRemark());

        final Contact savedContact = contactRepository.save(contact);

        ContactDto contactDto = new ContactDto();
        contactDto.setContactName(savedContact.getContactName());
        contactDto.setContactEmail(savedContact.getContactEmail());
        contactDto.setContactOrganisation(savedContact.getContactOrganisation());
        contactDto.setContactPhone(savedContact.getContactPhone());
        contactDto.setRemark(savedContact.getRemark());

        return contactDto;
    }


    public void deleteContact(Long contactId) {
        contactRepository.deleteById(contactId);
    }


    public static ContactDto fromContact(Contact contact) {

        var contactDto = new ContactDto();

        contactDto.setContactId(contact.getContactId());
        contactDto.setContactName(contact.getContactName());
        contactDto.setContactEmail(contact.getContactEmail());
        contactDto.setContactOrganisation(contact.getContactOrganisation());
        contactDto.setContactPhone(contact.getContactPhone());
        contactDto.setRemark(contact.getRemark());

        return contactDto;
    }
}
