package com.alten.carrefour.shop.services.impl;

import com.alten.carrefour.shop.domains.Product;
import com.alten.carrefour.shop.dtos.ProductDto;
import com.alten.carrefour.shop.mappers.ProductMapper;
import com.alten.carrefour.shop.repositories.ProductRepository;
import com.alten.carrefour.shop.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductDto> findAllProducts() {
        return productRepository.findAll().stream().map(productMapper::mapEntity).collect(Collectors.toList());
    }

    @Override
    public ProductDto findOneProduct(Long idProduct) {
        return productRepository.findById(idProduct).map(productMapper::mapEntity).orElse(null);
    }

    @Override
    public ProductDto addProduct(ProductDto productDto) {
        Product product = productRepository.save(productMapper.mapDto(productDto));
        if (product != null) {
            return productMapper.mapEntity(product);
        } else {
            return null;
        }
    }

    @Override
    public ProductDto updateProduct(Long idProduct, ProductDto productDto) {
        Optional<Product> product = productRepository.findById(idProduct);
        if (product.isPresent()) {
            Product productEntity = product.get();
            productMapper.updateProductFromDto(productDto, productEntity);

            productRepository.save(productEntity);

            return productMapper.mapEntity(productEntity);
        }
        return null;
    }

    @Override
    public void deleteProduct(Long idProduct) {
        productRepository.deleteById(idProduct);
    }
}
