package com.shehan.E_Commerce_Backend.Controllers;


import com.shehan.E_Commerce_Backend.DTOs.ProductDto;
import com.shehan.E_Commerce_Backend.Services.ProductService;
import com.shehan.E_Commerce_Backend.Services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public List<ProductDto> getAllProducts() {
       return productService.getAllProducts();
    }
}
