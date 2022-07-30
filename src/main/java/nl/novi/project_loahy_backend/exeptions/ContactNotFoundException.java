package nl.novi.project_loahy_backend.exeptions;

public class ContactNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;


    public ContactNotFoundException(Long contactId) {

        super(String.format("Contact '%s' does not exists", contactId));
    }

}

