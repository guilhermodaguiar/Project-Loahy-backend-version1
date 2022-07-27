package nl.novi.project_loahy_backend.exeptions;

public class ProductExistException extends RuntimeException{
    public ProductExistException(String productName) {

        super(String.format("Product '%s' already exists", productName));
    }
}
