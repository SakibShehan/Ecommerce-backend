package com.shehan.E_Commerce_Backend.Controllers;


import com.shehan.E_Commerce_Backend.DTOs.ProductDto;
import com.shehan.E_Commerce_Backend.DTOs.UserDto;
import com.shehan.E_Commerce_Backend.Services.ProductService;
import com.shehan.E_Commerce_Backend.Services.UserService;
import com.shehan.E_Commerce_Backend.entities.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public List<ProductDto> getAllProducts(
            @RequestParam(name = "categoryId", required = false) Byte categoryId
    )
    {
           return  productService.getAllProducts(categoryId);

    }

    @GetMapping("/products/{id}")
    public ProductDto getUserById(@PathVariable Long id) {
        return productService.getProductById(id);
    }
}
