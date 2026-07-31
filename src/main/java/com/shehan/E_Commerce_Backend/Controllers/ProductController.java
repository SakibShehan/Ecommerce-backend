package com.shehan.E_Commerce_Backend.Controllers;


import com.shehan.E_Commerce_Backend.DTOs.AddProductDto;
import com.shehan.E_Commerce_Backend.DTOs.ProductDto;
import com.shehan.E_Commerce_Backend.DTOs.UserDto;
import com.shehan.E_Commerce_Backend.Mappers.AddProductMapper;
import com.shehan.E_Commerce_Backend.Mappers.ProductMapper;
import com.shehan.E_Commerce_Backend.Services.ProductService;
import com.shehan.E_Commerce_Backend.Services.UserService;
import com.shehan.E_Commerce_Backend.entities.Product;
import com.shehan.E_Commerce_Backend.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;
    private final AddProductMapper addProductMapper;

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


    @PostMapping("/products")
    public ResponseEntity<AddProductDto> addProduct(
            @RequestBody AddProductDto request,
            UriComponentsBuilder uriComponentsBuilder
    )
    {
        AddProductDto addproductDto = productService.addProduct(request);

        URI uri = uriComponentsBuilder
                .path("/products/{id}")
                .buildAndExpand(addproductDto.getCategoryId())
                .toUri();

        return ResponseEntity
                .created(uri)
                .body(addproductDto);
    }
}
