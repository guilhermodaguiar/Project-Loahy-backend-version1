package nl.novi.project_loahy_backend.exeptions;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(Long OrderNumber) {

        super(String.format("Order '%s' not found", OrderNumber));
    }
}
