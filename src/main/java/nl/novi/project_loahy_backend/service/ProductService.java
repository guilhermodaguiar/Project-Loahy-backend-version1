package nl.novi.project_loahy_backend.service;

import nl.novi.project_loahy_backend.Dto.CreateProductDto;
import nl.novi.project_loahy_backend.Dto.ProductDto;
import nl.novi.project_loahy_backend.exeptions.ProductExistException;
import nl.novi.project_loahy_backend.exeptions.ProductNotFoundException;
import nl.novi.project_loahy_backend.model.FileUploadResponse;
import nl.novi.project_loahy_backend.model.Product;
import nl.novi.project_loahy_backend.repository.FileUploadRepository;
import nl.novi.project_loahy_backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    private final FileUploadRepository uploadRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, FileUploadRepository uploadRepository) {
        this.productRepository = productRepository;
        this.uploadRepository = uploadRepository;
    }


    public List<ProductDto> getAllProducts() {
        List<ProductDto> collection = new ArrayList<>();
        List<Product> list = productRepository.findAll();
        for (Product product : list) {
            collection.add(fromProduct(product));
        }
        return collection;
    }

    public ProductDto getProduct(Long productId) {
        new ProductDto();
        ProductDto productDto;
        Optional<Product> product = productRepository.findById(productId);
        if (product.isPresent()) {
            productDto = fromProduct(product.get());
        } else {
            throw new ProductNotFoundException(productId);
        }
        return productDto;
    }


    public ProductDto createProduct(CreateProductDto createProductDto) {

        final Optional<Product> productOptional =
                productRepository.findProductByProductNameIs(createProductDto.getProductName());
        if (productOptional.isPresent()) {
            throw new ProductExistException(createProductDto.getProductName());
        }

        Product product = new Product();
        product.setProductName(createProductDto.getProductName());
        product.setProductInformation(createProductDto.getProductInformation());
        product.setProductQuantity(createProductDto.getProductQuantity());
        product.setProductPrice(createProductDto.getProductPrice());
        product.setFile(createProductDto.getFile());

        final Product savedProduct = productRepository.save(product);

        ProductDto productDto = new ProductDto();
        productDto.setProductId(savedProduct.getProductId());
        productDto.setProductName(savedProduct.getProductName());
        productDto.setProductInformation(savedProduct.getProductInformation());
        productDto.setProductQuantity(savedProduct.getProductQuantity());
        productDto.setProductPrice(savedProduct.getProductPrice());
        productDto.setFile(savedProduct.getFile());

        return productDto;
    }


    public void updateProduct(Long productId, ProductDto newProduct) {
        if (!productRepository.existsById(productId)) throw new ProductNotFoundException(productId);
        Product product = productRepository.findById(productId).get();
        product.setProductName(newProduct.getProductName());
        product.setProductInformation(newProduct.getProductInformation());
        product.setProductPrice(newProduct.getProductPrice());
        product.setProductQuantity(newProduct.getProductQuantity());
        productRepository.save(product);
    }



    public void deleteProduct(Long productId) {
        productRepository.deleteProductByProductId(productId);
    }


    public void assignImageToProduct(String name, Long productId) {

        Optional<Product> optionalProduct = productRepository.findById(productId);
        Optional<FileUploadResponse> fileUploadResponse = uploadRepository.findByFileName(name);
        if (optionalProduct.isPresent() && fileUploadResponse.isPresent()) {
            FileUploadResponse image = fileUploadResponse.get();
            Product product = optionalProduct.get();
            product.setFile(image);
            productRepository.save(product);
        }
    }

    public static ProductDto fromProduct(Product product) {

        var productDto = new ProductDto();

        productDto.setProductName(product.getProductName());
        productDto.setProductInformation(product.getProductInformation());
        productDto.setProductQuantity(product.getProductQuantity());
        productDto.setProductPrice(product.getProductPrice());
        productDto.setFile(product.getFile());


        return productDto;

    }
}

