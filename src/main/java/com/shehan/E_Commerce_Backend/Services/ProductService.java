package com.shehan.E_Commerce_Backend.Services;

import com.shehan.E_Commerce_Backend.DTOs.AddProductDto;
import com.shehan.E_Commerce_Backend.DTOs.ProductDto;
import com.shehan.E_Commerce_Backend.DTOs.UserDto;
import com.shehan.E_Commerce_Backend.Mappers.AddProductMapper;
import com.shehan.E_Commerce_Backend.Mappers.ProductMapper;
import com.shehan.E_Commerce_Backend.entities.Category;
import com.shehan.E_Commerce_Backend.entities.Product;
import com.shehan.E_Commerce_Backend.repositories.CategoryRepository;
import com.shehan.E_Commerce_Backend.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final AddProductMapper addProductMapper;
    private final CategoryRepository categoryRepository;

    public List<ProductDto> getAllProducts(Byte categoryId) {

        List<Product> products;

        if (categoryId == null) {
            products = productRepository.findAllWithCategory();
        } else {
            products = productRepository.findByCategoryId(categoryId);
        }

        return products.stream()
                .map(productMapper::toDto)
                .toList();
    }

    public ProductDto getProductById(Long id) {

        return productRepository.findById(id)
                .map(productMapper::toDto)
                .orElse(null);
    }

    public AddProductDto addProduct(AddProductDto request) {

        Product product = addProductMapper.toEntity(request);

        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        product.setCategory(category);

        Product savedProduct = productRepository.save(product);

        return addProductMapper.toDto(savedProduct);

    }
}