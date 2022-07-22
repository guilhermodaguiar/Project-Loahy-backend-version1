package nl.novi.project_loahy_backend.service;

import nl.novi.project_loahy_backend.Dto.ContactDto;
import nl.novi.project_loahy_backend.exeptions.RecordNotFoundException;
import nl.novi.project_loahy_backend.model.Contact;
import nl.novi.project_loahy_backend.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public List<ContactDto> getContacts() {
        List<ContactDto> collection = new ArrayList<>();
        List<Contact> list = contactRepository.findAll();
        for (Contact contact : list) {
            collection.add(fromContact(contact));
        }
        return collection;
    }

    public ContactDto getContact(String contactName) {
        new ContactDto();
        ContactDto dto;
        Optional<Contact> contact = contactRepository.findById(contactName);
        if (contact.isPresent()){
            dto = fromUser(contact.get());
        }else {
            throw new UsernameNotFoundException(contactName);
        }
        return dto;
    }



    public void createContact(ContactDto contactDto) {


    }

    public void deleteContact(String contactName) {
        userRepository.deleteById(contactName);
    }

    public void updateContact(String username, ContactDto newUser) {
        if (!userRepository.existsById(username)) throw new RecordNotFoundException();
        User user = userRepository.findById(username).get();
        user.setPassword(newUser.getPassword());
        userRepository.save(user);
    }
}
