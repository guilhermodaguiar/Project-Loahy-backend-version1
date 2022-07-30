package nl.novi.project_loahy_backend.model;

import javax.persistence.*;

@Entity(name="products")
public class Product{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    @Column(name="product_name")
    private String productName;
    @Column(name="product_info")
    private String productInformation;
    @Column(name="product_price")
    private Long productPrice;
    @Column(name="product_qty")
    private Long productQuantity;

    @ManyToOne
    private Product products;

    @OneToOne
    FileUploadResponse file;


    public Product(String productInformation, String productName, Long productQuantity) {
        this.productInformation = productInformation;
        this.productName = productName;
        this.productQuantity = productQuantity;
    }
    public Product(Long productId, String productInformation, String productName, Long productQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.productQuantity = productQuantity;
    }

    public Product() {

    }

    public Long getProductId() {
        return productId;
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

    public void setProductId(Long productNumber) {
        this.productId = productNumber;
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

    public Long getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Long productPrice) {
        this.productPrice = productPrice;
    }

    public Product getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products = products;
    }
}


