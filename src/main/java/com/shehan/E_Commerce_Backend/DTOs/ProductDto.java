package com.shehan.E_Commerce_Backend.DTOs;


import com.shehan.E_Commerce_Backend.entities.Category;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDto {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Byte categoryId;
}
