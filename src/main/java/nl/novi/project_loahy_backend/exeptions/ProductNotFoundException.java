package nl.novi.project_loahy_backend.exeptions;

public class ProductNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public ProductNotFoundException(Long productId) {

        super(String.format("Product with Id '%s' does not exists", productId));
    }
}
