package nl.novi.project_loahy_backend.service;

import nl.novi.project_loahy_backend.Dto.ContactDto;
import nl.novi.project_loahy_backend.Dto.CreateContactDto;
import nl.novi.project_loahy_backend.model.Contact;
import nl.novi.project_loahy_backend.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<ContactDto> getAllContacts(){
        return null;
    }

    //later aanpassen
    public ContactDto getContactById(Long contactId) {
        return null;

    }





    public ContactDto createContact(CreateContactDto createContactDto) {

        Contact contact = new Contact();
        contact.setContactName(createContactDto.getContactName());
        contact.setContactEmail(createContactDto.getContactEmail());
        contact.setContactOrganisation(createContactDto.getContactOrganisation());
        contact.setContactPhone(createContactDto.getContactPhone());
        contact.setRemark(createContactDto.getRemark());

        final Contact savedContact = contactRepository.save(contact);

        ContactDto contactDto = new ContactDto();
        contactDto.setContactId(savedContact.getContactId());
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


}
