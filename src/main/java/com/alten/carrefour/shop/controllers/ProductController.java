package com.alten.carrefour.shop.controllers;

import com.alten.carrefour.shop.dtos.ProductDto;
import com.alten.carrefour.shop.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
//@Tag(name="Product Management")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    //@Operation(summary = "Add new Product")
    public ResponseEntity<ProductDto> addNewProduct(@RequestBody ProductDto productDto) {
        ProductDto response = productService.addProduct(productDto);

        if (response != null) {
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.internalServerError().build();
    }

    @GetMapping
    //@Operation(summary = "Retreive list of Products")
    public ResponseEntity<List<ProductDto>> allProduct() {
        return ResponseEntity.ok(productService.findAllProducts());
    }

    @GetMapping("/{id}")
    //@Operation(summary = "Retrieve product by ID")
    public ResponseEntity<ProductDto> retrieveProduct(@PathVariable Long id) {

        ProductDto response = productService.findOneProduct(id);
        if (response != null) {
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    //@Operation(summary = "Update an existing product by ID")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {

        ProductDto response = productService.updateProduct(id, productDto);
        if (response != null) {
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    //@Operation(summary = "Delete product by ID")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }
}
