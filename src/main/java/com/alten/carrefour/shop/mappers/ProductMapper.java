package com.alten.carrefour.shop.mappers;

import com.alten.carrefour.shop.domains.Product;
import com.alten.carrefour.shop.dtos.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapper {

    ProductDto mapEntity(Product product);
    Product mapDto(ProductDto productDto);
    void updateProductFromDto(ProductDto productDto, @MappingTarget Product product);
}
