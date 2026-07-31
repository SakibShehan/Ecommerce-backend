package com.shehan.E_Commerce_Backend.DTOs;


import com.shehan.E_Commerce_Backend.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProductDto {

    private String name;
    private String description;
    private BigDecimal price;
    private Byte categoryId;
}
