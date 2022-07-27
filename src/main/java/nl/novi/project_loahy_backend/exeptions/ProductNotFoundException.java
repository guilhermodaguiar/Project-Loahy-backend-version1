package nl.novi.project_loahy_backend.exeptions;

public class ProductNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public ProductNotFoundException(String productName) {

        super(String.format("Product '%s' does not exists", productName));
    }
}
