package nl.novi.project_loahy_backend.service;

import nl.novi.project_loahy_backend.Dto.CreateProductDto;
import nl.novi.project_loahy_backend.Dto.ProductDto;
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
    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    private final FileUploadRepository uploadRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, FileUploadRepository uploadRepository){
        this.productRepository = productRepository;
        this.uploadRepository = uploadRepository;
    }

    //later aanpassen
    public List<ProductDto> getProducts() {

        return productRepository.findAll();

    }
    //later aanpassen
    public Product getProduct(Long productNumber) {

        Optional<ProductDto> product = productRepository.findById(productNumber);

        if(product.isPresent()) {

            return product.get();

        } else {

            throw new RecordNotFoundException("Product does not exist");

        }

    }

    public ProductDto createProduct(CreateProductDto createProductDto) {

        Product product = new Product();
        product.setProductName(createProductDto.getProductName());
        product.setProductInformation(createProductDto.getProductInformation());
        product.setProductQuantity(createProductDto.getProductQuantity());

        final Product savedProduct = productRepository.save(product);

        ProductDto productDto = new ProductDto();
        productDto.setProductNumber(savedProduct.getProductNumber());
        productDto.setProductName(savedProduct.getProductName());
        productDto.setProductInformation(savedProduct.getProductInformation());
        productDto.setProductQuantity(savedProduct.getProductQuantity());

        return productDto;
    }

    //later aanpassen
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

    //later aanpassen
    public void assignImageToProduct(String name, Long productNumber) {

        Optional<Product> optionalProduct = productRepository.findById(productNumber);

        Optional<FileUploadResponse> fileUploadResponse = uploadRepository.findByFileName(name);

        if (optionalProduct.isPresent() && fileUploadResponse.isPresent()) {

            FileUploadResponse image = fileUploadResponse.get();

            Product product = optionalProduct.get();

            product.setFile(image);

            productRepository.save(product);

        }

    }
}

