package nl.novi.project_loahy_backend.exeptions;

public class CostumerEmailExistException extends RuntimeException{
    public CostumerEmailExistException(String costumerEmail) {

        super(String.format("Costumer with email '%s' already exists", costumerEmail));
    }
}
