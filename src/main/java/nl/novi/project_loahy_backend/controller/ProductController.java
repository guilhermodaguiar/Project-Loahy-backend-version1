package nl.novi.project_loahy_backend.controller;

import nl.novi.project_loahy_backend.Dto.CreateProductDto;
import nl.novi.project_loahy_backend.Dto.ProductDto;
import nl.novi.project_loahy_backend.model.FileUploadResponse;
import nl.novi.project_loahy_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.net.URI;
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
    public ResponseEntity<List<ProductDto>> getAllProducts() {

        List<ProductDto> productsDto = productService.getAllProducts();

        return ResponseEntity.ok().body(productsDto);
    }


    @GetMapping(path="/{id}")
    @Transactional
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long productId) {

        ProductDto optionalProduct = productService.getProduct(productId);

        return ResponseEntity.ok().body(optionalProduct);

    }

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody CreateProductDto createdProductDto) {

        final ProductDto createdProduct = productService.createProduct(createdProductDto);

        final URI location = URI.create("/products/" + createdProduct.getProductId());
        return ResponseEntity
                .created(location)
                .body(createdProduct);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct (@PathVariable("id") Long productId, @RequestBody ProductDto productDto) {

        productService.updateProduct(productId, productDto);
        return ResponseEntity.noContent().build();

    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ProductDto> deleteProduct(@PathVariable("id") Long productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }


    @PostMapping("/{id}/image")
    public void assignImageToProduct(@PathVariable("id") Long productId,
                                     @RequestBody MultipartFile file) {

        FileUploadResponse productImage = imageController.singleFileUpload(file);

        productService.assignImageToProduct(productImage.getFileName(), productId);

    }

}
