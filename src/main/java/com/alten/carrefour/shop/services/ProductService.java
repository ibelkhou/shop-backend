package com.alten.carrefour.shop.services;

import com.alten.carrefour.shop.dtos.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> findAllProducts();
    ProductDto findOneProduct(Long idProduct);
    ProductDto addProduct(ProductDto productDto);
    ProductDto updateProduct(Long id, ProductDto productDto);
    void deleteProduct(Long idProduct);
}
