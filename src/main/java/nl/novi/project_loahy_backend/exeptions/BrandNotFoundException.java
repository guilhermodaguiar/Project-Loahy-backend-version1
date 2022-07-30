package nl.novi.project_loahy_backend.exeptions;

public class BrandNotFoundException extends RuntimeException{


    public BrandNotFoundException(String brandTitle) {

        super(String.format("The brand title '%s' does not exists, and can't be updated", brandTitle));
    }

}
