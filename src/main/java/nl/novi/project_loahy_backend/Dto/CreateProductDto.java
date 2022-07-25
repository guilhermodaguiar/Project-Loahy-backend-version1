package nl.novi.project_loahy_backend.Dto;

import nl.novi.project_loahy_backend.model.FileUploadResponse;

import javax.persistence.OneToOne;

public class CreateProductDto {

    public String productName;
    public String productInformation;
    public Long productQuantity;

    @OneToOne
    FileUploadResponse file;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductInformation() {
        return productInformation;
    }

    public void setProductInformation(String productInformation) {
        this.productInformation = productInformation;
    }

    public Long getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Long productQuantity) {
        this.productQuantity = productQuantity;
    }

    public FileUploadResponse getFile() {
        return file;
    }

    public void setFile(FileUploadResponse file) {
        this.file = file;
    }
}
