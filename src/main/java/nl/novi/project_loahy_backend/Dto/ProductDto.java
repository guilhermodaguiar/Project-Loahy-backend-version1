package nl.novi.project_loahy_backend.Dto;

import lombok.Data;
import nl.novi.project_loahy_backend.model.FileUploadResponse;

import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class ProductDto {

    private Long ProductNumber;
    @NotBlank
    private String productName;
    @Size(min=10, max=800, message = "product information must be between 10 and 800 characters")
    private String productInformation;
    @Min(1)
    @Max(20)
    private Long productQuantity;

    private Long productPrice;

    @OneToOne
    FileUploadResponse file;

    public Long getProductNumber() {
        return ProductNumber;
    }

    public void setProductNumber(Long productNumber) {
        ProductNumber = productNumber;
    }

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

    public Long getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Long productPrice) {
        this.productPrice = productPrice;
    }
}
