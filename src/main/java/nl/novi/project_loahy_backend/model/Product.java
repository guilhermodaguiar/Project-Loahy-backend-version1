package nl.novi.project_loahy_backend.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.persistence.GeneratedValue;

@Entity
public class Product{

    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "product_sequence"),
                    @Parameter(name = "initial_value", value = "1003"),
                    @Parameter(name = "increment_size", value = "1")
            }
            )
    private Long productNumber;
    private String productName;
    private String productInformation;

    private Long productQuantity;


    @OneToOne
    FileUploadResponse file;

        
    public Product(Long productNumber, String productInformation, String productName, Long productQuantity) {
        this.productNumber = productNumber;
        this.productInformation = productInformation;
        this.productName = productName;
        this.productQuantity = productQuantity;
    }

    public Product() {

    }

    public Long getProductNumber() {
        return productNumber;
    }

    public String getProductInformation() {
        return productInformation;
    }

    public String getProductName() {
        return productName;
    }

    public Long getProductQuantity() {
        return productQuantity;
    }

    public FileUploadResponse getFile() {
        return file;
    }

    public void setProductNumber(Long productNumber) {
        this.productNumber = productNumber;
    }

    public void setProductQuantity(Long productQuantity) {
        this.productQuantity = productQuantity;
    }

        public void setProductInformation(String productInformation) {
            this.productInformation = productInformation;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public void setFile(FileUploadResponse productFile) {
            this.file = productFile;
        }
}


