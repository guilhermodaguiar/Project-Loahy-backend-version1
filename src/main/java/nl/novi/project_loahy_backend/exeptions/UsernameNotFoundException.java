package nl.novi.project_loahy_backend.exeptions;

public class UsernameNotFoundException extends RuntimeException {

    public UsernameNotFoundException(String userName) {

        super(String.format("Cannot find '%s' " + userName));
    }
}