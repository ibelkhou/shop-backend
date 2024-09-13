package com.alten.carrefour.shop.dtos;

import com.alten.carrefour.shop.enums.InventoryStatus;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {

    private Long id;
    private String code;
    private String name;
    private String description;
    private String image;
    private String category;
    private BigDecimal price;
    private Long quantity;
    private String internalReference;
    private Long shellId;
    private InventoryStatus inventoryStatus;
    private Integer rating;
    private Long createdAt;
    private Long updatedAt;
}
