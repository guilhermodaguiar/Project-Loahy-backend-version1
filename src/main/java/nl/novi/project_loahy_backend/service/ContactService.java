package nl.novi.project_loahy_backend.service;

import nl.novi.project_loahy_backend.Dto.ContactDto;
import nl.novi.project_loahy_backend.Dto.CreateContactDto;
import nl.novi.project_loahy_backend.exeptions.RecordNotFoundException;
import nl.novi.project_loahy_backend.model.Contact;
import nl.novi.project_loahy_backend.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<ContactDto> getContacts(){
        return contactRepository.findAll();
    }
    //later aanpassen
    public ContactDto getContact(Long contactNumber) {

        Optional<Contact> contact = contactRepository.findById(contactNumber);

        if(contact.isPresent()) {

            return contact.get();

        } else {

            throw new RecordNotFoundException("Contact does not exist");

        }

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
        contactDto.setContactNumber(savedContact.getContactNumber());
        contactDto.setContactName(savedContact.getContactName());
        contactDto.setContactEmail(savedContact.getContactEmail());
        contactDto.setContactOrganisation(savedContact.getContactOrganisation());
        contactDto.setContactPhone(savedContact.getContactPhone());
        contactDto.setRemark(savedContact.getRemark());

        return contactDto;
    }


    public void deleteContact(Long contactNumber) {
        contactRepository.deleteById(contactNumber);
    }


}
