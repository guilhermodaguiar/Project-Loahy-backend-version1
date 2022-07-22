package nl.novi.project_loahy_backend.controller;

import nl.novi.project_loahy_backend.Dto.ProductDto;
import nl.novi.project_loahy_backend.model.FileUploadResponse;
import nl.novi.project_loahy_backend.model.Product;
import nl.novi.project_loahy_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final ImageController imageController;

    @Autowired
    public ProductController(ProductService productService, ImageController imageController) {
        this.productService = productService;
        this.imageController = imageController;
    }

    @GetMapping
    @Transactional
    public List<Product> getProducts() {

        List<Product> products;


        products = productService.getProducts();


        return products;

    }

    @GetMapping("/{product-id}")
    @Transactional
    public Product getProduct(@PathVariable("product-id") Long productNumber) {

        return productService.getProduct(productNumber);

    }

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody CreatedProductDto createdProductDto) {

        final ProductDto createdProduct = productService.createProduct(createdProductDto)

        return ResponseEntity.ok(createdProduct);
    }

    @PutMapping("/{productNumber}")
    public Product updateProduct(@PathVariable Long productNumber, @RequestBody Product product) {

        return productService.updateProduct(productNumber, product);

    }

    @DeleteMapping("/{product-id}")
    public void deleteProduct(@PathVariable("product-id") Long productNumber) {

        productService.deleteProduct(productNumber);

    }

    @PostMapping("/{product-id}/product-image")
    public void assignPhotoToProduct(@PathVariable("product-id") Long productNumber,
                                     @RequestBody MultipartFile file) {

        FileUploadResponse productImage = imageController.singleFileUpload(file);

        productService.assignImageToProduct(productImage.getFileName(), productNumber);

    }
}
