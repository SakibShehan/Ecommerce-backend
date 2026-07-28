package com.shehan.E_Commerce_Backend.Services;

import com.shehan.E_Commerce_Backend.DTOs.ProductDto;
import com.shehan.E_Commerce_Backend.Mappers.ProductMapper;
import com.shehan.E_Commerce_Backend.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    public List<ProductDto> getAllProducts() {

        return productRepository.findAll()
                .stream()
                .map((productMapper::toDto))
                .toList();
    }
}
