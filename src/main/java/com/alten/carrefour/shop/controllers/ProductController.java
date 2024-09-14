package com.alten.carrefour.shop.controllers;

import com.alten.carrefour.shop.dtos.ProductDto;
import com.alten.carrefour.shop.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Tag(name="Product Management")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @Operation(summary = "Add new Product", responses = {
            @ApiResponse(responseCode = "200", description = "Product Added Successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server Error")
    })
    public ResponseEntity<ProductDto> addNewProduct(@Parameter(description = "Product information", required = true) @RequestBody ProductDto productDto) {
        ProductDto response = productService.addProduct(productDto);

        if (response != null) {
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.internalServerError().build();
    }

    @GetMapping
    @Operation(summary = "Retrieve list of Products", responses = {
            @ApiResponse(responseCode = "200", description = "List of Products")
    })
    public ResponseEntity<List<ProductDto>> allProduct() {
        return ResponseEntity.ok(productService.findAllProducts());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retrieve product by ID", responses = {
            @ApiResponse(responseCode = "200", description = "Product by ID"),
            @ApiResponse(responseCode = "404", description = "Product not Found")
    })
    public ResponseEntity<ProductDto> retrieveProduct(@Parameter(description = "ID Product", required = true) @PathVariable Long id) {

        ProductDto response = productService.findOneProduct(id);
        if (response != null) {
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update an existing product by ID", responses = {
            @ApiResponse(responseCode = "200", description = "Update Product by ID"),
            @ApiResponse(responseCode = "404", description = "Product not Found")
    })
    public ResponseEntity<ProductDto> updateProduct(@Parameter(description = "ID Product", required = true) @PathVariable Long id,
                                                    @Parameter(description = "Updated information product", required = true) @RequestBody ProductDto productDto) {

        ProductDto response = productService.updateProduct(id, productDto);
        if (response != null) {
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Delete product by ID", responses = {
            @ApiResponse(responseCode = "200", description = "Operation Successfully")
    })
    public ResponseEntity<Void> deleteProduct(@Parameter(description = "ID Product", required = true) @PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }
}
