package nl.novi.project_loahy_backend.service;

import nl.novi.project_loahy_backend.exeptions.RecordNotFoundException;
import nl.novi.project_loahy_backend.model.FileUploadResponse;
import nl.novi.project_loahy_backend.model.Product;
import nl.novi.project_loahy_backend.repository.FileUploadRepository;
import nl.novi.project_loahy_backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    private final FileUploadRepository uploadRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, FileUploadRepository uploadRepository){
        this.productRepository = productRepository;
        this.uploadRepository = uploadRepository;
    }

    public List<Product> getProducts() {

        return productRepository.findAll();

    }

    public Product getProduct(Long productNumber) {

        Optional<Product> product = productRepository.findById(productNumber);

        if(product.isPresent()) {

            return product.get();

        } else {

            throw new RecordNotFoundException("Product does not exist");

        }

    }

    public Product saveProduct(Product product) {

        return productRepository.save(product);

    }

    public Product updateProduct(Long productNumber, Product product) {

        Optional<Product> optionalProduct = productRepository.findById(productNumber);

        if (optionalProduct.isPresent()) {

            Product old = optionalProduct.get();
            if(product.getProductNumber() != null){
                old.setProductNumber(productNumber);
            }
            if(product.getProductName() != null){
                old.setProductName(product.getProductName());
            }
            if(product.getProductInformation() != null){
                old.setProductInformation(product.getProductInformation());
            }
            if(product.getProductQuantity() != null){
                old.setProductQuantity(product.getProductQuantity());
            }
            if(old.getFile() != null && product.getFile() != null){
                old.setFile(product.getFile());
            } else if (old.getFile() != null) {
                old.setFile(old.getFile());
            }

            return productRepository.save(old);

        } else {

            throw new RecordNotFoundException("Product does not exist");

        }

    }

    public void deleteProduct(Long productNumber) {

        productRepository.deleteById(productNumber);

    }

    public void assignImageToProduct(String name, Long productNumber) {

        Optional<Product> optionalProduct = productRepository.findById(productNumber);

        Optional<FileUploadResponse> fileUploadResponse = uploadRepository.findByFileName(name);

        if (optionalProduct.isPresent() && fileUploadResponse.isPresent()) {

            FileUploadResponse photo = fileUploadResponse.get();

            Product product = optionalProduct.get();

            product.setFile(photo);

            productRepository.save(product);

        }

    }
}

