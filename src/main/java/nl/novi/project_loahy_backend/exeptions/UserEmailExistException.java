package nl.novi.project_loahy_backend.exeptions;

public class UserEmailExistException extends RuntimeException{
    public UserEmailExistException(String userEmail) {

        super(String.format("Username with email '%s' already exists", userEmail));
    }
}
