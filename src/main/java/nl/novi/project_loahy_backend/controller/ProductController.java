package nl.novi.project_loahy_backend.controller;

import nl.novi.project_loahy_backend.Dto.ContactDto;
import nl.novi.project_loahy_backend.Dto.CreateProductDto;
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
    public ResponseEntity<List<ProductDto>> getProducts() {

        List<ProductDto> productsDto;
        productsDto = productService.getProducts();

        return ResponseEntity.ok(productsDto);

    }

    //later aanpassen
    @GetMapping("/{product-number}")
    @Transactional
    public ResponseEntity<ProductDto> getProduct(@PathVariable("product-number") Long productNumber) {

        ProductDto optionalProduct = productService.getProduct(productNumber);
        return ResponseEntity.ok().body(optionalProduct);

    }

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody CreateProductDto createdProductDto) {

        final ProductDto createdProduct = productService.createProduct(createdProductDto);

        return ResponseEntity.ok(createdProduct);
    }

    @PutMapping("/{productNumber}")
    public Product updateProduct(@PathVariable Long productNumber, @RequestBody Product product) {

        return productService.updateProduct(productNumber, product);

    }


    @DeleteMapping(path = "/{product-id}")
    public ResponseEntity<ProductDto> deleteContact(@PathVariable("product-id") Long productNumber) {
        productService.deleteProduct(productNumber);
        return ResponseEntity.noContent().build();
    }


    @PostMapping("/{product-id}/product-image")
    public void assignImageToProduct(@PathVariable("product-id") Long productNumber,
                                     @RequestBody MultipartFile file) {

        FileUploadResponse productImage = imageController.singleFileUpload(file);

        productService.assignImageToProduct(productImage.getFileName(), productNumber);

    }
}
